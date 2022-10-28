package com.example.Account.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class RedisTestService {
    private final RedissonClient redissonClient;

    public String getLock() {
        RLock lock = redissonClient.getLock("sampleLock");

        try {
            // 3초간 락을 가지고 있다는 뜻
            boolean isLock = lock.tryLock(1, 3, TimeUnit.SECONDS);

            if (!isLock) {
                log.error("======================Lock acquisition failed=========");
                return "Lock failed";
            }
        } catch (Exception e) {
            log.error("Redis lockl failed");
        }

        return "Lock success";
    }
}
