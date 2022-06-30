package com.watermelon.main.recipes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(
            RecipeService recipeService
    ) {
        this.recipeService = recipeService;
    }

}
