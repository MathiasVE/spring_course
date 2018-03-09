package mve.demo.recipe.services;

import mve.demo.recipe.domain.Recipe;
import mve.demo.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

  private RecipeRepository recipeRepository;

  public RecipeService(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  public Iterable<Recipe> getRecipes () {
    return recipeRepository.findAll();
  }
}
