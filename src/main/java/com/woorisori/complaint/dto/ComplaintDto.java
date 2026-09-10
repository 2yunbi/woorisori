package com.woorisori.complaint.dto;

import jakarta.validation.constraints.NotBlank;

public class ComplaintDto {

    public static class WriteForm {

        @NotBlank(message = "제목을 작성해주세요.")
        private String subject;

        @NotBlank(message = "내용을 작성해주세요.")
        private String content;
    }
}
