package com.codestates.server.member.mapper;

import com.codestates.server.member.dto.MemberDto;
import com.codestates.server.member.entity.Member;
import com.codestates.server.security.dto.LoginResponse;
import com.codestates.server.security.jwt.TokenInfo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    Member memberPostToMember(MemberDto.Post requestBody);
    Member memberPatchToMember(MemberDto.Patch requestBody);
    MemberDto.Response memberToMemberResponse(Member member);
    List<MemberDto.Response> membersToMemberResponses(List<Member> members);

    default LoginResponse loginToLoginResponseDto(TokenInfo tokenInfo, Member member) {
        return LoginResponse
                .builder()
                .grantType(tokenInfo.getGrantType())
                .accessToken(tokenInfo.getAccessToken())
                .refreshToken(tokenInfo.getRefreshToken())
                .memberId(member.getMemberId())
                .email(member.getEmail())
                .memberName(member.getMemberName())
                .build();
    }

}