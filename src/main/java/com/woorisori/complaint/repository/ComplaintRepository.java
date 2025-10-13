package com.woorisori.complaint.repository;

import com.woorisori.complaint.domain.Complaint;
import com.woorisori.complaint.dto.ComplaintWithMember;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository {

    List<Complaint> findAll();
    List<ComplaintWithMember> findById(long writerID);
    Complaint save(Complaint complaint);
}
