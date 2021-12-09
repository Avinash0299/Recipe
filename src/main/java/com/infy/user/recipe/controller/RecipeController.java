package com.infy.user.recipe.controller;

import java.util.HashMap;





import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.infy.user.recipe.dto.IngrdientsDTO;
import com.infy.user.recipe.dto.RecipeDTO;
import com.infy.user.recipe.entity.Recipe;
import com.infy.user.recipe.exception.RecipeException;
import com.infy.user.recipe.service.IngredientsService;
import com.infy.user.recipe.service.RecipeService;



@RestController
@CrossOrigin
@RequestMapping
public class RecipeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Environment environment;
	
	@Autowired
	RecipeService recipeservice;
	
	@Autowired
	IngredientsService ingservice;
	
	
	// Get all recipe
	//@GetMapping(value = "/api/recipes", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<RecipeDTO>> getAllRecipe() throws Exception {

		//List<RecipeDTO> recipeDTOs = recipeservice.getAllRecipe();
		//return new ResponseEntity<>(recipeDTOs, HttpStatus.OK);

	//}
	
// get all recipe	
	@GetMapping(value = "/view/recipes")
	public ResponseEntity<List<RecipeDTO>> getAllRecipe() throws RecipeException{
		try {
			List<RecipeDTO> list = recipeservice.getAllRecipe();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					exception.getMessage(), exception);
		}
	}


//create recipe
	@PostMapping(value = "/create/recipe")
	public ResponseEntity<String> create(@Valid @RequestBody RecipeDTO recp) throws RecipeException {

		try {
	      	String recipe_id =	recipeservice.saveRecipe(recp);
			 String successmsg = environment.getProperty("API.INSERT_SUCCESS_RECIPE") + recipe_id;
			return new ResponseEntity<>(successmsg, HttpStatus.ACCEPTED);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
					environment.getProperty(exception.getMessage()), exception);
		}

	}
	
	//update recipe
	@PutMapping(value = "/recipe/{recipe_id}")
	public ResponseEntity<String> updateRecipe( @PathVariable String recipe_id, @Valid @RequestBody RecipeDTO recipe)
			throws RecipeException {
		try {
			recipeservice.updateRecipe(recipe_id, recipe.getQuantity(), recipe.getCookingInstructions());
			String successMessage = environment.getProperty("API.UPDATE_SUCCESS_RECIPE");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
					environment.getProperty(exception.getMessage()), exception);
		}
	}

	// Delete recipe
	@DeleteMapping(value = "/recipe/delete/{recipe_id}")
	public ResponseEntity<String> del(@PathVariable String recipe_id) throws RecipeException {

		try {
			 recipeservice.deleteRecipe(recipe_id);
			 String successMessage = environment.getProperty("API.DELETE_SUCCESS_RECIPE");
				return new ResponseEntity<>(successMessage, HttpStatus.OK);
			} catch (Exception exception) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
						environment.getProperty(exception.getMessage()), exception);
			}
		}
	
	
// create ingredients
	@PostMapping(value = "create/ingredients")
	public ResponseEntity<String> create( @Valid @RequestBody IngrdientsDTO ing) throws RecipeException {

		try {
	      	String ingredientsId =	ingservice.saveIngredients(ing);
			 String successmsg = environment.getProperty("API.INSERT_SUCCESS_INGREDIENTS") + ingredientsId;
			return new ResponseEntity<>(successmsg, HttpStatus.ACCEPTED);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
					environment.getProperty(exception.getMessage()), exception);
		}

	}
			
	// get all ingredients
	@GetMapping(value = "/view/ingredients") 
	public ResponseEntity<List<IngrdientsDTO>> getAllIngredients() throws RecipeException {
		try {
			List<IngrdientsDTO> list = ingservice.getAllIngredients();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
					exception.getMessage(), exception);
		}
	}
	//update ingredients
	@PutMapping(value = "/ingredients/{ingredientsId}")
	public ResponseEntity<String> updateIngredients( @PathVariable String ingredientsId, @Valid @RequestBody IngrdientsDTO ings)
			throws RecipeException {
		try {
			ingservice.updateIngredients(ingredientsId, ings.getIngredientsName());
			String successMessage = environment.getProperty("API.UPDATE_SUCCESS_INGREDIENTS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
					environment.getProperty(exception.getMessage()), exception);
		}
	}


//delete ingredients
		@DeleteMapping(value = "/ingredients/delete/{ingredientsId}")
		public ResponseEntity<String> delete(@PathVariable String ingredientsId) throws RecipeException {

			try {
				 ingservice.deleteIngredients(ingredientsId);
				 String successMessage = environment.getProperty("API.DELETE_SUCCESS_INGREDIENTS");
					return new ResponseEntity<>(successMessage, HttpStatus.OK);
				} catch (Exception exception) {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
							environment.getProperty(exception.getMessage()), exception);
				}
			}
		}
