package com.url.shortner.url_shortner.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class URLRecord {
    private String url;
    private String shortUrl;
}
