package com.example.Account.dto;

import com.example.Account.domain.Account;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto { // 엔티티 클래스와 거의 유사하지만, 딱 필요한 것만 넣어서 구현한다.
    //컨트롤러에서 필요한 정보들을 담음

    private Long userId;
    private String accountNumber;
    private Long balance;

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

    //생성자를 쓰지 않고, static을 사용하여 변환한다.
    //DTO는 앤티티를 가지고 만들기 때문에, 앤티티를 가지고 이 dto로 변환해줄 수 있게 static한 메소드를 만들어주는게 가독성과 안정서에 좋다.
    public static AccountDto fromEntity(Account account){
        return AccountDto.builder()
                .userId(account.getAccountUser().getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .registeredAt(account.getRegisteredAt())
                .unRegisteredAt(account.getUnRegisteredAt())
                .build();
    }
}
