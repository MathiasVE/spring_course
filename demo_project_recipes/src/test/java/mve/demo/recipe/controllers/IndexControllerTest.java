package mve.demo.recipe.controllers;

import mve.demo.recipe.domain.Recipe;
import mve.demo.recipe.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
  public void testMockMVC() throws Exception {
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    mockMvc.perform(get("/"))
      .andExpect(status().isOk())
      .andExpect(view().name("index"));
  }

  @Test
  public void getIndexPage() {
    Recipe recipe = new Recipe();
    HashSet<Recipe> recipeData = new HashSet<>();
    recipeData.add(recipe);
    when(recipeService.getRecipes()).thenReturn(recipeData);

    String index = indexController.getIndexPage(model);
    assertEquals(index, "index");
    verify(recipeService, times(1)).getRecipes();
    verify(model, times(1)).addAttribute("recipes", recipeData);
  }
}