package com.url.shortner.url_shortner.service;

import com.url.shortner.url_shortner.dal.URLRepository;
import com.url.shortner.url_shortner.domain.URLRecord;
import com.url.shortner.url_shortner.exception.UrlServiceException;
import com.url.shortner.url_shortner.service.cache.LRUCache;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class URLShorteningServiceImpl implements URLShorteningService {
  @Value("${url.prefix}")
  private String prefixUrl;

  @Value("${url.generator.strategy}")
  private String urlGenerationStrategy;

  private final ShortUrlGeneratorStrategyProvider shortUrlGeneratorStrategyProvider;

  private static final String SEPARATOR = "/";
  private final URLRepository urlRepository;
  private final LRUCache<String, URLRecord> lruCache = new LRUCache<>(2000);

  @Override
  public URLRecord create(String url) {
    String shortUrl =
        shortUrlGeneratorStrategyProvider.getByStrategy(urlGenerationStrategy).generate(url);
    URLRecord record =
        URLRecord.builder()
            .url(url)
            .shortUrl(shortUrl)
            .createdOn(System.currentTimeMillis())
            .lastUpdateOn(System.currentTimeMillis())
            .build();
    urlRepository.save(record);
    // before returning add the host details in short url
    record.setShortUrl(prefixUrl + SEPARATOR + record.getShortUrl());
    return record;
  }

  @Override
  public URLRecord find(String shortUrl) {
    // first check in cache else goto db find the value and put in cache and return
    Optional<URLRecord> optionalURLRecord = lruCache.get(shortUrl);
    if (optionalURLRecord.isPresent()) {
      return optionalURLRecord.get();
    }

    Page<URLRecord> urlRecordPage = urlRepository.findByShortUrl(shortUrl, Pageable.ofSize(1));
    if (urlRecordPage.getContent().isEmpty()) {
      throw new UrlServiceException("No mapping url found for given short url : " + shortUrl);
    }
    URLRecord urlRecord = urlRecordPage.getContent().get(0);
    lruCache.put(shortUrl, urlRecord);
    // whenever putting value in cache update lastupdatedOn in record, I know not perfect but, it'll
    // do the job for now
    urlRecord.setLastUpdateOn(System.currentTimeMillis());
    urlRepository.save(urlRecord);
    return urlRecord;
  }

  @Override
  public URLRecord delete(String shortUrl) {

    URLRecord url = find(shortUrl);
    urlRepository.delete(url);
    lruCache.invalidate(shortUrl);
    return url;
  }

  @Scheduled(fixedDelay = 24 * 60 * 60 * 1000)
  @Override
  public void deleteExpired() {
    LocalDateTime counter = LocalDateTime.now().minusMonths(2);
    long mills = counter.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    urlRepository.deleteAllByLastUpdateOnLessThan(mills);
    lruCache.clear();
  }
}
