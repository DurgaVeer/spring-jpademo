package com.spring.jpa.Repository;

import java.util.Optional;
import java.util.UUID;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID> {

	//public void update(UserEntity user);

	
}


