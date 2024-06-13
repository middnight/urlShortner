package com.url.shortner.url_shortner.service.cache;

import java.util.Optional;

public interface Cache<K, V> {
  int size();

  boolean put(K key, V value);

  Optional<V> get(K key);

  boolean invalidate(K key);

  void clear();
}
