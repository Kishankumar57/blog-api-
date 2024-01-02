package com.blog;

import com.blog.entity.Post;
import com.blog.repository.PostRepository;
import com.blog.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class BlogAppApplicationTests {

	@Test
	void contextLoads() {
	}
//
//
//@Autowired
//private PostRepository postRepos;
//
//
//	@Test
//	public void findByContent() {
//
//		Optional<Post> s = postRepos.findByContent("Animal is a good movie");
//
//		System.out.println(s);
//
//		if (s.isPresent()){
//
//			Post post = s.get();
//			System.out.println(post.getClass());
//			System.out.println(post.getId());
//			System.out.println(post.getTitle());
//			System.out.println(post.getContent());
//			System.out.println(post.getDescription());
//
//		}else{
//
//			System.out.println("record not found ");
//		}
//
//
//	}
//
//	@Test
//	public void findByTitle() {
//
//		Optional<Post> s = postRepos.findByTitle("first  movie review");
//
//		System.out.println(s);
//
//		if (s.isPresent()){
//
//			Post post = s.get();
//			System.out.println(post.getClass());
//			System.out.println(post.getId());
//			System.out.println(post.getTitle());
//			System.out.println(post.getContent());
//			System.out.println(post.getDescription());
//
//		}else{
//
//			System.out.println("record not found ");
//		}
//
//
//	}
//
//	@Test
//	public void findByDescription () {
//
//		Iterable<Post> s = postRepos.findByDescription("five star rating");
//
//		System.out.println(s);
//
//		for (Post post:s) {
//			System.out.println(post.getClass());
//			System.out.println(post.getId());
//			System.out.println(post.getTitle());
//			System.out.println(post.getContent());
//			System.out.println(post.getDescription());
//
//		}
//
//
//
//
//
//
//
//
//
//	}
//

//
//		@Test
//		public void  getPost() {
//			Optional<Post> byId = postRepo.findById(2L);
//
//
//
//				Post post = byId.get();
//				System.out.println(post.getClass());
//				System.out.println(post.getId());
//				System.out.println(post.getTitle());
//				System.out.println(post.getContent());
//				System.out.println(post.getDescription());
//
//





}
