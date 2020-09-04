package com.BarShelf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BarShelf.entities.Cocktail;

@Repository
public interface CocktailRepository extends CrudRepository<Cocktail, String>{
	Cocktail findByName(String name);
}
