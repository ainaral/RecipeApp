package fi.thuy.recipeapp;

import androidx.annotation.NonNull;

public class Recipe {


    private String recipeName;
    private String recipeIngredients;
    private String recipeInstructions;

    public Recipe(String recipeName, String recipeIngredients, String recipeInstructions) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstructions = recipeInstructions;
    }

    public Recipe(String recipeName){
        this.recipeName = recipeName;
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
