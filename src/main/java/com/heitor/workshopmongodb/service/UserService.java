package com.heitor.workshopmongodb.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heitor.workshopmongodb.domain.User;
import com.heitor.workshopmongodb.dto.UserDTO;
import com.heitor.workshopmongodb.repository.UserRepostory;
import com.heitor.workshopmongodb.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepostory repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id); 
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Entcontrado"));
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User fromDto(UserDTO user) {
		return new User(user.getId(), user.getName(), user.getEmail());
	}
}
