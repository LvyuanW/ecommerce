package com.uoa.ecommerce.util;

import java.util.concurrent.atomic.AtomicLong;

public class SnowflakeIdGenerator {
    private static final long START_EPOCH = 1609459200000L; // 2021-01-01
    private static final AtomicLong COUNTER = new AtomicLong();

    public static String generateId() {
        long timestamp = System.currentTimeMillis() - START_EPOCH;
        long sequence = COUNTER.getAndIncrement() % 1000;
        return String.valueOf((timestamp << 10) | sequence);
    }
}