package com.woorisori.complaint.service;

import com.woorisori.complaint.domain.Complaint;
import com.woorisori.complaint.domain.ComplaintStatus;
import com.woorisori.complaint.dto.ComplaintDto;
import com.woorisori.complaint.dto.ComplaintWithMember;
import com.woorisori.complaint.repository.ComplaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public Long create(Long writerId, ComplaintDto.WriteForm writeForm) {

        Complaint complaint = new Complaint();
        complaint.setWriterId(writerId);
        complaint.setStatus(ComplaintStatus.RECEIVED);
        complaint.setSubject(writeForm.getSubject());
        complaint.setContent(writeForm.getContent());
        complaintRepository.save(complaint);

        return complaint.getId();
    }

    public List<ComplaintWithMember> findMyComplaints(long writerId) { return complaintRepository.findMyComplaints(writerId); }
}
