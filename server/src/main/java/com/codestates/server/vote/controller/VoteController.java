package com.codestates.server.vote.controller;

import com.codestates.server.vote.dto.VoteRequestDto;
import com.codestates.server.vote.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/questions/{question-id}")
    public ResponseEntity postQuestionVote(@Positive @PathVariable("question-id") long questionId,
                                           @Valid @RequestBody VoteRequestDto voteRequestDto) {

        voteService.doVote('Q', voteRequestDto.getScore(), voteRequestDto.getMemberId(), questionId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/answers/{answer-id}")
    public ResponseEntity postAnswerVote(@Positive @PathVariable("answer-id") long answerId,
                                         @Valid @RequestBody VoteRequestDto voteRequestDto) {

        voteService.doVote('A', voteRequestDto.getScore(), voteRequestDto.getMemberId(), answerId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}