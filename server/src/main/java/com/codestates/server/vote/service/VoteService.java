package com.codestates.server.vote.service;

import com.codestates.server.vote.entity.AnswerVote;
import com.codestates.server.vote.entity.QuestionVote;
import com.codestates.server.vote.repository.AnswerVoteRepository;
import com.codestates.server.vote.repository.QuestionVoteRepository;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    private AnswerVoteRepository answerVoteRepository;
    private QuestionVoteRepository questionVoteRepository;

    public VoteService(AnswerVoteRepository answerVoteRepository, QuestionVoteRepository questionVoteRepository) {
        this.answerVoteRepository = answerVoteRepository;
        this.questionVoteRepository = questionVoteRepository;
    }

    public void createVote(char request) {
        switch (request) {
            case 'A':
                answerVoteRepository.save(new AnswerVote());
                break;
            case 'Q':
                questionVoteRepository.save(new QuestionVote());
                break;
        }
    }

}
