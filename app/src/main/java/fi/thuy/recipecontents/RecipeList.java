package fi.thuy.recipecontents;

import java.util.ArrayList;

public class RecipeList {
    private final ArrayList<Recipe> listOfRecipes;
    private static final RecipeList recipes = new RecipeList();

    public static RecipeList getInstance(){
        return recipes;
    }

    private RecipeList(){
        this.listOfRecipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe){
        this.listOfRecipes.add(recipe);
    }

    public ArrayList<Recipe> getListOfRecipes(){
        return listOfRecipes;
    }

    public void clear() {
        this.listOfRecipes.clear();
    }
}
