package com.watermelon.main.recipes;

import com.watermelon.main.ingredients.Ingredient;
import com.watermelon.main.instructions.Instruction;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue
    private Long recipeId;
    private String name;
    private String description;
    private int rating;
    private int timeRequiredInMin;
    @OneToMany(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "recipe_id",
            referencedColumnName = "recipeId"
    )
    private Set<Ingredient> ingredients;
    @OneToMany(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    private Set<Instruction> instructions;

    public Recipe() {}

    public Recipe(
            String name,
            String description,
            int rating,
            int timeRequiredInMin) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.timeRequiredInMin = timeRequiredInMin;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long id) {
        this.recipeId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getTimeRequiredInMin() {
        return timeRequiredInMin;
    }

    public void setTimeRequiredInMin(int timeRequiredInMin) {
        this.timeRequiredInMin = timeRequiredInMin;
    }

    public Set<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(Set<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return rating == recipe.rating && timeRequiredInMin == recipe.timeRequiredInMin && Objects.equals(recipeId, recipe.recipeId) && Objects.equals(name, recipe.name) && Objects.equals(description, recipe.description) && Objects.equals(ingredients, recipe.ingredients) && Objects.equals(instructions, recipe.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, name, description, rating, timeRequiredInMin, ingredients, instructions);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", timeRequiredInMin=" + timeRequiredInMin +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                '}';
    }
}
