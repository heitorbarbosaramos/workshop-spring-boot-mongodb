package com.heitor.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.heitor.workshopmongodb.domain.Post;
import com.heitor.workshopmongodb.domain.User;
import com.heitor.workshopmongodb.dto.AuthorDTO;
import com.heitor.workshopmongodb.repository.PostRepostory;
import com.heitor.workshopmongodb.repository.UserRepostory;

@Configuration
public class Config implements CommandLineRunner {

	@Autowired
	private UserRepostory userRepository;
	@Autowired
	private PostRepostory postRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		postRepository.deleteAll();
		
		Post p1 = new Post(null, sdf.parse("21/03/2019"), "Partiu...", "Estou indo embora pra São Paulo", new AuthorDTO(maria));
		Post p2 = new Post(null, sdf.parse("22/03/2019"), "Bom dia", "Acordei muito feliz!!!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(p1,p2));
		
		maria.getPost().addAll(Arrays.asList(p1,p2));
		userRepository.save(maria);

	}

}
