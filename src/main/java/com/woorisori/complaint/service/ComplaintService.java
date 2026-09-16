package com.woorisori.complaint.service;

import com.woorisori.complaint.domain.Complaint;
import com.woorisori.complaint.domain.ComplaintStatus;
import com.woorisori.complaint.dto.ComplaintDto;
import com.woorisori.complaint.dto.ComplaintWithMember;
import com.woorisori.complaint.repository.ComplaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public long countMyComplaints(long writerId) {
        return complaintRepository.countByWriterId(writerId);
    }

    public List<ComplaintWithMember> findPageMyComplaints(long writerId, int page, int size) {
        return complaintRepository.findPageByWriterId(writerId, page, size);
    }

    public Complaint complaintDetailView(long id, long writerId) {
        return complaintRepository.findByIdAndWriterID(id, writerId).orElseThrow(() -> new IllegalStateException("글을 찾을 수 없습니다."));
    }
}
