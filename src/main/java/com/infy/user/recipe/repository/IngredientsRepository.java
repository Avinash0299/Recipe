package com.infy.user.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.user.recipe.entity.Ingredients;

public interface IngredientsRepository extends JpaRepository<Ingredients, String> {
}
