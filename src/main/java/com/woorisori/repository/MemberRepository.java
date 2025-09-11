package com.woorisori.repository;

import com.woorisori.member.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findByID(Long id);
    Optional<Member> findByEmpNo(String loginId);
    List<Member> findAll();

}
