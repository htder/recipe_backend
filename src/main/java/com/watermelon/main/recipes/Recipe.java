package com.watermelon.main.recipes;

import com.watermelon.main.ingredients.Ingredient;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue
    private Long recipeId;
    private String name;
    private String description;
    private int rating;
    @OneToMany(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "recipe_id",
            referencedColumnName = "recipeId"
    )
    private List<Ingredient> ingredients;

    public Recipe() {}

    public Recipe(
            String name,
            String description,
            int rating
    ) {
        this.name = name;
        this.description = description;
        this.rating = rating;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + recipeId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", ingredients=" + ingredients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return rating == recipe.rating && recipeId.equals(recipe.recipeId) && name.equals(recipe.name) && description.equals(recipe.description) && ingredients.equals(recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, name, description, rating, ingredients);
    }
}
