package com.woorisori.domain.member;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="member")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empNo;

    @Column(name="password")
    private String password;

    private String userName;
    private String email;
    private MemberRole role;

    private MemberRole isUse;

    private LocalDateTime joinDate;

    private LocalDateTime modifyDate;

    private LocalDateTime deleteDate;

    public Member() {

    }
    public Member(String empNo, String userName) {
        this.empNo = empNo;
        this.userName = userName;
    }

    @PrePersist
    public void prePersist() {

        if (this.joinDate == null) {
            this.joinDate = LocalDateTime.now();
        }
        if (this.modifyDate == null) {
            this.modifyDate = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MemberRole getRole() {
        return role;
    }

    public void setRole(MemberRole role) {
        this.role = role;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public MemberRole getIsUse() {
        return isUse;
    }

    public void setIsUse(MemberRole isUse) {
        this.isUse = isUse;
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
