package com.woorisori.complaint.controller;

import com.woorisori.complaint.domain.Complaint;
import com.woorisori.complaint.service.ComplaintService;
import lombok.RequiredArgsConstructor;
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
    public String list(Model model) {
        List<Complaint> complaintList = complaintService.list();
        model.addAttribute("complaintList", complaintList);
        return "/complaint/list";
    }
}
