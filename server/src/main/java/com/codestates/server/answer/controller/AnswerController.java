package com.codestates.server.answer.controller;

import com.codestates.server.answer.mapper.AnswerMapper;
import com.codestates.server.answer.service.AnswerService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper mapper;

    @PostMapping
    public ResponseEntity postAnswer() {
        return null;
    }
    @GetMapping
    public ResponseEntity getAnswer() {
        return null;
    }
    @PatchMapping
    public ResponseEntity patchAnswer() {
        return null;
    }
    @DeleteMapping
    public ResponseEntity deleteAnswer() {
        return null;
    }
}
