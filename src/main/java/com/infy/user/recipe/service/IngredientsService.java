package com.infy.user.recipe.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.user.recipe.dto.IngrdientsDTO;
import com.infy.user.recipe.dto.RecipeDTO;
import com.infy.user.recipe.entity.Ingredients;
import com.infy.user.recipe.entity.Recipe;
import com.infy.user.recipe.exception.RecipeException;
import com.infy.user.recipe.repository.IngredientsRepository;
import com.infy.user.recipe.repository.RecipeRepository;

@Service
@Transactional
public class IngredientsService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IngredientsRepository ingRepo;
	
	//get ingredients
	public List<IngrdientsDTO> getAllIngredients() throws RecipeException {

		Iterable<Ingredients> ings = ingRepo.findAll();
		List<IngrdientsDTO> ingDTOs = new ArrayList<>();

		ings.forEach(ing -> {
			IngrdientsDTO ingDTO = IngrdientsDTO.valueOf(ing);
			ingDTOs.add(ingDTO);
		});
		if (ingDTOs.isEmpty())
			throw new RecipeException("Service.INGREDIENTS_NOT_FOUND");
		logger.info("Recipe Details : {}", ingDTOs);
		return ingDTOs;
	
	}
	//create ingredients
	public String saveIngredients(IngrdientsDTO ingsDTO) throws RecipeException {
		logger.info("creation request for ingredients with data {}", ingsDTO);
		Ingredients ings = ingsDTO.createIngredients();
		Ingredients ing = ingRepo.save(ings);
		return ing.getIngredientsId();
		
	}
	
	//delete ingredients
	public void deleteIngredients(String ingredientsId) throws RecipeException {
		Optional<Ingredients> ing = ingRepo.findById(ingredientsId);
		ing.orElseThrow(() -> new RecipeException("Service.INGREDIENTS_NOT_FOUND"));
		ingRepo.deleteById(ingredientsId);
		
		
	}
	
	//update ingredients
	public void updateIngredients(String ingredientsId, String ingredientsName) throws RecipeException {
		Optional<Ingredients> ings = ingRepo.findById(ingredientsId);
		Ingredients ing = ings.orElseThrow(() -> new RecipeException("Service.INGREDIENTS_NOT_FOUND"));
		ing.setIngredientsName(ingredientsName);
	}
}
	