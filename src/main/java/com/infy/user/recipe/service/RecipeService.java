package com.infy.user.recipe.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.infy.user.recipe.dto.IngrdientsDTO;
import com.infy.user.recipe.dto.RecipeDTO;
import com.infy.user.recipe.entity.Ingredients;
import com.infy.user.recipe.entity.Recipe;
import com.infy.user.recipe.exception.RecipeException;
import com.infy.user.recipe.repository.RecipeRepository;



@Service
@Transactional
public class RecipeService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RecipeRepository recipeRepo;

	
	//create recipe
	public String saveRecipe(RecipeDTO recipeDTO) throws RecipeException {
		logger.info("creation request for recipe with data {}", recipeDTO);
		Recipe recipe = recipeDTO.createRecipe();
		Recipe rcp = recipeRepo.save(recipe);
		//return "Recipe added successfully with Recipe_id: "+ recipe.getRecipe_id();
		return rcp.getRecipe_id();
		
	}

	//Get all recipe details
	public List<RecipeDTO> getAllRecipe() throws RecipeException {

		Iterable<Recipe> recipes = recipeRepo.findAll();
		List<RecipeDTO> recipeDTOs = new ArrayList<>();

		recipes.forEach(recipe -> {
			RecipeDTO recipeDTO = RecipeDTO.valueOf(recipe);
			recipeDTOs.add(recipeDTO);
		});
		if (recipeDTOs.isEmpty())
			throw new RecipeException("Service.RECIPES_NOT_FOUND");
		logger.info("Recipe Details : {}", recipeDTOs);
		return recipeDTOs;
	
	}
	

	//Delete recipe
	public void deleteRecipe(String recipe_id) throws RecipeException {
		Optional<Recipe> recipe = recipeRepo.findById(recipe_id);
		recipe.orElseThrow(() -> new RecipeException("Service.RECIPES_NOT_FOUND"));
		recipeRepo.deleteById(recipe_id);
		//return "Recipe deleted successfully";
	}
	
	//update recipe
	public void updateRecipe(String recipe_id, String quantity, String cookingInstructions) throws RecipeException {
		Optional<Recipe> recipe = recipeRepo.findById(recipe_id);
		Recipe rcp = recipe.orElseThrow(() -> new RecipeException("Service.RECIPES_NOT_FOUND"));
		rcp.setQuantity(quantity);
		rcp.setCookingInstructions(cookingInstructions);
	}
	
	// create ingredients
	//	public void createIngredients(String recipe_id,IngrdientsDTO ingDTO) {
		//	logger.info("Creation request for customer {} with data {}", recipe_id, ingDTO);
			//ingDTO.setRecipe_id(recipe_id);
			//Ingredients ing = ingDTO.createIng();
			//List<Ingredients> ingList= new ArrayList<>();
			//ingList.add(ing);
			
			//Recipe rep = reciperepo.getOne(recipe_id);
			//rep.getIng().add(ing);
			//rep.setIng(rep.getIng());
			//reciperepo.save(rep);
		}
		

		
	//Update isprivileged
	//public Recipe updateIsprivilege(Recipe buyer, String buyerid) throws InfyMarketException{
		//Recipe existingBuyer = buyerrepo.findById(buyerid).orElse(null);
		//if ((existingBuyer != null) && (existingBuyer.getRewardpoints() >= 10000)) {
			//existingBuyer.setIsprivileged(buyer.getIsprivileged());
			//return buyerrepo.save(existingBuyer);
		//}else {
			//throw new InfyMarketException("Service.NO_REWARD_POINTS");
		//}
	


