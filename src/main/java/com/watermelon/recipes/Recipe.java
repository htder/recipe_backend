package com.watermelon.recipes;

import com.watermelon.ingredients.Ingredient;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private int rating;
    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients;

}
