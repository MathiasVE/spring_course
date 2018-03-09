package mve.demo.recipe;

import mve.demo.recipe.domain.Category;
import mve.demo.recipe.domain.Difficulty;
import mve.demo.recipe.domain.Ingredient;
import mve.demo.recipe.domain.Note;
import mve.demo.recipe.domain.Recipe;
import mve.demo.recipe.domain.UnitOfMeasure;
import mve.demo.recipe.repositories.CategoryRepository;
import mve.demo.recipe.repositories.RecipeRepository;
import mve.demo.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.HashSet;

@SpringBootApplication
public class RecipeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(RecipeApplication.class, args);
	}

}
