package com.heitor.workshopmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heitor.workshopmongodb.domain.Post;
import com.heitor.workshopmongodb.repository.PostRepostory;
import com.heitor.workshopmongodb.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepostory repo;
	
	public List<Post> postFindAll(){
		return repo.findAll();
	}
	
	public Post postFindById(String id){		
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Entcontrado"));
		
	}
}
