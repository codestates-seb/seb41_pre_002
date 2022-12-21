package com.codestates.server.question.service;

import com.codestates.server.member.service.MemberService;
import com.codestates.server.question.entity.Question;
import com.codestates.server.question.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    private MemberService memberService;

    public QuestionService(QuestionRepository questionRepository, MemberService memberService) {
        this.questionRepository = questionRepository;
        this.memberService = memberService;
    }

    public Question createQuestion(Question question) {
        //멤버 유효성검증
        memberService.findVerifiedMember(question.getMember().getMemberId());

        // 생각해볼것 : 같은 제목의 질문을 올리면 어떻게 되는가 ?

        return questionRepository.save(question);
    }
}
