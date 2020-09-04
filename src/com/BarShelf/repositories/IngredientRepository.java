package com.BarShelf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BarShelf.entities.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
	Ingredient findByName(String name);
}
