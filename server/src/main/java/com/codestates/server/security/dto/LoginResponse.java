package com.codestates.server.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long memberId;
    private String email;
    private String memberName;
}