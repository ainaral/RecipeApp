package fi.thuy.recipeapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import fi.thuy.recipecontents.Recipe;
import fi.thuy.recipecontents.RecipeList;
import fi.thuy.recipecontents.RecipeListAdapter;
import fi.thuy.recipecontents.RecipeListAdapterStart;

public class StartActivity extends AppCompatActivity implements RecipeListAdapterStart.OnCardListener {
    RecyclerView recyclerView1;
    RecipeList recipes = RecipeList.getInstance();
    RecipeListAdapterStart recipeListAdapterStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnBreakfast = findViewById(R.id.buttonBreakfast);
        Button btnLunch = findViewById(R.id.buttonLunch);
        Button btnDinner = findViewById(R.id.buttonDinner);
        Button btnMore = findViewById(R.id.buttonMore);

        MyClick myClick = new MyClick();

        btnBreakfast.setOnClickListener(myClick);
        btnLunch.setOnClickListener(myClick);
        btnDinner.setOnClickListener(myClick);
        btnMore.setOnClickListener(myClick);

        recyclerView1 = findViewById(R.id.recyclerViewStart);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager);

        recipeListAdapterStart = new RecipeListAdapterStart(StartActivity.this, recipes.getListOfRecipes(),this);
        recyclerView1.setAdapter(recipeListAdapterStart);

        updateUI(null);

    }

    @Nullable
    private String fetchJsonData() {
        recipeListAdapterStart.notifyDataSetChanged();
        recipes.clear();
        recyclerView1.getRecycledViewPool().clear();

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


    @Override
    public void onCardClick(int position) {

    }

    private class MyClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            updateUI(view);
        }
    }

    private void updateUI(View view){
        String uri = "@drawable/";
        Intent intent = new Intent(this, ThirdActivity.class);

        try {
            JSONObject jsonObject = new JSONObject((fetchJsonData()));
            JSONArray jsonArray = jsonObject.getJSONArray("recipesList");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject listOfRecipe = jsonArray.getJSONObject(i);
                String recipeTitle = listOfRecipe.getString("title");
                int id = listOfRecipe.getInt("id");
                String mealType = listOfRecipe.getString("mealtype");
                String instructions = listOfRecipe.getString("instructions");
                String ingredients = listOfRecipe.getString("ingredients");
                String tags = listOfRecipe.getString("tags");
                String serving = listOfRecipe.getString("serving");
                String time = listOfRecipe.getString("time");
                String calories = listOfRecipe.getString("energy");

                int imageResource = getResources().getIdentifier(uri + "a" + listOfRecipe.getString("id"), null, getPackageName());
                if(null == view){
                    recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories));

                }else if(view.getId() == R.id.buttonBreakfast){
                    if(mealType.equals("Breakfast")){
                        recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories));
                        intent.putExtra("key", "Breakfast");
                    }

                }else if(view.getId() == R.id.buttonLunch){
                    if(mealType.equals("Lunch")){
                        recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories));
                        intent.putExtra("key", "Lunch");
                    }

                }else if(view.getId() == R.id.buttonDinner){
                    if(mealType.equals("Dinner")){
                        recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories));
                        intent.putExtra("key", "Dinner");
                    }

                }else if(view.getId() == R.id.buttonMore){
                    recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories));
                    intent.putExtra("key", "More");

                 }else{
                     recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories));
                 }

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        if(view == null){

        }else{
            startActivity(intent);
        }



    }
}