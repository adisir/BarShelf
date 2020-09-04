package com.BarShelf.DAO;

import com.BarShelf.entities.User;

public interface UserDAOI {
	public Boolean registerUser(User user);
	public Boolean validateUser(String name);
}
