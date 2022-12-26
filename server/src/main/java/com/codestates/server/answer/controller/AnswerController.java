package com.codestates.server.answer.controller;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.answer.mapper.AnswerMapper;
import com.codestates.server.answer.service.AnswerService;
import com.codestates.server.comment.mapper.AnswerCommentMapper;
import com.codestates.server.dto.MultiResponseDto;
import com.codestates.server.dto.SingleResponseDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Validated
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper mapper;
    private final AnswerCommentMapper answerCommentMapper;

    @PostMapping("/questions/{question-id}/answers")
    public ResponseEntity postAnswer(@PathVariable("question-id") Long questionId,
                                     @Valid @RequestBody AnswerDto.Post requestBody) {
        Answer answer = mapper.AnswerPostDtoToAnswer(requestBody);
        Answer response = answerService.createAnswer(questionId, answer);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.AnswerToAnswerResponseDto(response, answerCommentMapper)), HttpStatus.CREATED);
    }

    /*@GetMapping("/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("answer-id") Long answerId) {
        Answer response = answerService.findAnswer(answerId);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.AnswerToAnswerResponseDto(response)),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getAnswers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size);
        List<Answer> answers = pageAnswers.getContent();

        return new ResponseEntity<>(new MultiResponseDto<>(mapper.AnswersToAnswerResponseDtos(answers),pageAnswers),HttpStatus.OK);
    }*/
    @PatchMapping("/answers/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") Long answerId,
                                      @Valid @RequestBody AnswerDto.Patch requestBody) {
        Answer response = answerService.updateAnswer(answerId, mapper.AnswerPatchDtoToAnswer(requestBody));
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.AnswerToAnswerResponseDto(response, answerCommentMapper)), HttpStatus.OK);
    }

    @DeleteMapping("/answers/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") Long answerId) {
        Long questionId = answerService.verifyAnswer(answerId).getQuestion().getQuestionId();
        answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(new AnswerDto.QuestionIdResponse(questionId),HttpStatus.NO_CONTENT);
    }

}
