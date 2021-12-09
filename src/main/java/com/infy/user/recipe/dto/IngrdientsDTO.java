package com.infy.user.recipe.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.infy.user.recipe.entity.Ingredients;
import com.infy.user.recipe.entity.Recipe;



public class IngrdientsDTO {
	
	
	String ingredientsId;
	@NotNull(message = "Please provide ingredients name")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "Name should contain only alphabets and space")
	String ingredientsName;
	
	String recipe_id;

public String getIngredientsId() {
		return ingredientsId;
	}

	public void setIngredientsId(String ingredientsId) {
		this.ingredientsId = ingredientsId;
	}
	
	public String getIngredientsName() {
		return ingredientsName;
	}

	public void setIngredientsName(String ingredientsName) {
		this.ingredientsName = ingredientsName;
	}

	public String getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
	}
	
	
	public IngrdientsDTO(String ingredientsName, String recipe_id, String ingredientsId) {
		this();
		this.ingredientsName = ingredientsName;
		this.recipe_id = recipe_id;
		this.ingredientsId = ingredientsId;
	}
	
	public IngrdientsDTO() {
		super();
	}
	
//	public Ingredients createIng() {
	//	Ingredients ing = new Ingredients();
		//ing.setIngredientsName(this.getIngredientsName());
		//ing.setRecipe_id(this.getRecipe_id());
		//return ing;
	//}



	@Override
	public String toString() {
		return "IngrdientsDTO [ingredientsId=" + ingredientsId + ", ingredientsName=" + ingredientsName + ", recipe_id="
				+ recipe_id + "]";
	}

	public static IngrdientsDTO valueOf(Ingredients ing) {
		IngrdientsDTO ingsDTO = new IngrdientsDTO();
		ingsDTO.setIngredientsId(ing.getIngredientsId());
		ingsDTO.setIngredientsName(ing.getIngredientsName());
		ingsDTO.setRecipe_id(ing.getRecipe_id());
		return ingsDTO;
	}
	
	public Ingredients createIngredients() {
		Ingredients ing = new Ingredients();
		ing.setRecipe_id(this.getRecipe_id());
		ing.setIngredientsName(this.getIngredientsName());
		ing.setIngredientsId(this.getIngredientsId());
			return ing;
	}
	

	
	
	
	
}



