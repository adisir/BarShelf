package com.BarShelf.DAO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.BarShelf.entities.Cocktail;
import com.BarShelf.entities.Ingredient;

public class CocktailDAO implements CocktailDAOI {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	final String persistenceName = "BarShelf";

	@Override
	public List<Cocktail> getCocktailsByIngredient(String ingredient) {
		List<Cocktail> cocktails = null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceName);
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Cocktail> query = em.createQuery(
					"SELECT c FROM Cocktail c, Recipe r WHERE r.ingredient.name= :name AND r.cocktail.name = c.name",
					Cocktail.class);
			query.setParameter("name", ingredient);
			cocktails = query.getResultList();

		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return cocktails;
	}

	@Override
	public List<Cocktail> getCocktailsByIngredientNA(String ingredient) {
		List<Cocktail> cocktails = null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceName);
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Cocktail> query = em.createQuery(
					"SELECT c FROM Cocktail c, Recipe r WHERE r.ingredient.name= :name AND r.cocktail.name = c.name AND c.alcoholic = 0",
					Cocktail.class);
			query.setParameter("name", ingredient);
			cocktails = query.getResultList();

		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return cocktails;
	}

	@Override
	public Map<Ingredient, String> getIngredientsByCocktailName(String cocktailName) {
		Map<Ingredient, String> Recipe = new LinkedHashMap<Ingredient, String>();
		try {
			emf = Persistence.createEntityManagerFactory(persistenceName);
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Ingredient> query = em.createQuery(
					"SELECT i FROM Ingredient i, Recipe r WHERE r.cocktail.name= :name AND r.ingredient.name = i.name",
					Ingredient.class);
			query.setParameter("name", cocktailName);
			List<Ingredient> ingredients = query.getResultList();
			TypedQuery<String> query2 = em.createQuery(
					"SELECT r.measure FROM Ingredient i, Recipe r WHERE r.cocktail.name= :name AND r.ingredient.name = i.name",
					String.class);
			query2.setParameter("name", cocktailName);
			List<String> measures = query2.getResultList();
			int count = 0;
			for (Ingredient i : ingredients) {
				Recipe.put(i, measures.get(count));
				count++;
			}

		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return Recipe;
	}

}
