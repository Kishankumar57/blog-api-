package com.blog.service.impl;

import com.blog.entity.Post;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payload.PostDto;
import com.blog.repository.PostRepository;
import com.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }



    @Override

    public PostDto createPost(PostDto postDto) {

        Post post = new Post();

        post.setId(postDto.getId());      // we are converting PostDto to Post  because we have to save our content to  data base
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post savedPost = postRepo.save(post); // this we are doing because we have to show  this
                                                // in the console of postman that this particular post is saved in the databse
                                                // so we are converting Post to PostDto
        PostDto dto = new PostDto();

        dto.setId(savedPost.getId());  // here only one record is getting returned so return type is only the Post (Entity class)
        dto.setTitle(savedPost.getTitle());
        dto.setContent(savedPost.getContent());
        dto.setDescription(savedPost.getDescription());

        return dto;

    }

    @Override
    public void deletePost(long id) {

        Post post = postRepo.findById(id).orElseThrow(

                () -> new ResourceNotFoundException("post not found with id :" + id)
        );

        postRepo.deleteById(id);

    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepo.findAll();  // here we want all records so list of record is what we are getting because
        // we are using findAll method of JpaRepository.
        List<PostDto> dtos = posts.stream().map(p -> maptoDto(p)).collect(Collectors.toList());

        return dtos;

    }




    PostDto maptoDto(Post post) {
        PostDto dto = new PostDto();

        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());

        return dto;

    }

//    @Override
//    public List<Post> getAllPostss() {
//        List<Post> all = postRepo.findAll();
//        return  all;
//
//    }

//    @Override
//    public void updatePost(Long postId, PostDto postDto) {
//
//        postRepo.findAllById();
//
//    }


    @Override
    public PostDto updatePost( long postId, PostDto postDto) {


        Post post = postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with id: " + postId));



        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post savedPost = postRepo.save(post);

        PostDto  dto = maptoDto(savedPost);



        return dto ;
    }




    @Override
    public void updatePosts(long postId, PostDto postDto) {
        Optional<Post> posts = postRepo.findById(postId);
        Post post = posts.get();

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post savedPost = postRepo.save(post);

    }

//    @Override
//    public Iterable<Post> getAllPostss() {
//        Iterable<Post> all = postRepo.findAll();
//        return  all;
//    }

//    @Override
//    public Optional<Post> getPost(long id) {
//        Optional<Post> byId = postRepo.findById(id);
//        return byId;
//    }


    @Override
    public Optional<Post> getPost(long id) {
        Optional<Post> byId = postRepo.findById(id);
        return byId;
    }




//        @Override
//    public Optional<Post> getPostByContent(String content) {
//
//    Optional<Post> s = postRepo.findByContent(content);
//
//          return s;




  }


