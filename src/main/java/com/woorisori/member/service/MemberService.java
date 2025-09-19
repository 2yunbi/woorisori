package com.woorisori.member.service;

import com.woorisori.member.domain.member.Member;
import com.woorisori.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    /**
     * 회원가입
     *
     * @param form
     * @return getId()
     */
    @Transactional public Long join(Member form) {
        validateDuplicateMember(form);

        Member member = new Member();
        member.setEmpNo(form.getEmpNo());
        member.setUserName(form.getUserName());
        member.setPassword(passwordEncoder.encode(form.getPassword()));
        member.setEmail(form.getEmail());
        member.setRole("USER");

        memberRepository.save(member);

        return member.getId();
    }


    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmpNo(member.getEmpNo())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 사번입니다.");
                });
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이메일 주소입니다.");
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
    public boolean isEmailExists(String email) {
        return memberRepository.findByEmail(email).isPresent();
    }

    public Member login(String inputEmpNo, String inputPassword) {
        return memberRepository.findByEmpNo(inputEmpNo)
                .filter(member -> member.getPassword() != null &&
                        passwordEncoder.matches(inputPassword, member.getPassword()))
                .orElse(null);
    }
}
