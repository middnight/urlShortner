package com.url.shortner.url_shortner.service.cache;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class LRUCache<K, V> implements Cache<K, V> {

  @Getter
  @AllArgsConstructor
  static class CacheElement<K, V> {
    private final K key;
    private final V value;
  }

  private final int size;
  private final Deque<CacheElement<K, V>> linkedList;
  private final Map<K, CacheElement<K, V>> nodeMap;

  public LRUCache(int size) {
    if (size > 10000) {
      throw new RuntimeException("Cache size exceeds allowed limit, Please reduce the size");
    }
    this.size = size;
    linkedList = new LinkedList<>();
    nodeMap = new ConcurrentHashMap<>();
  }

  @Override
  public boolean put(K key, V value) {

    if (this.nodeMap.containsKey(key)) {
      CacheElement<K, V> element = nodeMap.get(key);
      linkedList.remove(element);
      linkedList.addFirst(element);
    } else {
      if (linkedList.size() >= size) {
        linkedList.removeLast();
      }
      CacheElement<K, V> newElement = new CacheElement<K, V>(key, value);
      nodeMap.put(key, newElement);
      linkedList.addFirst(newElement);
    }
    return true;
  }

  @Override
  public Optional<V> get(K key) {
    if (nodeMap.containsKey(key)) {
      CacheElement<K, V> element = nodeMap.get(key);
      linkedList.remove(element);
      linkedList.addFirst(element);
      return Optional.of(element.getValue());
    } else {
      return Optional.empty();
    }
  }

  @Override
  public boolean invalidate(K key) {
    if (nodeMap.containsKey(key)) {
      CacheElement<K, V> element = nodeMap.get(key);
      linkedList.remove(element);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void clear() {
    nodeMap.clear();
    linkedList.clear();
  }

  @Override
  public int size() {
    return size;
  }
}
