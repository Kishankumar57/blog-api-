package com.blog.service.impl;
import com.blog.payload.CommentDto;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.exception.ResourceNotFoundException;
import com.blog.repository.CommentRepository;
import com.blog.repository.PostRepository;
import com.blog.service.CommentService;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {

        Post post = postRepository.findById(postId).orElseThrow(  // finding the particular post from db
                                                                  // where we have to map out comment
                () -> new ResourceNotFoundException("post not found with id " + postId));

        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());


        // important points
        comment.setPost(post); // comments will set to the particular post(postId = postId)

        Comment savedComment = commentRepository.save(comment); // saving comments to  DB table

        CommentDto dto = new CommentDto();   // fetching the data from DB

        dto.setId(savedComment.getId());
        dto.setName(savedComment.getName());
        dto.setEmail(savedComment.getEmail());
        dto.setBody(savedComment.getBody());


        return dto;
    }


    @Override
    public void deleteComment(long commentId) {
        commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("comment not found with the id :" + commentId)
        );

        commentRepository.deleteById(commentId);
    }


    @Override
    public List<Comment> getAllCommentsOfThePost(long postId) {

        List<Comment> byPostId = commentRepository.findByPostId(postId);

            return byPostId;


    }




//    @Override
//    public List<CommentDto> getCommentsByPostId(long postId) {
//        List<Comment> comments = commentRepository.findByPostId(postId);
//        List<CommentDto> commentDtos = comments.stream().map(c -> mapToDto(c)).collect(Collectors.toList());
//        return commentDtos;
//    }



//






   CommentDto mapToDto(Comment comment){

        CommentDto dto  = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());
        return dto;

    }










    @Override
    public  List<CommentDto> getAllComments() {

        List<Comment> comments = commentRepository.findAll();
        List<CommentDto> commentDtos = comments.stream().map(c -> mapToDto(c)).collect(Collectors.toList());

        return commentDtos;
    }






    @Override
    public CommentDto updateComment(long commentId, CommentDto commentDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("comment not found with the commentId:" + commentId)
        );

        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        Comment savedComment = commentRepository.save(comment);

        CommentDto  dto = mapToDto(savedComment);


        return dto;
    }


}
