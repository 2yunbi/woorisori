package com.woorisori.repository;

import com.woorisori.domain.member.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JPAMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JPAMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findByID(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByEmpNo(String loginId) {
        List<Member> result = em.createQuery("select m.empNo, m.userName from Member m where m.empNo = :empNo", Member.class).setParameter("empNo", loginId).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
