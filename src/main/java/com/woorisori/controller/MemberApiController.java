package com.woorisori.controller;

import com.woorisori.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MemberApiController {
    private final MemberService memberService;

    public MemberApiController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/checkEmpNo")
    public Map<String, Boolean> checkEmpNo(@RequestParam String empNo) {
        boolean exists = memberService.isEmpNoExists(empNo);
        return Collections.singletonMap("exists", exists);
    }
}
