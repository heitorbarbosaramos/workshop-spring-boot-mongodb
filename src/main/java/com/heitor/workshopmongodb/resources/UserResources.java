package com.heitor.workshopmongodb.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.heitor.workshopmongodb.domain.User;
import com.heitor.workshopmongodb.dto.UserDTO;
import com.heitor.workshopmongodb.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> list = new ArrayList<>();
		list.addAll(service.findAll());
		
		List<UserDTO> listDTO = list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(listDTO);
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		
		User user = service.findById(id);
		System.out.println(id);
		System.out.println(user);
		
		return ResponseEntity.ok().body(new UserDTO(user));
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDto){
		
		User user = service.fromDto(userDto);
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		System.out.println(user);
		System.out.println(uri);
		return ResponseEntity.created(uri).build();
		
		
	}

}
