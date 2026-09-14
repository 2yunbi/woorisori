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
import org.springframework.web.bind.annotation.*;

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

    private static final int PAGE_SIZE = 10;

    @GetMapping("/list")
    public String findById(@AuthenticationPrincipal CustomUserDetails memberDetails, @RequestParam(defaultValue = "1") int page, Model model) {
        Long loginId = memberDetails.getId();
        long totalCount = complaintService.countMyComplaints(loginId);

        int totalPages = (int) Math.max(1,Math.ceil((double)(totalCount / PAGE_SIZE)));
        int safePages = Math.min(Math.max(page, 1), totalPages);

        List<ComplaintWithMember> list = complaintService.findPageMyComplaints(loginId, safePages, PAGE_SIZE);

        model.addAttribute("list", list);
        model.addAttribute("page", safePages);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pageSize", PAGE_SIZE);

        return "/complaint/list";
    }

}
