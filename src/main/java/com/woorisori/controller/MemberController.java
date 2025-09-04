package com.woorisori.controller;

import com.woorisori.domain.member.Member;
import com.woorisori.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setEmpNo(form.getEmpNo());
        member.setUserName(form.getUserName());
        member.setPassword(form.getPassword());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members/login")
    public String loginForm() {
        return "members/login";
    }

    @PostMapping("/members/login")
    public String login(@RequestParam String empNo, @RequestParam String password, Model model, HttpServletRequest request) {
        Member member = memberService.login(empNo, password);

        // 1. 로그인 검증
        if (member == null) {
            model.addAttribute("result", "no");
            return "members/login";
        }

        // 2. 세션 값 생성
        HttpSession session = request.getSession();

        // 3. 세션 값 저장
        session.setAttribute("loginMember", member);

        return "redirect:/";

    }

    @PostMapping("/members/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
