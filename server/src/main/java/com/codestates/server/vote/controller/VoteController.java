package com.codestates.server.vote.controller;

import com.codestates.server.dto.SingleResponseDto;
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
     */
    @PostMapping(value = {"/questions/{request-id}", "/answers/{request-id}"})
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

        voteService.createVote(request, voteRequestDto.getMemberId(), requestId);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
