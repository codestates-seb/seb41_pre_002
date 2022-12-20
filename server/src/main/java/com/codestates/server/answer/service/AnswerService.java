package com.codestates.server.answer.service;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.answer.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    // 답글 조회 기능

}
