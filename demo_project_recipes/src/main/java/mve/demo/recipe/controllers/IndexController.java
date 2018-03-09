package mve.demo.recipe.controllers;

import mve.demo.recipe.domain.Category;
import mve.demo.recipe.domain.Recipe;
import mve.demo.recipe.domain.UnitOfMeasure;
import mve.demo.recipe.repositories.CategoryRepository;
import mve.demo.recipe.repositories.RecipeRepository;
import mve.demo.recipe.repositories.UnitOfMeasureRepository;
import mve.demo.recipe.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

  private RecipeService recipeService;

  public IndexController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @RequestMapping({"", "/", "index"})
  public String getIndexPage(Model model) {

    model.addAttribute("recipes", recipeService.getRecipes());

    return "index";
  }
}
