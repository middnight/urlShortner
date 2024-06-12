package com.url.shortner.url_shortner.service;

import com.url.shortner.url_shortner.dal.URLRepository;
import com.url.shortner.url_shortner.domain.URLRecord;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class URLShorteningServiceImpl implements URLShorteningService {
  @Value("${url.prefix}")
  private String prefixUrl;

  private final String SEPARATOR = "/";
  private final URLRepository urlRepository;

  @Override
  public URLRecord create(String url) {
    String shortUrl = prefixUrl + SEPARATOR + UUID.randomUUID().toString().replace("-", "");
    URLRecord record = URLRecord.builder().url(url).shortUrl(shortUrl).build();
    urlRepository.save(record);
    return record;
  }

  @Override
  public URLRecord find(String shortUrl) {
    Page<URLRecord> urlRecordPage = urlRepository.findByShortUrl(shortUrl, Pageable.ofSize(1));
    return urlRecordPage.getContent().get(0);
  }

  @Override
  public URLRecord delete(String shortUrl) {

    URLRecord url = find(shortUrl);
    urlRepository.delete(url);
    return url;
  }
}
