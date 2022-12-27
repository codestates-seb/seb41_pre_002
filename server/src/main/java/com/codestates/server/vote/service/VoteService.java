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

    public void doVote(char request, int score, long memberId, long requestId) {
        Member member = memberService.findVerifiedMember(memberId); // Member에 대한 유효성 검사

        switch (request) {
            case 'A': // Answer에 대한 투표일 경우
                Answer answer = answerService.verifyAnswer(requestId); // Answer에 대한 유효성 검사
                Optional<AnswerVote> optionalAnswerVote = verifyExistsAnswerVote(member, answer); // 이미 투표를 했는지를 검사
                if (optionalAnswerVote.isPresent()) { // 이미 투표한 경우 업데이트 해준다
                    AnswerVote answerVote = optionalAnswerVote.get();
                    answerVote.calculateScore(score);
                    answerVoteRepository.save(answerVote);
                } else {
                    answerVoteRepository.save(new AnswerVote(score, member, answer)); // 처음하는 투표일 경우 새로운 객체를 생성하여 저장한다
                }
                break;

            case 'Q': // Question에 대한 투표일 경우
                Question question = questionService.findVerifiedQuestion(requestId);
                Optional<QuestionVote> optionalQuestionVote = verifyExistsQuestionVote(member, question);
                if (optionalQuestionVote.isPresent()) {
                    QuestionVote questionVote = optionalQuestionVote.get();

                    questionVote.calculateScore(score); // questionVote 투표갯수 계산
                    question.calVoteCount(); // 총 투표수 계산

                    questionVoteRepository.save(questionVote);
                } else {
                    questionVoteRepository.save(new QuestionVote(score, member, question));
                }
                break;
        }

    }

    // 이미 추천이 존재하는지 확인하는 메서드
    private Optional<AnswerVote> verifyExistsAnswerVote(Member member, Answer answer) {
        return answerVoteRepository.findByMemberAndAnswer(member, answer);
    }

    private Optional<QuestionVote> verifyExistsQuestionVote(Member member, Question question) {
        return questionVoteRepository.findByMemberAndQuestion(member, question);
    }
}
