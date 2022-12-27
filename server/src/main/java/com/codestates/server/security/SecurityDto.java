package com.codestates.server.security;

import lombok.Getter;

@Getter
public class SecurityDto {

    public static class LoginDto{
        private String email;
        private String memberPassword;
    }

    public static class SignupDto{
        private String email;
        private String MemberName;
        private String memberPasword;
    }
}