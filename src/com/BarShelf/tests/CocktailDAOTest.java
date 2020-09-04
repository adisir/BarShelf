package com.BarShelf.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.BarShelf.services.CocktailService;
import com.BarShelf.entities.Cocktail;

public class CocktailDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@Test
	public void getCocktail() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.BarShelf");
		appContext.refresh();
		CocktailService cs = (CocktailService) appContext.getBean("cocktailService");
		assertTrue(cs.getCocktailByIngredient("vodka")!=null);
		appContext.close();
		
	}
	@Test
	public void getCocktailNA() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.BarShelf");
		appContext.refresh();
		CocktailService cs = (CocktailService) appContext.getBean("cocktailService");
		assertTrue(cs.getCocktailByIngredientNA("vodka")!=null);
		appContext.close();
	}
	@Test
	public void getIngredients() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.BarShelf");
		appContext.refresh();
		CocktailService cs = (CocktailService) appContext.getBean("cocktailService");
		assertTrue(cs.getIngredientsByCocktailName("Mojito")!=null);
		appContext.close();
	}

}
