package mve.demo.recipe.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  private BigDecimal amount;

  public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
    this(description, amount, unitOfMeasure, null);
  }

  public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure, Recipe recipe) {
    this.description = description;
    this.amount = amount;
    this.unitOfMeasure = unitOfMeasure;
    this.recipe = recipe;
  }

  @OneToOne
  private UnitOfMeasure unitOfMeasure;

  @ManyToOne
  private Recipe recipe;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public UnitOfMeasure getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }
}
