package com.BarShelf.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.BarShelf.entities.Ingredient;

public class IngredientDAO implements IngredientDAOI {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	final String persistenceName = "BarShelf";

	private static String readAll(Reader read) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = read.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(read);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public Ingredient getIngredient(String name) {
		Ingredient ingredient = new Ingredient();
		try {
			emf = Persistence.createEntityManagerFactory(persistenceName);
			em = emf.createEntityManager();

			ingredient = em.find(Ingredient.class, name);
			if (ingredient == null) {
				ingredient = new Ingredient();
				String ingredienturlstring = name.replaceAll(" ", "%20");

				JSONObject json2 = readJsonFromUrl(
						"https://www.thecocktaildb.com/api/json/v1/1/search.php?i=" + ingredienturlstring);
				JSONObject ingredientobj = (JSONObject) ((JSONArray) json2.get("ingredients")).get(0);
				String description = "Not much to say about this one. The title and image are self-explanatory";
				if (ingredientobj.get("strDescription") != JSONObject.NULL) {
					description = (String) ingredientobj.get("strDescription");
				}
				String image = "https://www.thecocktaildb.com/images/ingredients/" + name + ".png";
				int abv = 0;
				if (ingredientobj.get("strABV") != JSONObject.NULL) {
					abv = (int) Integer.parseInt((String) ingredientobj.get("strABV"));
				}
				ingredient.setName(name);
				ingredient.setImage(image);
				ingredient.setDescription(description);
				ingredient.setAbv(abv);

				em.getTransaction().begin();
				em.persist(ingredient);
				em.getTransaction().commit();

//				ingredient.setAbv(0);
//				ingredient.setDescription("Not much to say about this one. The title and image are self-explanatory");
//				ingredient.setImage("https://www.clipartmax.com/png/middle/454-4546089_shot-glass-png-file-shot-glass-vector-png.png");
//				ingredient.setName(name);
			}
		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

		return ingredient;
	}
}
