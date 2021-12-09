package com.infy.user.recipe.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.infy.user.recipe.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {

	
	
	
}
