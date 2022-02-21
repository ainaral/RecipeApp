package fi.thuy.recipecontents;

import android.graphics.drawable.Drawable;

public class Recipe {
    private int id;
    private String recipeName;
    private String mealType;
    private String instructions;
    private String ingredients;
    private String tags;
    private int image;

    public Recipe(int id, String recipeName, String mealType, String instructions, String ingredients, String tags, int image) {
        this.id = id;
        this.recipeName = recipeName;
        this.mealType = mealType;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.tags = tags;
        this.image = image;
    }

    public Recipe(int id, String recipeName, String mealType, String instructions, String ingredients, String tags) {
        this.id = id;
        this.recipeName = recipeName;
        this.mealType = mealType;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getMealType() {
        return mealType;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getTags() {
        return tags;
    }

    public int getImage() {
        return image;
    }
}

