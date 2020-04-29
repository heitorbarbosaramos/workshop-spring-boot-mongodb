package com.heitor.workshopmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heitor.workshopmongodb.domain.Post;
import com.heitor.workshopmongodb.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {
	
	@Autowired
	private PostService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findAll(){
		List<Post> post= service.postFindAll();
		post.addAll(service.postFindAll());
		System.out.println(post);
		return ResponseEntity.ok().body(post);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Post> findPost(@PathVariable String id){
		Post post = service.postFindById(id);
		System.out.println("FindPost : " + post);
		return ResponseEntity.ok().body(post);		
	}

}
