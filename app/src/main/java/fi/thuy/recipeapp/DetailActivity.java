package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        intent = getIntent();

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
        String ingredients = "";
        for(int i = 0 ; i < ingredients1.size(); i++){
            ingredients += "\u2023  " + ingredients1.get(i) + "\n";
            System.out.println(ingredients);
        }
        textViewIngredients.setText(ingredients);

        ArrayList<String> instructions1 = (ArrayList<String>) getIntent().getSerializableExtra("Instructions");

        String instructions = "";
        for(int i = 0 ; i < instructions1.size(); i++){
            instructions += "\u2023  " + instructions1.get(i) + "\n";
            System.out.println(instructions);
        }

        textViewInstructions.setText(instructions);

    }


}