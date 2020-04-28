package com.heitor.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.heitor.workshopmongodb.domain.User;

@Repository
public interface UserRepostory  extends MongoRepository<User, String>{

}
