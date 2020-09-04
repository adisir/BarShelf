package com.BarShelf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BarShelf.entities.Ingredient;
import com.BarShelf.repositories.IngredientRepository;

@Service
public class IngredientService {
	@Autowired
	IngredientRepository ir;
	
	public Ingredient findIngredientByName(String name) {
		return ir.findByName(name);
	}
	
	
}
