package com.example.Account.service;

import com.example.Account.domain.Account;
import com.example.Account.domain.AccountStatus;
import com.example.Account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor // 필요한 것만 들어가는 생성자 만들어주는 롬복 - final
public class AccountService {
    //생성자가 아니면 final은 변경 할 수 없기 때문에 무조건 생성자에 들어가야함
    private final AccountRepository accountRepository;

    @Transactional
    public void createAccount() {
        //DB 저장을 위해선 account 엔티티 생성 필요
        Account account = Account.builder()
                .accountNumber("40000")
                .accountStatus(AccountStatus.IN_USE)
                .build();

        accountRepository.save(account);
    }

    @Transactional
    public Account getAccount(Long id){
        return accountRepository.findById(id).get();
    }

}
