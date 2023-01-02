package com.codestates.server.security;

import com.codestates.server.dto.SingleResponseDto;
import com.codestates.server.member.dto.MemberDto;
import com.codestates.server.member.entity.Member;
import com.codestates.server.member.mapper.MemberMapper;
import com.codestates.server.member.service.MemberService;
import com.codestates.server.security.dto.LoginDto;
import com.codestates.server.security.jwt.JwtAuthenticationFilter;
import com.codestates.server.security.jwt.TokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SecurityController {

    private final SecurityService securityService;
    private final MemberService memberService;
    private final MemberMapper mapper;

    @PostMapping("/signUp")
    public ResponseEntity signup(@Valid @RequestBody MemberDto.Post requestBody) {
        Member member = mapper.memberPostToMember(requestBody);
        Member createdMember = memberService.createMember(member);

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.memberToMemberResponse(createdMember)),
                HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto) {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();


        TokenInfo tokenInfo = securityService.login(username, password);
        Member member = memberService.findMemberByEmail(username);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtAuthenticationFilter.AUTHORIZATION_HEADER, "Bearer " + tokenInfo.getAccessToken());

        return new ResponseEntity(mapper.loginToLoginResponseDto(tokenInfo, member), httpHeaders, HttpStatus.OK);
    }

    //권한 설정 테스트용
    @PostMapping("/auth/user")
    public String test(){
        return "User Auth success";
    }

    @PostMapping("/auth/admin")
    public String admin(){
        return "Only Admin Access";
    }
}