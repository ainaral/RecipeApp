package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import fi.thuy.recipecontents.RecipeList;

public class DetailActivity extends AppCompatActivity {
    protected static final String PREFERENCE_FILE_NAME = "pref_file";
    protected static final String PREF_KEY_TITLE= "Title";
    private  String title;
    SharedPreferences sp;
    RecipeList recipes = RecipeList.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        sp = getSharedPreferences(PREFERENCE_FILE_NAME, Activity.MODE_PRIVATE);
        title = sp.getString(PREF_KEY_TITLE,title);

        Intent intent = getIntent();

        Bundle bundle = getIntent().getExtras();
        TextView textViewTitle = findViewById(R.id.tv_recipe_name);
        textViewTitle.setText(intent.getStringExtra("Title"));

        ImageView imageView = findViewById(R.id.imageViewRecipe);
        int resId = bundle.getInt("Image");
        imageView.setImageResource(resId);

        ImageButton buttonFav = findViewById(R.id.iconFavourite);

        buttonFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp = getSharedPreferences(PREFERENCE_FILE_NAME, Activity.MODE_PRIVATE);

                SharedPreferences.Editor spEditor = sp.edit();
                spEditor.putString(PREF_KEY_TITLE, intent.getStringExtra("Title"));
                spEditor.apply();
            }
        });

        TextView textViewIngredients = findViewById(R.id.tv_Ingredients);
        TextView textViewInstructions = findViewById(R.id.tv_Instructions);
        TextView textViewServing = findViewById(R.id.tvServing);
        TextView textViewTime = findViewById(R.id.tvTime);
        TextView textViewCalories = findViewById(R.id.tvCalories);

        textViewServing.setText(intent.getStringExtra("Serving"));
        textViewTime.setText(intent.getStringExtra("Time"));
        textViewCalories.setText(intent.getStringExtra("calories"));

        ArrayList<String> ingredients1 = (ArrayList<String>) getIntent().getSerializableExtra("Ingredients");
        StringBuilder ingredients = new StringBuilder();
        for(int i = 0 ; i < ingredients1.size(); i++){
            ingredients.append("\u2023  ").append(ingredients1.get(i)).append("\n");
        }
        textViewIngredients.setText(ingredients.toString());

        ArrayList<String> instructions1 = (ArrayList<String>) getIntent().getSerializableExtra("Instructions");

        StringBuilder instructions = new StringBuilder();
        for(int i = 0 ; i < instructions1.size(); i++){
            instructions.append("\u2023  ").append(instructions1.get(i)).append("\n");
        }

        textViewInstructions.setText(instructions.toString());

    }


}