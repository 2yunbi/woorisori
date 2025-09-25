package com.woorisori.complaint.domain;

import com.woorisori.member.domain.member.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "complaint")
public class Complaint {

    @Id
    private long id;

    @Column(name = "writer_id")
    private long writerId;
    private String subject;
    private String content;

    @Column(name = "anonymous_pw")
    private String anonymousPw;
    private String status;

    @Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "modify_date")
    private LocalDateTime modifyDate;
    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    @ManyToOne
    @JoinColumn(name = "id")
    private Member member_id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWriterId() {
        return writerId;
    }

    public void setWriterId(long writerId) {
        this.writerId = writerId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnonymousPw() {
        return anonymousPw;
    }

    public void setAnonymousPw(String anonymousPw) {
        this.anonymousPw = anonymousPw;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public LocalDateTime getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }
}
