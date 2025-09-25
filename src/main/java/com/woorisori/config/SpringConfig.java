package com.woorisori.config;

import com.woorisori.complaint.repository.ComplaintRepository;
import com.woorisori.complaint.repository.JPAComplaintRepository;
import com.woorisori.repository.JPAMemberRepository;
import com.woorisori.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        return new JPAMemberRepository(em);
    }

    @Bean
    public ComplaintRepository complaintRepository() {
        return new JPAComplaintRepository(em);
    }
}
