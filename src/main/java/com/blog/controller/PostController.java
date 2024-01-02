package com.blog.controller;

import com.blog.entity.Post;
import com.blog.payload.PostDto;
import com.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //     http://localhost:8080/api/posts/id
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id) {

        postService.deletePost(id);

        return new ResponseEntity<>("post is deleted", HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> postDtos = postService.getAllPosts();
        return new ResponseEntity<>(postDtos, HttpStatus.OK);

    }


//
//    @GetMapping
//    public List<Post>  getAllPostss() {
//        List<Post> allPostss = postService.getAllPostss();
//     return allPostss;
//
//    }


    //http://localhost:8080/api/posts/{postId}
    //http://localhost:8080/api/posts?postId=1





//http://localhost:8080/api/posts?postId=1
//    @PutMapping
//    public ResponseEntity<PostDto>  updatePost (
//            @RequestParam("postId") long postId,
//            @RequestBody PostDto postDto ){
//                                                // we will manually enter the data (title, content and description)
//                                                // which we have to update in the postman
//                                                // technically saying the key value pair  or the json object
//
//
//        PostDto dto= postService.updatePost(postId, postDto);
//
//        return new ResponseEntity<>(dto,HttpStatus.OK);
//
//    }

//    http://localhost:8080/api/posts?postId=postId

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<String> updatePost (
            @RequestParam("postId") long postId,
            @RequestBody PostDto postDto ){
                                                // we will manually enter the data (title, content and description)
                                                // which we have to update in the postman
                                                // technically saying the key value pair  or the json object


         postService.updatePosts(postId, postDto);

     return new ResponseEntity<>("post is updated", HttpStatus.OK);

    }






//


//        @PutMapping("/{postId}")
//    public ResponseEntity<PostDto>  updatePost (
//                @PathVariable long postId,
//            @RequestBody PostDto postDto ){
//                                                // we will manually enter the data (title, content and description not ID)
//                                                // which we have to update in the postman
//                                                // technically saying the key value pair  or the json object
//
//
//        PostDto dto= postService.updatePost(postId, postDto);
//
//        return new ResponseEntity<>(dto,HttpStatus.OK);
//
//    }



    //
//    @GetMapping
//    public  Iterable<Post>  getAllPostss() {
//        Iterable<Post> allPostss = postService.getAllPostss();
//     return allPostss;
//
//    }



//    http://localhost:8080/api/posts/id
//        @GetMapping("/{id}")
//    public   Optional<Post> getAllPostss(@PathVariable long id) {
//        Optional<Post> allPostss = postService.getPost(id);
//     return allPostss;
//
//    }




////    http://localhost:8080/api/posts?id=id
//            @GetMapping
//    public   Optional<Post> getAllPostss(@RequestParam ("id") long id) {
//        Optional<Post> allPostss = postService.getPost(id);
//     return allPostss;
//
//    }


//    ////    http://localhost:8080/api/posts?content=content
//    @GetMapping
//    public Optional<Post> findByContent(@RequestParam ("content") String content){
//        Optional<Post> allPostss = postService.getPostByContent(content);
//        return allPostss;
//    }





}





