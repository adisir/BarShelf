package com.BarShelf.DAO;

import java.util.List;
import java.util.Map;

import com.BarShelf.entities.Cocktail;
import com.BarShelf.entities.Ingredient;

public interface CocktailDAOI {
	public List<Cocktail> getCocktailsByIngredient(String ingredient);

	public List<Cocktail> getCocktailsByIngredientNA(String ingredient);

	public Map<Ingredient, String> getIngredientsByCocktailName(String cocktailName);
}
