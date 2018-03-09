package mve.demo.recipe.controllers;

import mve.demo.recipe.domain.Category;
import mve.demo.recipe.domain.UnitOfMeasure;
import mve.demo.recipe.repositories.CategoryRepository;
import mve.demo.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

  private CategoryRepository categoryRepository;
  private UnitOfMeasureRepository unitOfMeasureRepository;

  public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
    this.categoryRepository = categoryRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  @RequestMapping({"", "/", "index"})
  public String getIndexPage() {

    Optional<Category> category = categoryRepository.findByDescription("American");
    Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

    System.out.println("Cat: " + category.get().getId());
    System.out.println("Uom: " + unitOfMeasure.get().getId());

    return "index";
  }
}
