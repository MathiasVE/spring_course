package mve.demo.recipe.services;

import mve.demo.recipe.domain.Recipe;
import mve.demo.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

  private RecipeRepository recipeRepository;

  public RecipeServiceImpl(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  public Iterable<Recipe> getRecipes () {
    return recipeRepository.findAll();
  }
}
