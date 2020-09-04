package com.BarShelf.repositories;

import com.BarShelf.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
	User findByEmail(String email);
	User findByEmailAndPassword(String email, String password);
}
