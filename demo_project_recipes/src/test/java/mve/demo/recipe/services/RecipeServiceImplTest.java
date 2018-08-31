package mve.demo.recipe.services;

import mve.demo.recipe.domain.Recipe;
import mve.demo.recipe.repositories.RecipeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

  private RecipeServiceImpl recipeService;

  @Mock
  private RecipeRepository recipeRepository;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    recipeService = new RecipeServiceImpl(recipeRepository);
  }

  @Test
  public void getRecipes() {
    Recipe recipe = new Recipe();
    HashSet recipeData = new HashSet();
    recipeData.add(recipe);

    when(recipeService.getRecipes()).thenReturn(recipeData);

    Iterable<Recipe> recipes = recipeService.getRecipes();
    AtomicInteger recipeCount = new AtomicInteger();
    recipes.forEach(r -> recipeCount.getAndIncrement());
    assertEquals(recipeCount.get(), 1);
    verify(recipeRepository, times(1));
  }
}