package com.blog.service;

import com.blog.entity.Post;
import com.blog.payload.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostService {





    public  PostDto createPost(PostDto postDto);

   public  void deletePost(long id);


    List<PostDto> getAllPosts();



    void updatePosts(long postId, PostDto postDto);


   PostDto updatePost(long postId, PostDto postDto);

//    Optional<Post> getPost(long id);

    Optional<Post> getPost(long id);

//    Optional<Post> getPostByContent(String content);




//    Iterable<Post> getAllPostss();


//    List<Post> getAllPostss();


}
