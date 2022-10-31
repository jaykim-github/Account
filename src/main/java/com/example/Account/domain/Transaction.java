package com.example.Account.domain;

import com.example.Account.type.TransactionResultType;
import com.example.Account.type.TransactionType;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transaction extends BaseEntity{//테이블과 일대일로 매핑되는 엔티티 객채ㅔ

    @Enumerated(EnumType.STRING)//이넘타입은 0123 같이 숫자로 들어가서 String으로 지정을해줌
    private TransactionType transactionType;
    @Enumerated(EnumType.STRING)
    private TransactionResultType transactionResultType;

    @ManyToOne
    private Account account;
    private Long amount;
    private Long balanceSnapshot;

    private String transactionId;
    private LocalDateTime transactedAt;

}
