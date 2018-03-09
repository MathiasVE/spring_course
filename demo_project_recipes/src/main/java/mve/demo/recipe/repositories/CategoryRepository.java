package mve.demo.recipe.repositories;

import mve.demo.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

  Optional<Category> findByDescription(String description);

}
