package fi.thuy.recipeapp;

import fi.thuy.recipecontents.Recipe;
import fi.thuy.recipecontents.RecipeList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    public static String SHARE_PREF = "sharedPref";
    private static final String KEY_NAME = "name";
    private String title;

    private Intent intent;

    public TextView textViewTitle;
    public ImageButton favButton, favouriteButton;
    public SharedPreferences sharedPreferences;

    private RecipeList recipes = RecipeList.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        intent = getIntent();

        favButton = (ImageButton) findViewById(R.id.buttonFav);
        favouriteButton = (ImageButton) findViewById(R.id.buttonFavourite);

        /*favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, textViewTitle.getText().toString());
                editor.apply();

                Toast.makeText(getApplicationContext(),"added to favorite list", Toast.LENGTH_LONG).show();
            }
        });

        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences(SHARE_PREF, MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                Intent intent = new Intent(DetailActivity.this, FavoriteActivity.class);
                startActivity(intent);
                editor.apply();
            }
        });*/
        sharedPreferences = getSharedPreferences(SHARE_PREF, MODE_PRIVATE);

        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, textViewTitle.getText().toString());
                editor.apply();
                //savePreferences();
                Toast.makeText(getApplicationContext(),"added to favorite list", Toast.LENGTH_LONG).show();
            }
        });

        /*title = sharedPreferences.getString(KEY_NAME, title);
        if ( title != null){
            Intent intent = new Intent(DetailActivity.this, FavoriteActivity.class);
            startActivity(intent);
        }*/

        /*favouriteButton.setOnClickListener(view -> {
            FavoriteActivity();
            retrievePref();
        });*/

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

    /*public void onClick(View view){
        switch(view.getId()){
            case R.id.buttonFav:
                Toast.makeText(getApplicationContext(),"added to favorite list", Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonFavourite:
                Intent intent=new Intent(this, FavoriteActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void savePreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences
                (SHARE_PREF, MODE_PRIVATE);
        String title=textViewTitle.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("title", title);
        textViewTitle.setText(title);
        editor.commit();
    }

    private void retrievePref(){
        SharedPreferences sharedPreferences = getSharedPreferences
                (SHARE_PREF, MODE_PRIVATE);

        String titleRecipe=sharedPreferences.getString("titleRecipe", "null");
        textViewTitle.setText(titleRecipe);
    }*/
}