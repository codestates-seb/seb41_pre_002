package com.codestates.server.answer.controller;

import com.codestates.server.answer.mapper.AnswerCommentMapper;
import com.codestates.server.answer.mapper.AnswerMapper;
import com.codestates.server.answer.service.AnswerCommentService;
import com.codestates.server.answer.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer-comment")
@RequiredArgsConstructor
public class AnswerCommentController {

    private final AnswerCommentService answerCommentService;
    private final AnswerCommentMapper mapper;

    @PostMapping
    public ResponseEntity postAnswerComment() {
        return null;
    }
    @GetMapping
    public ResponseEntity getAnswerComment() {
        return null;
    }
    @PatchMapping
    public ResponseEntity patchAnswerComment() {
        return null;
    }
    @DeleteMapping
    public ResponseEntity deleteAnswerComment() {
        return null;
    }
}

