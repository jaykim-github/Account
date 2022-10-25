package com.example.Account.controller;

import com.example.Account.domain.Account;
import com.example.Account.service.AccountService;
import com.example.Account.service.RedisTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    //레이어드 아키텍쳐는 외부에서는 컨트롤러로만 접속을 하고,컨트롤러는 서비스로 접속,서비스는 레파지토리로 접속을 하는 순차적, 계층적 구조
    private final AccountService accountService; // 의존성 주입
    private final RedisTestService redisTestService;

    @GetMapping("/get-lock")
    public String getLock(){
        return redisTestService.getLock();
    }

    @GetMapping("/create-account")
    public String creatAccount(){
        accountService.createAccount();
        return "success";
    }


    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Long id){
        return accountService.getAccount(id);
    }
}
