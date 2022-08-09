package com.watermelon.main.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/recipe/{id}")
    public Optional<Recipe> getRecipeById(@PathVariable Long id) {
        return this.recipeService.getRecipeById(id);
    }

    @PostMapping("/recipe")
    public void addRecipe(@RequestBody Recipe recipe) {
        this.recipeService.saveRecipe(recipe);
    }

    @DeleteMapping("/recipe/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        this.recipeService.deleteRecipeById(id);
    }
}
