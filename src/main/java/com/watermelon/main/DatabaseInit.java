package com.watermelon.main;

import com.watermelon.main.ingredients.IngredientRepository;
import com.watermelon.main.recipes.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInit {

    @Bean
    public CommandLineRunner init(
            IngredientRepository ingredientRepository,
            RecipeRepository recipeRepository
    ) {
       return args -> {

       }
    }
}
