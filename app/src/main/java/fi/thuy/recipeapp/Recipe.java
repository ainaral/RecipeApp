package fi.thuy.recipeapp;

import androidx.annotation.NonNull;

public class Recipe {


    private final String recipeName;
    private final String recipeIngredients;
    private final String recipeInstructions;

    public Recipe(String recipeName, String recipeIngredients, String recipeInstructions) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstructions = recipeInstructions;
    }

    public String getRecipeName() {
        return recipeName;
    }
    public String getRecipeIngredients() {
        return recipeIngredients;
    }
    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    @NonNull
    @Override
    public String toString() {
        return recipeName;
    }
}
