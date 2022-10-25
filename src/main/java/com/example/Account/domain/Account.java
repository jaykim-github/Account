package com.example.Account.domain;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account {//설정 클래스
    @Id
    @GeneratedValue
    private Long id;

    private String accountNumber;

    @Enumerated(EnumType.STRING) //enum의 스트링 값을 디비에 저장
    private AccountStatus accountStatus;
}
