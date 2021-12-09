package com.infy.user.recipe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredients_table")

public class Ingredients {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	String ingredientsId;
	@Column(nullable = false)
	String ingredientsName;
	@Column(name="recipe_id", nullable = false)
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
	
	
	
}
