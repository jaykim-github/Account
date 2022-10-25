package com.example.Account.repository;

import com.example.Account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    //DB에 등록하기위한 클래스

}
