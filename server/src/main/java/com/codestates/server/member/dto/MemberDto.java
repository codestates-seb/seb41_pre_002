package com.codestates.server.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class MemberDto {

    @Getter
    @AllArgsConstructor
    public static class Post{
        @NotBlank
        @Email
        private String email;

        @NotBlank
        private String memberName;

        @NotBlank
        private String memberPassword;
    }

    @Getter
    @AllArgsConstructor
    @Setter
    public static class Patch{
        private long memberId;

        @NotBlank
        private String memberPassword;  //비밀번호만 수정가능
    }

    @Getter
    @AllArgsConstructor
    public static class Response{
        private long memberId;
        private String email;
        private String memberName;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
