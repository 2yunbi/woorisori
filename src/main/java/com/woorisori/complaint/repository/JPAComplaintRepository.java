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

    public Long countByWriterId(long writerId) {
        return em.createQuery("select count(c) from Complaint c where c.writerId = :writerId", Long.class).setParameter("writerId", writerId).getSingleResult();
    }

    public List<ComplaintWithMember> findPageByWriterId(Long writerId, int page, int size) {
        return em.createQuery("select new com.woorisori.complaint.dto.ComplaintWithMember (" +
                                "c.id, c.subject, m.userName, c.createDate, c.status) " +
                                "from Complaint c inner join Member m " +
                                    "on c.writerId = m.id " +
                                "where c.writerId = :writerId " +
                                "order by c.id desc", ComplaintWithMember.class)
                .setParameter("writerId", writerId)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    // 게시글 등록
    @Transactional
    @Override
    public Complaint save(Complaint complaint) {
        em.persist(complaint);
        return complaint;
    }
}
