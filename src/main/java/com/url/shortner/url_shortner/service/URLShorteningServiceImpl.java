package com.url.shortner.url_shortner.service;

import com.url.shortner.url_shortner.domain.URLRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class URLShorteningServiceImpl implements URLShorteningService{
    @Value("url.prefix")
    private final String prefixUrl;
    @Override
    public URLRecord create(String url) {
        return null;
    }

    @Override
    public URLRecord find(String shortUrl) {
        return null;
    }

    @Override
    public URLRecord delete(String shortUrl) {
        return null;
    }
}
