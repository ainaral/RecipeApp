package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import fi.thuy.recipecontents.Recipe;
import fi.thuy.recipecontents.RecipeList;
import fi.thuy.recipecontents.RecipeListAdapter;

public class ThirdActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecipeList recipes = RecipeList.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Field[] drawables = R.drawable.class.getDeclaredFields();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        Intent intent = getIntent();
        String message = intent.getStringExtra( "key");

        recyclerView = findViewById(R.id .recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            JSONObject jsonObject = new JSONObject((fetchJsonData()));
            JSONArray jsonArray = jsonObject.getJSONArray("recipesList");

            for(int i = 0; i < jsonArray.length(); i++) {

                Log.d("Message", message);
                JSONObject listOfRecipe = jsonArray.getJSONObject(i);
                String recipeTitle = listOfRecipe.getString("title");
                String mealType = listOfRecipe.getString("mealtype");
                String instructions = listOfRecipe.getString("instructions");
                String ingredients = listOfRecipe.getString("ingredients");
                String tags = listOfRecipe.getString("tags");
                int image = R.drawable.chickenpiccata;
                if (message.equals(mealType)) {
                    recipes.addRecipe(new Recipe(i, recipeTitle, mealType, instructions, ingredients, tags, image));

                }
            }
            Log.d("Key", message);

            }catch (Exception e){
                e.printStackTrace();
        }


        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(ThirdActivity.this, recipes.getListOfRecipes());
        recyclerView.setAdapter(recipeListAdapter);

    }



    private String fetchJsonData() {
        recipes.clear();
        String json;
        try {
            InputStream inputStream = getAssets().open("recipeList.json");
            int sizeOfFile = inputStream.available();
            byte[] bufferData = new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json = new String(bufferData,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
        return json;
    }
}