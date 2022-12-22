package com.codestates.server.audit;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AuditableResponseDto {
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
