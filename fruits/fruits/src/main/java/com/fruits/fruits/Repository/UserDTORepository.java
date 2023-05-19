package com.fruits.fruits.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fruits.fruits.Entity.User;

@Repository
//JpaRepository extends crudRpository (qui offre CRUD fonction)+ autre fonctionnalité  
public interface UserDTORepository extends JpaRepository<User, Integer> {
	User	findByEmail(String email); 
}
