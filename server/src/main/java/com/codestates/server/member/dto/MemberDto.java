package com.codestates.server.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class MemberDto {

    @Getter
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
        private String email;

        @NotBlank
        private String memberName;

        @NotBlank
        private String memberPassword;
    }

    @Getter
    @AllArgsConstructor
    public static class response{
        private long memberId;
        private String email;
        private String memberName;
    }
}
