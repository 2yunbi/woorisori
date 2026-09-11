package com.woorisori.complaint.repository;

import com.woorisori.complaint.domain.Complaint;
import com.woorisori.complaint.dto.ComplaintWithMember;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class JPAComplaintRepository implements ComplaintRepository {

    private final EntityManager em;

    public JPAComplaintRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Complaint> findAll() {
        return em.createQuery("select c from Complaint c", Complaint.class).getResultList();
    }

    @Override
    public List<ComplaintWithMember> findMyComplaints(long writerId) {

        List<ComplaintWithMember> result = em.createQuery("select c.subject, m.userName, c.createDate, c.status from Complaint c join Member m ON c.writerId = m.id where c.writerId = :writerId", ComplaintWithMember.class).setParameter("writerId", writerId).getResultList();

        return result;
    }

    @Transactional
    @Override
    public Complaint save(Complaint complaint) {
        em.persist(complaint);
        return complaint;
    }
}
