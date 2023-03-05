package com.test.onlyTest;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CaffeineTest {

    private static final Cache<String, String> cache = Caffeine.newBuilder()
            //惰性删除，使用Weak类型以便于GC回收
            .weakKeys()
            .weakValues()
            .expireAfterWrite(10, TimeUnit.SECONDS)
            .initialCapacity(32)
            .maximumSize(1000)
            .build();

    @Test
    public void CaffeineTest() throws InterruptedException {

        String V = "Test-Value";
        cache.put("TestKey", V);

        String value = cache.getIfPresent("TestKey");
        log.info("Value: {}", value);
        // 查找一个缓存元素， 没有查找到的时候返回null
        Thread.sleep(10000);
        value = cache.getIfPresent("TestKey");
        log.info("Value: {}", value);

    }
}
