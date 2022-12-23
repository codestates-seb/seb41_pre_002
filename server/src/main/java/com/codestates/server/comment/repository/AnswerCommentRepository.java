package com.codestates.server.comment.repository;

import com.codestates.server.comment.entity.AnswerComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerCommentRepository extends JpaRepository<AnswerComment,Long> {
}
