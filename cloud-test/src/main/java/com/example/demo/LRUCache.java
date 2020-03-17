package com.example.demo;


import java.util.LinkedHashMap;
import java.util.Objects;

public class LRUCache<K,V> extends LinkedHashMap<K,V>{

    private final int maxCapacity;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    LRUCache(){
         this(5);
    }

    LRUCache(int maxCapacity) {
        super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
        this.maxCapacity = maxCapacity;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return size() > maxCapacity;
    }

}
