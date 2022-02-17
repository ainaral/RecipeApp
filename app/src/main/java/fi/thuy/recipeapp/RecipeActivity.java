package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Recipe recipe = Recipes.getInstance().getRecipeList().get(getIntent().getIntExtra(ListActivity.RECIPE_ID, 0)
        );
        ((TextView) findViewById(R.id.tvRecipeTitle)).setText(recipe.getRecipeName());
        ((TextView) findViewById(R.id.tvIngredientsList)).setText(recipe.getRecipeIngredients());
        ((TextView) findViewById(R.id.tvInstructionOfRecipe)).setText(recipe.getRecipeInstructions());
    }
}