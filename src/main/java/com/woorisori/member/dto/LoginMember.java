package com.woorisori.member.dto;

import lombok.Value;

@Value
public class LoginMember {
    Long id;
    String empNo;
    String userName;
    String role;
    String isUse;
}
