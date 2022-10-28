package com.example.Account.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountInfo {
    //전용 DTO를 만들지 않으면 나중에 복잡한 상황이 생기면서 장애가 발생하게됨.
    private String accountNumber;
    private Long balance;

}
