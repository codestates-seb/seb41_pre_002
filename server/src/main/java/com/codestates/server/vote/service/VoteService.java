package com.codestates.server.vote.service;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.answer.service.AnswerService;
import com.codestates.server.member.entity.Member;
import com.codestates.server.member.service.MemberService;
import com.codestates.server.question.entity.Question;
import com.codestates.server.question.service.QuestionService;
import com.codestates.server.vote.entity.AnswerVote;
import com.codestates.server.vote.entity.QuestionVote;
import com.codestates.server.vote.repository.AnswerVoteRepository;
import com.codestates.server.vote.repository.QuestionVoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService {
    private AnswerVoteRepository answerVoteRepository;
    private QuestionVoteRepository questionVoteRepository;
    private MemberService memberService;
    private AnswerService answerService;
    private QuestionService questionService;

    public VoteService(AnswerVoteRepository answerVoteRepository,
                       QuestionVoteRepository questionVoteRepository,
                       MemberService memberService, AnswerService answerService,
                       QuestionService questionService) {
        this.answerVoteRepository = answerVoteRepository;
        this.questionVoteRepository = questionVoteRepository;
        this.memberService = memberService;
        this.answerService = answerService;
        this.questionService = questionService;
    }

    public void createVote(char request, long memberId, long requestId) {
        Member member = memberService.findVerifiedMember(memberId);

        switch (request) {
            case 'A':
                Answer answer = answerService.verifyAnswer(requestId);
                answerVoteRepository.save(new AnswerVote(member, answer));
                break;

            case 'Q':
                Question question = questionService.findVerifiedQuestion(requestId);
                questionVoteRepository.save(new QuestionVote(member, question));
                break;
        }
    }

//    private void verifyExistsAnswerVote(long memberId, long answerId) {
//        Optional<AnswerVote> optionalAnswerVote = answerVoteRepository.findByMemberId(memberId);
//
//    }


}
