package com.url.shortner.url_shortner.dal;

import com.url.shortner.url_shortner.domain.URLRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface URLRepository extends ElasticsearchRepository<URLRecord, String> {
  Page<URLRecord> findByShortUrl(String shortUrl, Pageable pageable);
}
