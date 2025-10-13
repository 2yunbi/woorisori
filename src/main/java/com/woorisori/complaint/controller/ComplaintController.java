package com.woorisori.complaint.controller;

import com.woorisori.complaint.dto.ComplaintWithMember;
import com.woorisori.complaint.service.ComplaintService;
import com.woorisori.config.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/complaint")
public class ComplaintController {

    private final ComplaintService complaintService;

    @GetMapping("/list")
    public String findById(@AuthenticationPrincipal CustomUserDetails memberDetails, Model model) {
        Long loginId = memberDetails.getId();
        List<ComplaintWithMember> list = complaintService.findById(loginId);
        model.addAttribute("list", list);

        return "/complaint/list";
    }
}
