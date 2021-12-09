package com.infy.user.recipe.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.infy.user.recipe.entity.Ingredients;
import com.infy.user.recipe.entity.Recipe;

public class RecipeDTO {
	

	
	String recipe_id;
	@NotNull(message = "Please provide recipe name")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "Name should contain only alphabets and space")
	String recipeName;
	@DateTimeFormat(pattern="YYYY-MM-DD hh:mm:ss")
	@NotNull(message = "Please provide date and time")
	LocalDateTime date_of_creation;
	@NotNull(message = "Please provide Recipe Type")
	@Pattern(regexp = "[A-Z]*", message = "Recipe Type should contain only alphabet")
	String recipeType;
	@NotNull(message = "Please provide Quantity")
	
	@Pattern(regexp = "[1-9]*", message = "Recipe Type should contain value")
	String quantity;
	List<String> ingredientsName;
	@NotNull(message = "Please provide cooking instuctions")
	String cookingInstructions;
	
	
	
	
   public String getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public LocalDateTime getDate_of_creation() {
		return date_of_creation;
	}

	public void setDate_of_creation(LocalDateTime date_of_creation) {
		this.date_of_creation = date_of_creation;
	}

	public String getRecipeType() {
		return recipeType;
	}

	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	

	public List<String> getIngredientsName() {
		return ingredientsName;
	}

	public void setIngredientsName(List<String> ingList) {
		this.ingredientsName = ingList;
	}

	public String getCookingInstructions() {
		return cookingInstructions;
	}

	public void setCookingInstructions(String cookingInstructions) {
		this.cookingInstructions = cookingInstructions;
	}
	

	

	@Override
	public String toString() {
		return "RecipeDTO [recipe_id=" + recipe_id + ", recipeName=" + recipeName + ", date_of_creation="
				+ date_of_creation + ", recipeType=" + recipeType + ", quantity=" + quantity + ", ingredientsName="
				+ ingredientsName + ", cookingInstructions=" + cookingInstructions + "]";
	}

	// Converts Entity into DTO
	public static RecipeDTO valueOf(Recipe reciepe) {
		RecipeDTO recipeDTO = new RecipeDTO();
		recipeDTO.setRecipe_id(reciepe.getRecipe_id());
		recipeDTO.setRecipeName(reciepe.getRecipeName());
		recipeDTO.setRecipeType(reciepe.getRecipeType());
		recipeDTO.setDate_of_creation(reciepe.getDate_of_creation());
		recipeDTO.setQuantity(reciepe.getQuantity());
		recipeDTO.setCookingInstructions(reciepe.getCookingInstructions());
		List<Ingredients> ings = reciepe.getIng();
		List<String> ingList = new ArrayList<>();
		for (Ingredients ing : ings) {
			ingList.add(ing.getIngredientsName());
		}
		recipeDTO.setIngredientsName(ingList);
		return recipeDTO;
	}

	public Recipe createRecipe() {
		Recipe recipe = new Recipe();
		recipe.setRecipe_id(this.getRecipe_id());
		recipe.setRecipeName(this.getRecipeName());
		recipe.setRecipeType(this.getRecipeType());
		recipe.setDate_of_creation(this.getDate_of_creation());
		recipe.setQuantity(this.getQuantity());
	    recipe.setCookingInstructions(this.getCookingInstructions());
		return recipe;
	}

}
