package com.woorisori.service;

import com.woorisori.domain.member.Member;
import com.woorisori.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 회원가입
     *
     * @param member
     * @return getId()
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);

        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setRole("USER");
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
