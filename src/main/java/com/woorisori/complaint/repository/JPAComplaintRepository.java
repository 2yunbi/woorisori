package com.woorisori.complaint.repository;

import com.woorisori.complaint.domain.Complaint;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

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
    public Optional<Complaint> findById(int writerID) {
        //List<Complaint> result = em.createQuery("select c from Complaint c where c.writerId = :writerId", Complaint.class).setParameter("writerId", writerID).getResultList();
        List<Object[]> result = em.createQuery("select c, m from Complaint c inner join Member m", Object[].class).getResultList();
        return result.stream().findAny();
    }

    @Override
    public Complaint save(Complaint complaint) {
        return null;
    }
}
