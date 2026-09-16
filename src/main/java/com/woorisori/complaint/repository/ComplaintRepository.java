package com.woorisori.complaint.repository;

import com.woorisori.complaint.domain.Complaint;
import com.woorisori.complaint.dto.ComplaintWithMember;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComplaintRepository {

    Complaint save(Complaint complaint);

    List<Complaint> findAll();
    Long countByWriterId(long writerID);
    List<ComplaintWithMember> findPageByWriterId(Long writerId, int page, int size);

    Optional<Complaint> findByIdAndWriterID(long id, long writerId);

}
