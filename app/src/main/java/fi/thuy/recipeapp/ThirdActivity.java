package fi.thuy.recipeapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import fi.thuy.recipecontents.Recipe;
import fi.thuy.recipecontents.RecipeList;
import fi.thuy.recipecontents.RecipeListAdapter;

public class ThirdActivity extends AppCompatActivity implements RecipeListAdapter.OnCardListener{
    RecyclerView recyclerView;
    RecipeList recipes = RecipeList.getInstance();
    RecipeListAdapter recipeListAdapter;
    ArrayList<Recipe> breakfast = new ArrayList<>();
    ArrayList<Recipe> lunch = new ArrayList<>();
    ArrayList<Recipe> dinner = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String uri = "@drawable/";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intentBack = new Intent(this, StartActivity.class );
        ImageButton btnHome = findViewById(R.id.buttonHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentBack);
                ThirdActivity.this.finish();
                intentBack.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            }
        });
        Intent intent = getIntent();
        String message = intent.getStringExtra( "key");

        TextView textView = findViewById(R.id.textViewLookingFor);

        textView.setText(getString(R.string.looking_for, message));

        // get the reference of RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        //call the constructor of RecipeListAdapter to send the reference and data to Adapter
        recipeListAdapter = new RecipeListAdapter(ThirdActivity.this, recipes.getListOfRecipes(), this);
        //set the adapter to recycler view
        recyclerView.setAdapter(recipeListAdapter);

    }

    @Override
    public void onCardClick(int position) {
        //opens new activity when each individual card is clicked
        ArrayList<String> ingredient = new ArrayList<>();
        ArrayList<String> instruction = new ArrayList<>();
        Recipe recipe = recipes.getListOfRecipes().get(position);

        Intent intent = new Intent(this, DetailActivity.class );

        intent.putExtra("Image", recipe.getImage());
        intent.putExtra("Title", recipe.getRecipeName() );
        intent.putExtra("Instructions", recipe.getInstructions());
        intent.putExtra("Serving", recipe.getServing());
        intent.putExtra("Time", recipe.getTime());
        intent.putExtra("calories", recipe.getCalories());

        String ingredients= recipe.getIngredients();
        String instructions = recipe.getInstructions();

        String[] partsIngredients =  ingredients.split(",");
        String[] partsInstructions = instructions.split(",");

        for(String p: partsIngredients) {
            p = p.replace("\"", "");
            p = p.replace("[","");
            p = p.replace("]","");
            ingredient.add(p);
        }

        for(String ins: partsInstructions) {
            ins = ins.replace("\"", "");
            ins = ins.replace("[","");
            ins = ins.replace("]","");
            instruction.add(ins);
        }

        intent.putExtra("Ingredients",ingredient);
        intent.putExtra("Instructions",instruction);
        startActivity(intent);
    }
}