package com.watermelon.main.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void deleteRecipeByid(Long id) {
        this.recipeRepository.deleteById(id);
    }

}
