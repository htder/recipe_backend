package com.watermelon.main;

import com.watermelon.main.ingredients.Ingredient;
import com.watermelon.main.recipes.Recipe;
import com.watermelon.main.recipes.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitializeDatabase {

    @Autowired
    private RecipeRepository recipeRepository;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Ingredient flour = new Ingredient("flour", "100", "g");
            Ingredient water = new Ingredient("water", "200", "ml");
            Recipe recipe = new Recipe("Bread", "White bread", 1, 220);
            recipe.setIngredients(List.of(flour, water));
            recipeRepository.save(recipe);

            List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();
            recipes.forEach(recipe1 -> System.out.println(recipe1));
        };
    }
}
