package com.codestates.server.vote.controller;

import com.codestates.server.vote.dto.VoteRequestDto;
import com.codestates.server.vote.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/votes")
@Validated
public class VoteController {
    private VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    /**
     * 추천 기능은 내가 추천을 눌렀는가? 이게 포함되어야 한다.
     * <p>
     * 투표는 좋아요와 싫어요가 있다 -> 추천 수가 마이너스로 갈수 있음
     * 인당 한번만 투표할 수 있음
     * 좋아요를 누른뒤 싫어요를 누르면 좋아요가 취소된다
     * 싫어요를 누른뒤 좋아요를 누르면 싫어요가 취소된다
     * <p>
     * 아무것도 없는 상황에서 좋아요,싫어요를 누르면 누른게 반영된다
     */

    @PostMapping(value = {"/answers/{request-id}", "/questions/{request-id}"})
    public ResponseEntity postVote(HttpServletRequest httpServletRequest,
                                   @Positive @PathVariable("request-id") long requestId,
                                   @Valid @RequestBody VoteRequestDto voteRequestDto) {

        char request;
        if (httpServletRequest.getRequestURI().contains("answers")) {
            request = 'A';
        } else if (httpServletRequest.getRequestURI().contains("questions")) {
            request = 'Q';
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        voteService.doVote(request, voteRequestDto.getScore(), voteRequestDto.getMemberId(), requestId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}