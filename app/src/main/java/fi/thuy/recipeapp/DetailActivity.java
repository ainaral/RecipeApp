package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        Bundle bundle = getIntent().getExtras();
        TextView textViewTitle = findViewById(R.id.tv_recipe_name);
        textViewTitle.setText(intent.getStringExtra("Title"));

        ImageView imageView = findViewById(R.id.imageViewRecipe);
        int resId = bundle.getInt("Image");
        imageView.setImageResource(resId);

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