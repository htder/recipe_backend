package com.watermelon.main;

import com.watermelon.main.ingredients.Ingredient;
import com.watermelon.main.instructions.Instruction;
import com.watermelon.main.recipes.Recipe;
import com.watermelon.main.recipes.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;

@Configuration
public class InitializeDatabase {

    @Autowired
    private final RecipeRepository recipeRepository;

    public InitializeDatabase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Ingredient flour = new Ingredient("flour", "100", "g");
            Ingredient water = new Ingredient("water", "200", "ml");
            Instruction i1 = new Instruction("open", 1);
            Instruction i2 = new Instruction("close", 2);
            Recipe recipe = new Recipe("Bread", "White bread", 1, 220);
            recipe.setIngredients(Set.of(flour, water));
            recipe.setInstructions(Set.of(i1, i2));
            recipeRepository.save(recipe);

            List<Recipe> recipes = recipeRepository.findAll();
            recipes.forEach(recipe1 -> System.out.println(recipe1));
        };
    }
}
