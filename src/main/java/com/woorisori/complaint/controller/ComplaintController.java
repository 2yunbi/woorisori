package com.woorisori.complaint.controller;

import com.woorisori.complaint.dto.ComplaintDto;
import com.woorisori.complaint.dto.ComplaintWithMember;
import com.woorisori.complaint.service.ComplaintService;
import com.woorisori.config.CustomUserDetails;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/complaint")
public class ComplaintController {

    private final ComplaintService complaintService;

    @GetMapping("/new")
    public String writeForm(Model model) {
        model.addAttribute("form", new ComplaintDto.WriteForm());
        return "/complaint/writeForm";
    }

    @PostMapping("/new")
    public String create(@AuthenticationPrincipal CustomUserDetails member, @Valid @ModelAttribute("form") ComplaintDto.WriteForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/complaint/list";
        }

        complaintService.create(member.getId(), form);

        //todo 내가 작성한 4그 글페이지로 이동해야함
        return "/complaint/list";
    }

    @GetMapping("/list")
    public String findById(@AuthenticationPrincipal CustomUserDetails memberDetails, Model model) {
        Long loginId = memberDetails.getId();
        List<ComplaintWithMember> list = complaintService.findMyComplaints(loginId);
        model.addAttribute("list", list);

        return "/complaint/list";
    }
}
