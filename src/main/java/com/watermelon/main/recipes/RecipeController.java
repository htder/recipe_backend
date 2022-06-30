package com.watermelon.main.recipes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(
            RecipeService recipeService
    ) {
        this.recipeService = recipeService;
    }

    @GetMapping("/all")
    public List<Recipe> getAllRecipes() {
        return this.recipeService.getAllRecipes();
    }

    @PostMapping("/recipe")
    public void addRecipe(@RequestBody Recipe recipe) {
        this.recipeService.saveRecipe(recipe);
    }
}
