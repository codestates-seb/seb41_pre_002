package com.codestates.server.vote.controller;

import com.codestates.server.dto.SingleResponseDto;
import com.codestates.server.vote.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/votes")
public class VoteController {
    private VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    /**
     * 추천 기능은 내가 추천을 눌렀는가? 이게 포함되어야 한다.
     */
    @PostMapping(value = {"/questions", "/answers"})
    public ResponseEntity postVote(HttpServletRequest httpServletRequest) {
        char request;
        switch (httpServletRequest.getRequestURI()) { // 질문에 대한 요청인지 답변에 대한 요청인지 여부를 판단
            case "/votes/answers":
                request = 'A';
                break;
            case "/votes/questions":
                request = 'Q';
                break;
            default:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        voteService.createVote(request);

        return new ResponseEntity<>(
                new SingleResponseDto<>(1),
                HttpStatus.CREATED
        );
    }
}
