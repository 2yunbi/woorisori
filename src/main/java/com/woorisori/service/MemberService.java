package com.woorisori.service;

import com.woorisori.domain.member.Member;
import com.woorisori.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     *
     * @param member
     * @return
     */
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmpNo(member.getEmpNo())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     *
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public boolean isEmpNoExists(String empNo) {
        return memberRepository.findByEmpNo(empNo).isPresent();
    }

    public Member login(String inputEmpNo, String inputPassword) {
        return memberRepository.findByEmpNo(inputEmpNo)
                .filter(member -> member.getPassword().equals(inputPassword))
                .orElse(null);
    }

}
