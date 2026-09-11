package com.woorisori.service;

import com.woorisori.complaint.domain.Complaint;
import com.woorisori.complaint.domain.ComplaintStatus;
import com.woorisori.complaint.repository.ComplaintRepository;
import com.woorisori.complaint.service.ComplaintService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ComplaintServiceTest {

    @Autowired
    ComplaintService complaintService;
    @Autowired
    ComplaintRepository complaintRepository;


    @Test
    @Transactional
    void create() {
        Complaint complaint = new Complaint();
        complaint.setWriterId(1);
        complaint.setStatus(ComplaintStatus.RECEIVED);
        complaint.setSubject("제목1");
        complaint.setContent("내용어쩌구저쩌구");

        complaintRepository.save(complaint);
        System.out.println("complaint id = " + complaint.getId());
    }
}
