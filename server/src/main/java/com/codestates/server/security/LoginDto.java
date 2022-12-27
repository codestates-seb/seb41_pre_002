package com.codestates.server.security;

import lombok.Getter;

@Getter
public class LoginDto {
    private String email;
    private String password;
}