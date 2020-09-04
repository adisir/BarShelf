package com.BarShelf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BarShelf.DAO.UserDAO;
import com.BarShelf.entities.User;
import com.BarShelf.repositories.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	UserDAO ud = new UserDAO();
	public Boolean checkUserExists(String email) {
		Boolean exists = false;
		User user = userRepository.findByEmail(email);
		if(user!=null) {
			exists=true;
		}
		return exists;
	}
	public Boolean registerUser(User user) {
		Boolean bool = ud.registerUser(user);
		System.out.println(bool);
		return bool;
	}
	public User findUser(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	public boolean updateUser(User user) {
		if(userRepository.save(user)!=null) {
			return true;
		}
		
		return false;
		
	}
//	Boolean exists = ud.validateUser(name);
}
