package com.codestates.server.answer.service;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.answer.repository.AnswerRepository;
import com.codestates.server.exception.BusinessLogicException;
import com.codestates.server.exception.ExceptionCode;
import com.codestates.server.member.entity.Member;
import com.codestates.server.member.repository.MemberRepository;
import com.codestates.server.question.entity.Question;
import com.codestates.server.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final MemberRepository memberRepository;

    // 답글 생성.
    @Transactional
    public Answer createAnswer(Answer answer, Member member, Long questionId  ) {
        Member findMember = verifyMember(member.getMemberId());
        Question findQuestion = verifyQuestion(questionId);

        answer.setMember(findMember);
        answer.setQuestion(findQuestion);

        answerRepository.save(answer);

        return answer;
    }
    // 멤버가 작성한 답글 조회.
    public Answer findAnswer(Long memberId) {
        return null;
    }
    // 답글 수정
    public Answer updateAnswer(Long answerId, Answer answer) {
        return null;
    }
    // 답글 삭제
    public void deleteAnswer(Long answerId) {
        answerRepository.deleteById(answerId);
    }

    // 답글 존재여부

    // 멤버 존재 확인
    public Member verifyMember(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member member = optionalMember.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND)
        );
        return member;
    }
    // 질문 존재 확인
    public Question verifyQuestion(Long questionId){
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question question = optionalQuestion.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND)
        );
        return question;
    }

}
