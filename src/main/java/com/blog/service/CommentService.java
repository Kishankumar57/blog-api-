package com.blog.service;

import com.blog.entity.Comment;
import org.springframework.http.ResponseEntity;
import com.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {

    public CommentDto createComment(long postId, CommentDto commentDto);


    void deleteComment(long commentId);

    List<Comment> getAllCommentsOfThePost(long postId);

    List<CommentDto> getAllComments();

    CommentDto updateComment(long commentId, CommentDto commentDto);

//    List<CommentDto> getCommentsByPostId(long postId);
}
