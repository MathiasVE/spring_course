package mve.demo.recipe.controllers;

import mve.demo.recipe.domain.Recipe;
import mve.demo.recipe.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IndexControllerTest {

  private IndexController indexController;

  @Mock
  private RecipeService recipeService;
  @Mock
  private Model model;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.indexController = new IndexController(recipeService);
  }

  @Test
  public void getIndexPage() {
    Recipe recipe = new Recipe();
    HashSet recipeData = new HashSet();
    recipeData.add(recipe);
    when(recipeService.getRecipes()).thenReturn(recipeData);


    String index = indexController.getIndexPage(model);
    assertEquals(index, "index");
    verify(model, times(1)).addAttribute("recipes", recipeData);
  }
}