package com.codestates.server.comment.service;

import com.codestates.server.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository answerCommentRepository;
}
