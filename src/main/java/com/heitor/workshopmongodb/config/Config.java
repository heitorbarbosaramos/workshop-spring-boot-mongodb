package com.heitor.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.heitor.workshopmongodb.domain.User;
import com.heitor.workshopmongodb.repository.UserRepostory;

@Configuration
public class Config implements CommandLineRunner {

	@Autowired
	private UserRepostory userRepostory;

	@Override
	public void run(String... args) throws Exception {

		userRepostory.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepostory.saveAll(Arrays.asList(maria,alex,bob));

	}

}
