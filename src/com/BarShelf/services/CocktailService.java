package com.BarShelf.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BarShelf.DAO.CocktailDAO;
import com.BarShelf.entities.Cocktail;
import com.BarShelf.entities.Ingredient;
import com.BarShelf.repositories.CocktailRepository;

@Service
public class CocktailService {
	CocktailDAO cd = new CocktailDAO();
	
	@Autowired
	CocktailRepository cr;
	
	public List<Cocktail> getCocktailByIngredient(String ingredient) {
		return cd.getCocktailsByIngredient(ingredient);
	}
	public List<Cocktail> getCocktailByIngredientNA(String ingredient) {
		return cd.getCocktailsByIngredientNA(ingredient);
	}
	public Cocktail getCocktailByName(String cocktailName) {
		return cr.findByName(cocktailName);
	}
	public Map<Ingredient, String> getIngredientsByCocktailName(String cocktailName){
		
		return cd.getIngredientsByCocktailName(cocktailName);
	}
}
