package com.watermelon.main.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(
            RecipeRepository recipeRepository
    ) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes() {
        return this.recipeRepository.findAll();
    }

    public void saveRecipe(Recipe recipe) {
        this.recipeRepository.save(recipe);
    }

    public void deleteRecipeById(Long id) {
        this.recipeRepository.deleteById(id);
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return this.recipeRepository.findById(id);
    }

    public void updateRecipe(Recipe recipe) { this.recipeRepository.save(recipe); }
}
