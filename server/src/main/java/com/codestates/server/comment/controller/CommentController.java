package com.codestates.server.comment.controller;

import com.codestates.server.comment.mapper.CommentMapper;
import com.codestates.server.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService CommentService;
    private final CommentMapper mapper;

    @PostMapping
    public ResponseEntity postComment() {
        return null;
    }
    @GetMapping
    public ResponseEntity getComment() {
        return null;
    }
    @PatchMapping
    public ResponseEntity patchComment() {
        return null;
    }
    @DeleteMapping
    public ResponseEntity deleteComment() {
        return null;
    }
}

