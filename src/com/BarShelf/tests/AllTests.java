package com.BarShelf.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({IngredientDAOTest.class, CocktailDAOTest.class, UserDAOTest.class})
public class AllTests {
	public static void main(String[] args) {
		
	}
}
