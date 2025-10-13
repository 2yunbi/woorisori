package com.woorisori.complaint.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ComplaintWithMember {
        private String subject;
        private String userName;
        private LocalDateTime createDate;

    public ComplaintWithMember(String subject, String userName, LocalDateTime createDate) {
        this.subject = subject;
        this.userName = userName;
        this.createDate = createDate;
    }
}
