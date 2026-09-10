package com.woorisori.complaint.domain;

import com.woorisori.member.domain.member.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "complaint")
public class Complaint {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //작성자 값 세팅
    @Column(name="writer_id")
    private long writerId;

    //작성자 정보 불러오기
    @ManyToOne
    @JoinColumn(name = "writer_id", insertable = false, updatable = false)
    private Member writer;
    private String subject;
    private String content;
    private String status;

    @Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "modify_date")
    private LocalDateTime modifyDate;
    @Column(name = "delete_date")
    private LocalDateTime deleteDate;


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

    public Member getWriter() {
        return writer;
    }
    public void setWriter(Member writer) {
        this.writer = writer;
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
