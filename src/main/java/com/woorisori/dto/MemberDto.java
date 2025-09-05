package com.woorisori.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

public class MemberDto {

    @Getter @Setter
    public static class SignUpRequest {
        @NotBlank
        private String empNo;
        @NotBlank
        private String password;
        @NotBlank
        private String userName;
        @NotBlank
        private String email;
    }

    @Getter @Setter
    public static class LoginRequest {
        @NotBlank
        private String empNo;
        @NotBlank
        private String password;
    }
}
