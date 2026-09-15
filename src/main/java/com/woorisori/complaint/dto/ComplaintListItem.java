package com.woorisori.complaint.dto;

import com.woorisori.complaint.domain.ComplaintStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ComplaintListItem {
        private Long id;
        private String subject;
        private String userName;
        private LocalDateTime createDate;
        private ComplaintStatus status;

    public ComplaintListItem(Long id, String subject, String userName, LocalDateTime createDate, ComplaintStatus status) {
        this.id = id;
        this.subject = subject;
        this.userName = userName;
        this.createDate = createDate;
        this.status = status;
    }
}
