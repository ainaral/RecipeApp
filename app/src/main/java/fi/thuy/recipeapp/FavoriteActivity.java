package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class FavoriteActivity extends AppCompatActivity {

    TextView rvFavorites;

    public static final String SHARE_PREF = "sharedPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        rvFavorites = findViewById(R.id.recyclerViewFavorites);

        SharedPreferences result = getSharedPreferences("save", MODE_PRIVATE);

        String value = result.getString("view", "data not found");
        rvFavorites.setText(value);

        Intent intentBack = new Intent(this, StartActivity.class );
        ImageButton btnHome = findViewById(R.id.buttonHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentBack);
                FavoriteActivity.this.finish();
                intentBack.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            }
        });

        /*Intent intentFav = new Intent(this, FavoriteActivity.class);
        ImageButton btnFavourite = findViewById(R.id.buttonFavourite);
        btnFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentFav);
            }
        });*/


        retrievePref();
    }

/*    public void onClick(View view){
        switch(view.getId()){
            case R.id.buttonFav:
                savePreferences();
                break;
            case R.id.buttonFavourite:
                Intent intent=new Intent(this, DetailActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void savePreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PREF, MODE_PRIVATE);

        String title=rvFavorites.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("title", title);

        rvFavorites.setText(title);
        editor.apply();
    }*/

    public void retrievePref(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PREF, MODE_PRIVATE);

        String titleRecipe=sharedPreferences.getString("titleRecipe", "null");
        rvFavorites.setText(titleRecipe);

        rvFavorites.setText(titleRecipe);
    }
}