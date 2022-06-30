package com.watermelon.main.recipes;

import com.watermelon.main.ingredients.Ingredient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void printRecipes() {
        Ingredient flour = new Ingredient("flour", "100g", unit);
        Ingredient water = new Ingredient("water", "200ml", unit);
        Recipe recipe = new Recipe("Bread", "White bread", 1, timeRequiredInMin);
        recipe.setIngredients(List.of(flour, water));
        recipeRepository.save(recipe);

        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();
        recipes.forEach(recipe1 -> System.out.println(String.valueOf(recipe1)));
    }
}