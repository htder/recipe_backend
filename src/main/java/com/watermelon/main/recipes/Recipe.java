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
    private Long id;
    private String name;
    private String description;
    private int rating;
    @OneToMany(mappedBy = "recipe")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
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
        return rating == recipe.rating && id.equals(recipe.id) && name.equals(recipe.name) && description.equals(recipe.description) && ingredients.equals(recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, rating, ingredients);
    }
}
