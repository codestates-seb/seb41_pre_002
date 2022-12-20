package com.codestates.server.member.entity;

import com.codestates.server.audit.Auditable;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long memberId;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    String memberName;
    @Column(nullable = false)
    String memberPassword;
}
