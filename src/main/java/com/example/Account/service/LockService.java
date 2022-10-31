package com.example.Account.service;

import com.example.Account.aop.AccountLock;
import com.example.Account.exception.AccountException;
import com.example.Account.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class LockService {
    private final RedissonClient redissonClient;

    public void lock(String accountNumber) {
        RLock lock = redissonClient.getLock(getLockKey(accountNumber)); //락에 쓰는 키
        log.debug("Trying lock for accountNumber : {}", accountNumber);

        try {
            // 3초간 락을 가지고 있다는 뜻
            boolean isLock = lock.tryLock(1, 15, TimeUnit.SECONDS);

            if (!isLock) {
                log.error("======================Lock acquisition failed=========");
                throw new AccountException(ErrorCode.ACCOUNT_TRANSACTION_LOCK);
            }
        }catch(AccountException e){
           throw e;
        }  catch (Exception e) {
            log.error("Redis lock failed");
        }
    }


    public void unlock(String accountNumber){
        log.debug("Unlock for accountNumber : {}", accountNumber);
        redissonClient.getLock(getLockKey(accountNumber)).unlock();//락을 가져와서 언락

    }
    private static String getLockKey(String accountNumber) {
        return "ACLK:" + accountNumber;
    }
}
