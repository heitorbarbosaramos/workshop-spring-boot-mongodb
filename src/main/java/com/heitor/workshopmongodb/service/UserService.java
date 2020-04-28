package com.heitor.workshopmongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heitor.workshopmongodb.domain.User;
import com.heitor.workshopmongodb.repository.UserRepostory;

@Service
public class UserService {
	
	@Autowired
	private UserRepostory repo;
	
	public List<User> findAll(){
		return repo.findAll();
		
	}

}
