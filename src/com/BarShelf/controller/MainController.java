package com.BarShelf.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.BarShelf.entities.Cocktail;
import com.BarShelf.entities.Ingredient;
import com.BarShelf.entities.User;
import com.BarShelf.services.CocktailService;
import com.BarShelf.services.IngredientService;
import com.BarShelf.services.UserService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes({ "ingredient", "user" })
public class MainController {
	@ModelAttribute("user")
	public User setUpUser() {
		return new User();
	}

	@RequestMapping("/")
	public String index1Handler() {
		return "index";
	}

	@RequestMapping("/index")
	public String index2Handler(@SessionAttribute(value = "user", required = false) User user) {

		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginHandler(@ModelAttribute User user, ModelMap model) {
		ModelAndView mav = new ModelAndView();
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.BarShelf");
		appContext.refresh();
		UserService us = (UserService) appContext.getBean("userService");

		String message = null;
		String viewName = null;

		if (us.checkUserExists(user.getEmail())) {
			if (us.findUser(user.getEmail(), user.getPassword()) != null) {
				model.put("user", us.findUser(user.getEmail(), user.getPassword()));
				appContext.close();
				viewName = ("redirect:barshelf");
			} else {
				message = "Wrong password or email. <br> <a href = 'register'>Click here to signup</a>";
			}

		} else {
			message = "Wrong password or email. <br> <a href = 'register'>Click here to signup</a>";

		}
		appContext.close();
		mav.setViewName(viewName);
		mav.addObject("message", message);
		return mav; // jsp
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginHandler() {
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUserHandler(@ModelAttribute User user) {

		ModelAndView mav = new ModelAndView();
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.BarShelf");
		appContext.refresh();
		UserService us = (UserService) appContext.getBean("userService");

		String message = null;
		String viewName = null;

		if (us.checkUserExists(user.getEmail())) {
			message = "This email already has an account";
			viewName = "register";
		} else {
			us.registerUser(user);
			viewName = "index";
		}

		appContext.close();
		mav.addObject("message", message);
		mav.setViewName(viewName);
		return mav; // jsp
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerUserHandler() {
		return "register";
	}

	@RequestMapping("/searchCocktailByIngredient")
	public ModelAndView searchCocktailByIngredientHandler(ModelMap model,
			@RequestParam(value = "ingredient", required = false) String ingredient,
			@RequestParam(value = "alc-check", required = false) String alc_check) {
		
		ModelAndView mav = new ModelAndView();
		model.put("cocktailName", null);
		String viewname = "home";
		if (ingredient != null) {
			model.put("ingredient", ingredient);
		} else if (model.get("ingredient") != null) {
			ingredient = (String) model.get("ingredient");
		} else {
			viewname = "index";
		}

		CocktailService cs = new CocktailService();
		List<Cocktail> cocktails = null;
		if (alc_check != null) {
			cocktails = cs.getCocktailByIngredientNA(ingredient);

		} else {
			cocktails = cs.getCocktailByIngredient(ingredient);
	

		}

		mav.addObject("cocktails", cocktails);
		mav.setViewName(viewname);
		return mav;
	}

	@RequestMapping(value = "/displayCocktail")
	public ModelAndView displayCocktailHandler(@RequestParam("cocktailName") String cocktailName,
			@SessionAttribute(value = "user", required = false) User user,
			@RequestParam(value = "ingredient", required = false) String ingredientname) {
		
		ModelAndView mav = new ModelAndView();
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.BarShelf");
		appContext.refresh();
		String message = null;
		CocktailService cs = (CocktailService) appContext.getBean("cocktailService");
		UserService us = (UserService) appContext.getBean("userService");
		java.util.Map<Ingredient, String> im = cs.getIngredientsByCocktailName(cocktailName);
		
	
		if (cs.getCocktailByName(cocktailName) == null) {
			mav.setViewName("index");
			appContext.close();
			return mav;
		}
		if (ingredientname != null) {
			if (user == null || user.getEmail() == null) {
				message = "You need to login first. <a href = 'login'>Click here to login</a> ";
			} else {
				IngredientService is = (IngredientService) appContext.getBean("ingredientService");
				Ingredient ingredient = is.findIngredientByName(ingredientname);
				List<Ingredient> barshelf = user.getBarshelf();
				System.out.println(barshelf.size());
				if (barshelf.contains(is.findIngredientByName(ingredientname))) {
					message = ingredientname + " is already on your BarShelf";
				} else {
					user.getBarshelf().add(ingredient);
					if (us.updateUser(user))
						message = "added " + ingredientname + " to your BarShelf";
				}

			}
		}
		Cocktail cocktail = cs.getCocktailByName(cocktailName);
		appContext.close();
		mav.addObject("cocktail", cocktail);
		mav.addObject("im", im);
		mav.addObject("message", message);

		return mav;
	}

	@RequestMapping(value = "/barshelf")
	public ModelAndView barshelfHandler(@SessionAttribute("user") User user,
			@RequestParam(value = "deleteIngredientName", required = false) String iDeleteName) {
		ModelAndView mav = new ModelAndView();
		String viewname = null;

		if (user == null || user.getEmail() == null) {
			viewname = "login";
		} else {
			
			List<Ingredient> barshelf = user.getBarshelf();
			viewname = "barshelf";
			mav.addObject("barshelf", barshelf);
			AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
			appContext.scan("com.BarShelf");
			appContext.refresh();

			IngredientService is = (IngredientService) appContext.getBean("ingredientService");
			UserService us = (UserService) appContext.getBean("userService");
			if (iDeleteName != null) {

				Ingredient ingredient = is.findIngredientByName(iDeleteName);
				System.out.println(barshelf.size());

				barshelf.remove(ingredient);
			}
			us.updateUser(user);
		}
		mav.setViewName(viewname);
		return mav;
	}
	
	@RequestMapping("/error")
	public ModelAndView errorHandler(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int requestStatusCode = (int) request.getAttribute("javax.servlet.error.status_code");
		
		mav.addObject("code", requestStatusCode);
		mav.setViewName("error");
		
		return mav;
	}

}
