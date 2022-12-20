package com.codestates.server.question.service;

import com.codestates.server.question.entity.Question;
import com.codestates.server.question.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question) {
        // 같은 제목의 질문을 올리면 어떻게 되는가 ?
//멤버 유효성검증
        return questionRepository.save(question);
    }
}
