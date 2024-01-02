package com.blog.controller;


import com.blog.entity.Comment;
import com.blog.payload.CommentDto;
import com.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {


    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


   //     http://localhost:8080/api/comments?postId=postId
    @PostMapping
    public ResponseEntity<CommentDto> createComment (@RequestParam("postId") long postId, @RequestBody CommentDto commentDto){
        CommentDto dto= commentService.createComment(postId, commentDto);
        return new ResponseEntity<>( dto, HttpStatus.CREATED);



    }
    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@ PathVariable long commentId ){

        commentService.deleteComment(commentId);

        return new ResponseEntity<>("comment is deleted with the id ......!!"+commentId ,HttpStatus.OK);
    }

    @GetMapping("/{postId}")
  public List<Comment> getAllCommentsOfThePost(@PathVariable long postId){
      List<Comment>comment =   commentService.getAllCommentsOfThePost(postId);
        return comment;

}

//
//    @GetMapping("/{postId}")
//    public ResponseEntity< List <CommentDto>> getCommentsByPostId( @PathVariable long postId){
//
//
//        List<CommentDto> commentDto = commentService.getCommentsByPostId(postId);
//        return new ResponseEntity<>(commentDto,HttpStatus.OK);
//
//    }










    @GetMapping
    public ResponseEntity<List<CommentDto>>  getAllComments(){

        List<CommentDto> dto = commentService.getAllComments();
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }



















    @PutMapping ("/{commentId}")
    public ResponseEntity<CommentDto>  updateComment(@PathVariable long commentId,@RequestBody CommentDto  commentDto){

        CommentDto dto = commentService.updateComment(commentId,commentDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }



}
