package com.codestates.server.security.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class LoginDto {
    private String username;
    private String password;
}