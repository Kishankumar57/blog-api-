package com.blog;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainUtil {

    public static void main(String[] args) {

        Post post1  = new Post();
        post1.setId(1);
        post1.setTitle("aaa");
        post1.setContent("aaaaaa");

        Post post2  = new Post();
        post2.setId(2);
        post2.setTitle("bbb");
        post2.setContent("bbbbbbbb");

        Post post3 = new Post();
        post3.setId(3);
        post3.setTitle("ccc");
        post3.setContent("cccccc");

        Post post4  = new Post();
        post4.setId(4);
        post4.setTitle("ddddd");
        post4.setContent("dddddddd");

        List<Post>posts = Arrays.asList(post1,post2,post3,post4);
        List<PostDto> dtos = posts.stream().map( p-> mapToDto(p)).collect(Collectors.toList());
        System.out.println(dtos);


    }

   static PostDto mapToDto (Post post) {

            PostDto dto  = new PostDto();
            dto.setId(post.getId());
            dto.setTitle(post.getTitle());
            dto.setContent(post.getContent());
            return dto;

    }

}
