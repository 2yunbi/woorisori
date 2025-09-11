package com.woorisori.service;

import com.woorisori.member.domain.member.Member;
import com.woorisori.member.service.MemberService;
import com.woorisori.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired MemberRepository japMemberRepository;


    @Test
    void join() {
        Member member = new Member();
        member.setEmpNo("20250001");
        member.setPassword("12345678");
        member.setUserName("이윤비");
        member.setEmail("dbsql1014@naver.com");

        //Long saveId = memberService.join(form);
        //System.out.println("saveId = " + saveId);
    }

    void login() {
    }
}
