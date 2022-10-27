package com.example.Account.service;

import com.example.Account.domain.Account;
import com.example.Account.domain.AccountUser;
import com.example.Account.exception.AccountException;
import com.example.Account.repository.AccountRepository;
import com.example.Account.repository.AccountUserRepository;
import com.example.Account.type.AccountStatus;
import com.example.Account.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static com.example.Account.type.AccountStatus.IN_USE;

@Service
@RequiredArgsConstructor // 필요한 것만 들어가는 생성자 만들어주는 롬복 - final
public class AccountService {
    //생성자가 아니면 final은 변경 할 수 없기 때문에 무조건 생성자에 들어가야함
    private final AccountRepository accountRepository;
    private final AccountUserRepository accountUserRepository;

    /**
     *  사용자가 있는지 조회
     *  계좌의 번호를 생성하고
     *  계좌를 저장하고, 그 정보를 넘긴다.
     */
    @Transactional
    public Account createAccount(Long userId, Long initialBalnce) {
        //DB 저장을 위해선 account 엔티티 생성 필요
        AccountUser accountUser = accountUserRepository.findById(userId)
                .orElseThrow(() -> new AccountException(ErrorCode.USER_NOT_FOUND));//사용자가 없음 exception


        String newAccountNumber = accountRepository.findFirstByOrderByIdDesc()//Optional을 쓰면 있는 경우에 선택을 해서 가져올 수 있음
                .map(account -> (Integer.parseInt(account.getAccountNumber())) +1 +"")
                .orElse("1000000000"); //현재 계좌번호가 없으면 이 값을 줌

        return accountRepository.save(
                Account.builder()
                        .accountUser(accountUser)
                        .accountStatus(IN_USE)
                        .accountNumber(newAccountNumber)
                        .balance(initialBalnce)
                        .registeredAt(LocalDateTime.now())
                        .build()
        );


    }

    @Transactional
    public Account getAccount(Long id){
        return accountRepository.findById(id).get();
    }

}
