package com.watermelon.main.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
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
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return this.recipeService.saveRecipe(recipe);
    }

    @DeleteMapping("/recipe/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        this.recipeService.deleteRecipeById(id);
    }

    @PutMapping("/recipe/{id}")
    public void updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        recipe.setRecipeId(id);
        this.recipeService.updateRecipe(recipe);
    }

}
