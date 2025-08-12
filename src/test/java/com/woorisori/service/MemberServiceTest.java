package com.woorisori.service;

import com.woorisori.domain.member.Member;
import com.woorisori.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository japMemberRepository;


    void 회원가입() {
        Member member = new Member();
        member.setEmpNo("20250001");

        Long saveId = memberService.join(member);

    }
}
