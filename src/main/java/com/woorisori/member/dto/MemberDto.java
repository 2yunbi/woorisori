package com.woorisori.member.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

public class MemberDto {

    @Getter @Setter
    public static class SignUpRequest {
        @NotBlank(message = "사번은 필수 입력값입니다.")
        private String empNo;
        @NotBlank(message = "비밀번호는 필수 입력값입니다.")
        @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;\"'<>,.?/]).{8,}$",
                message = "비밀번호는 8자리 이상, 영문/숫자/특수문자를 모두 포함해야 합니다."
        )
        private String password;
        @NotBlank(message = "이름은 필수 입력값입니다.")
        private String userName;
        @NotBlank(message = "이메일은 필수 입력값입니다.")
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
