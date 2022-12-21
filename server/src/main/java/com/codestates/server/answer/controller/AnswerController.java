package com.codestates.server.answer.controller;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.answer.mapper.AnswerMapper;
import com.codestates.server.answer.service.AnswerService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Validated
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper mapper;

    @PostMapping("/questions/{question-id}/answers")
    public ResponseEntity postAnswer( @PathVariable("question-id") long questionId,
                                     @Valid  @RequestBody AnswerDto.Post requestBody) {
        Answer answer = mapper.AnswerPostDtoToAnswer(requestBody);
        Answer response = answerService.createAnswer(answer, questionId);
        return new ResponseEntity<>(mapper.AnswerToAnswerResponseDto(response), HttpStatus.CREATED);
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
