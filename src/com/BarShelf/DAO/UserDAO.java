package com.BarShelf.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.BarShelf.entities.User;

public class UserDAO implements UserDAOI {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	final String persistenceName = "BarShelf";

	@Override
	public Boolean registerUser(User user) {
		Boolean addedUser = false;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceName);
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			addedUser = true;
		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return addedUser;
	}

	@Override
	public Boolean validateUser(String name) {
		boolean exists = false;

		try {
			emf = Persistence.createEntityManagerFactory(persistenceName);
			em = emf.createEntityManager();
			if (em.find(User.class, name) != null) {
				exists = true;
			}
		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return exists;
	}

}
