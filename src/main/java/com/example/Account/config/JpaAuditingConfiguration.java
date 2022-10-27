package com.example.Account.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfiguration { // 클래스 자체가 스프링 어플리케이션 띄울때 자동으로 빈 등록
    //DB에 데이터 저장 및 업데이트 어노테이션들이 작동할 수 있도록 해줌


}
