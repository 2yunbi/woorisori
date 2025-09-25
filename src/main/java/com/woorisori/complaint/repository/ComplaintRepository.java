package com.woorisori.complaint.repository;

import com.woorisori.complaint.domain.Complaint;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComplaintRepository {

    List<Complaint> findAll();
    Optional<Complaint> findById(int writerID);
    Complaint save(Complaint complaint);
}
