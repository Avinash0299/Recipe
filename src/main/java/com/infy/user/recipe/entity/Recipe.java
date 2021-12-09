package com.infy.user.recipe.entity;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "recipe_table")

public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="recipe_id",nullable = false)
	String recipe_id;
	@Column(nullable = false)
	String recipeName;
	@Column(nullable = false)
	LocalDateTime date_of_creation;
	@Column(nullable = false)
	String recipeType;
	@Column(nullable = false)
	String quantity;
	@Column(nullable = false)
	String cookingInstructions;
	@OneToMany(cascade=CascadeType.MERGE)
	@JoinColumn(name="recipe_id")
	List<Ingredients> ing=new ArrayList<>();
	
	
	public Recipe() {
		super();
	}


	public List<Ingredients> getIng() {
		return ing;
	}


	public void setIng(List<Ingredients> ing) {
		this.ing = ing;
	}


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



	public String getCookingInstructions() {
		return cookingInstructions;
	}


	public void setCookingInstructions(String cookingInstructions) {
		this.cookingInstructions = cookingInstructions;
	}


	


}
	