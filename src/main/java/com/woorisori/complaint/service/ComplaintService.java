package com.woorisori.complaint.service;

import com.woorisori.complaint.dto.ComplaintWithMember;
import com.woorisori.complaint.repository.ComplaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public List<ComplaintWithMember> findMyComplaints(long writerId) { return complaintRepository.findMyComplaints(writerId); }
}
