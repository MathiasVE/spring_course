package mve.demo.recipe.bootstrap;

import mve.demo.recipe.domain.Category;
import mve.demo.recipe.domain.Difficulty;
import mve.demo.recipe.domain.Ingredient;
import mve.demo.recipe.domain.Recipe;
import mve.demo.recipe.domain.UnitOfMeasure;
import mve.demo.recipe.repositories.CategoryRepository;
import mve.demo.recipe.repositories.RecipeRepository;
import mve.demo.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private RecipeRepository recipeRepository;
  private CategoryRepository categoryRepository;
  private UnitOfMeasureRepository unitOfMeasureRepository;


  public DevBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
    this.recipeRepository = recipeRepository;
    this.categoryRepository = categoryRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  private void initData() {
    createTacos();
    createGuacamole();
  }

  private void createTacos() {
    Recipe tacos = new Recipe();
    HashSet<Category> categories = new HashSet<>();
    categories.add(categoryRepository.findByDescription("Diner").get());
    categories.add(categoryRepository.findByDescription("Grill").get());
    categories.add(categoryRepository.findByDescription("Chicken").get());
    categories.add(categoryRepository.findByDescription("Quick and easy").get());
    tacos.setCategories(categories);

    tacos.setIngredients(new HashSet<>());
    tacos.addIngredient(getIngredient(2, unitOfMeasureRepository.findByDescription("Tablespoon").get(), "ancho chili powder"));
    tacos.addIngredient(getIngredient(1, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "dried oregano"));
    tacos.addIngredient(getIngredient(1, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "dried cumin"));
    tacos.addIngredient(getIngredient(1, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "sugar"));
    tacos.addIngredient(getIngredient(0.5, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "salt"));
    tacos.addIngredient(getIngredient(1, unitOfMeasureRepository.findByDescription("Clove").get(), "garlic, finely chopped"));
    tacos.addIngredient(getIngredient(1, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "finely grated orange zest"));
    tacos.addIngredient(getIngredient(3, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "fresh-squeezed orange juice"));
    tacos.addIngredient(getIngredient(2, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "olive oil"));
    tacos.addIngredient(getIngredient(4, unitOfMeasureRepository.findByDescription("Unit").get(), "skinless, boneless chicken thighs"));
    tacos.addIngredient(getIngredient(8, unitOfMeasureRepository.findByDescription("Unit").get(), "small corn tortillas"));
    tacos.addIngredient(getIngredient(3, unitOfMeasureRepository.findByDescription("Cup").get(), "packed baby arugula"));
    tacos.addIngredient(getIngredient(2, unitOfMeasureRepository.findByDescription("Unit").get(), "medium ripe avocados, sliced"));
    tacos.addIngredient(getIngredient(4, unitOfMeasureRepository.findByDescription("Pint").get(), "cherry tomatoes, halved"));
    tacos.addIngredient(getIngredient(0.5, unitOfMeasureRepository.findByDescription("Unit").get(), "red onion, thinly sliced"));
    tacos.addIngredient(getIngredient(0.25, unitOfMeasureRepository.findByDescription("Unit").get(), "skinless, boneless chicken thighs"));
    tacos.addIngredient(getIngredient(1, unitOfMeasureRepository.findByDescription("Unit").get(), "Roughly chopped cilantro"));
    tacos.addIngredient(getIngredient(0.5, unitOfMeasureRepository.findByDescription("Cup").get(), "sour cream"));
    tacos.addIngredient(getIngredient(1, unitOfMeasureRepository.findByDescription("Unit").get(), "lime, cut into wedges"));
    tacos.setDescription("Spicy Grilled Chicken Tacos");
    tacos.setCookTime(30);
    tacos.setDifficulty(Difficulty.EASY);
    tacos.setSource("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
    tacos.setDirections("");
    recipeRepository.save(tacos);
  }

  private void createGuacamole() {
    Recipe guacamole = new Recipe();
    HashSet<Category> categories = new HashSet<>();
    categories.add(categoryRepository.findByDescription("Mexican").get());
    categories.add(categoryRepository.findByDescription("Vegan").get());
    categories.add(categoryRepository.findByDescription("Dip").get());
    categories.add(categoryRepository.findByDescription("Avocado").get());
    guacamole.setCategories(categories);

    guacamole.setIngredients(new HashSet<>());
    guacamole.addIngredient(getIngredient(2, unitOfMeasureRepository.findByDescription("Unit").get(), "ripe advocados"));
    guacamole.addIngredient(getIngredient(0.5, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "Kosher salt"));
    guacamole.addIngredient(getIngredient(1, unitOfMeasureRepository.findByDescription("Tablespoon").get(), "Fresh lime juice or lemon juice"));
    guacamole.addIngredient(getIngredient(2, unitOfMeasureRepository.findByDescription("Tablespoon").get(), "ripe advocados"));
    guacamole.addIngredient(getIngredient(1, unitOfMeasureRepository.findByDescription("Unit").get(), "serano chiles, stems ad seeds removed, minced"));
    guacamole.addIngredient(getIngredient(2, unitOfMeasureRepository.findByDescription("Unit").get(), "chilantro"));
    guacamole.addIngredient(getIngredient(1, unitOfMeasureRepository.findByDescription("Pinch").get(), "freshly grated black pepper"));
    guacamole.addIngredient(getIngredient(0.5, unitOfMeasureRepository.findByDescription("Unit").get(), "ripe tomato, seeds and pulp removed, chopped"));
    guacamole.setDescription("Perfect guacamole");
    guacamole.setCookTime(10);
    guacamole.setDifficulty(Difficulty.EASY);
    guacamole.setSource("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
    guacamole.setDirections("");
    recipeRepository.save(guacamole);
  }

  private static Ingredient getIngredient(double amount, UnitOfMeasure unitOfMeasure, String description) {
    return new Ingredient(description, BigDecimal.valueOf(amount), unitOfMeasure);
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }
}
