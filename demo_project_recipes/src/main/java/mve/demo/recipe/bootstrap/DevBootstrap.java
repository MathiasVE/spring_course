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

    HashSet<Ingredient> ingredients = new HashSet<>();
    ingredients.add(getIngredient(2, unitOfMeasureRepository.findByDescription("Tablespoon").get(), "ancho chili powder"));
    ingredients.add(getIngredient(1, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "dried oregano"));
    ingredients.add(getIngredient(1, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "dried cumin"));
    ingredients.add(getIngredient(1, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "sugar"));
    ingredients.add(getIngredient(0.5, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "salt"));
    ingredients.add(getIngredient(1, unitOfMeasureRepository.findByDescription("Clove").get(), "garlic, finely chopped"));
    ingredients.add(getIngredient(1, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "finely grated orange zest"));
    ingredients.add(getIngredient(3, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "fresh-squeezed orange juice"));
    ingredients.add(getIngredient(2, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "olive oil"));
    ingredients.add(getIngredient(4, unitOfMeasureRepository.findByDescription("Unit").get(), "skinless, boneless chicken thighs"));
    ingredients.add(getIngredient(8, unitOfMeasureRepository.findByDescription("Unit").get(), "small corn tortillas"));
    ingredients.add(getIngredient(3, unitOfMeasureRepository.findByDescription("Cup").get(), "packed baby arugula"));
    ingredients.add(getIngredient(2, unitOfMeasureRepository.findByDescription("Unit").get(), "medium ripe avocados, sliced"));
    ingredients.add(getIngredient(4, unitOfMeasureRepository.findByDescription("Pint").get(), "cherry tomatoes, halved"));
    ingredients.add(getIngredient(0.5, unitOfMeasureRepository.findByDescription("Unit").get(), "red onion, thinly sliced"));
    ingredients.add(getIngredient(0.25, unitOfMeasureRepository.findByDescription("Unit").get(), "skinless, boneless chicken thighs"));
    ingredients.add(getIngredient(1, unitOfMeasureRepository.findByDescription("Unit").get(), "Roughly chopped cilantro"));
    ingredients.add(getIngredient(0.5, unitOfMeasureRepository.findByDescription("Cup").get(), "sour cream"));
    ingredients.add(getIngredient(1, unitOfMeasureRepository.findByDescription("Unit").get(), "lime, cut into wedges"));
    tacos.setIngredients(ingredients);
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

    HashSet<Ingredient> ingredients = new HashSet<>();
    ingredients.add(getIngredient(2, unitOfMeasureRepository.findByDescription("Unit").get(), "ripe advocados"));
    ingredients.add(getIngredient(0.5, unitOfMeasureRepository.findByDescription("Teaspoon").get(), "Kosher salt"));
    ingredients.add(getIngredient(1, unitOfMeasureRepository.findByDescription("Tablespoon").get(), "Fresh lime juice or lemon juice"));
    ingredients.add(getIngredient(2, unitOfMeasureRepository.findByDescription("Tablespoon").get(), "ripe advocados"));
    ingredients.add(getIngredient(1, unitOfMeasureRepository.findByDescription("Unit").get(), "serano chiles, stems ad seeds removed, minced"));
    ingredients.add(getIngredient(2, unitOfMeasureRepository.findByDescription("Unit").get(), "chilantro"));
    ingredients.add(getIngredient(1, unitOfMeasureRepository.findByDescription("Pinch").get(), "freshly grated black pepper"));
    ingredients.add(getIngredient(0.5, unitOfMeasureRepository.findByDescription("Unit").get(), "ripe tomato, seeds and pulp removed, chopped"));
    guacamole.setIngredients(ingredients);
    guacamole.setDescription("Perfect guacamole");
    guacamole.setCookTime(10);
    guacamole.setDifficulty(Difficulty.EASY);
    guacamole.setSource("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
    guacamole.setDirections("");
    recipeRepository.save(guacamole);
  }

  private static Ingredient getIngredient(double amount, UnitOfMeasure unitOfMeasure, String description) {
    Ingredient ingredient = new Ingredient();
    ingredient.setAmount(BigDecimal.valueOf(amount));
    ingredient.setDescription(description);
    ingredient.setUnitOfMeasure(unitOfMeasure);
    return ingredient;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }
}
