package mve.demo.recipe.services;

import mve.demo.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {

  Iterable<Recipe> getRecipes();

}
