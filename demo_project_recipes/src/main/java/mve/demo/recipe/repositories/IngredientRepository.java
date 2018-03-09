package mve.demo.recipe.repositories;

import mve.demo.recipe.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
