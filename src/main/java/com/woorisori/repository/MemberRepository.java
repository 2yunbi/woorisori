package com.woorisori.repository;

import com.woorisori.domain.member.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findByID(Long id);
    Optional<Member> findByEmpNo(String loginId);
    List<Member> findAll();

}
