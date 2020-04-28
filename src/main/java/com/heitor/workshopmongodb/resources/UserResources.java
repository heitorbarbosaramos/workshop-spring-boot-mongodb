package com.heitor.workshopmongodb.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heitor.workshopmongodb.domain.User;
import com.heitor.workshopmongodb.dto.UserDTO;
import com.heitor.workshopmongodb.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> list = new ArrayList<>();
		list.addAll(service.findAll());
		
		List<UserDTO> listDTO = list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(listDTO);
		
		return ResponseEntity.ok().body(listDTO);
	}

}
