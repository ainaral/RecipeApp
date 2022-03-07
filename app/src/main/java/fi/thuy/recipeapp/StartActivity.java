package fi.thuy.recipeapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import fi.thuy.recipecontents.Recipe;
import fi.thuy.recipecontents.RecipeList;
import fi.thuy.recipecontents.RecipeListAdapterStartView;

public class StartActivity extends AppCompatActivity implements RecipeListAdapterStartView.OnCardListener {
    RecyclerView recyclerView;
    SearchView searchView;
    RecipeList recipes = RecipeList.getInstance();
    RecipeListAdapterStartView recipeListAdapterStart;
    ArrayList<Recipe> listOfRecipe = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnBreakfast = findViewById(R.id.buttonBreakfast);
        Button btnLunch = findViewById(R.id.buttonLunch);
        Button btnDinner = findViewById(R.id.buttonDinner);
        Button btnItalian = findViewById(R.id.buttonItalian);
        Button btnIndian = findViewById(R.id.buttonIndian);
        Button btnThai = findViewById(R.id.buttonThai);
        Button btnChinese = findViewById(R.id.buttonChinese);
        Button btnSoup = findViewById(R.id.buttonSoup);
        Button btnSalad = findViewById(R.id.buttonSalad);
        Button btnMore = findViewById(R.id.buttonMore);
        FloatingActionButton btnAdd = findViewById(R.id.add_button);
        ImageButton btnProfile = findViewById(R.id.buttonProfile);
        searchView = findViewById(R.id.searchViewStart);

        MyClick myClick = new MyClick();

        btnBreakfast.setOnClickListener(myClick);
        btnLunch.setOnClickListener(myClick);
        btnDinner.setOnClickListener(myClick);
        btnMore.setOnClickListener(myClick);
        btnItalian.setOnClickListener(myClick);
        btnIndian.setOnClickListener(myClick);
        btnThai.setOnClickListener(myClick);
        btnChinese.setOnClickListener(myClick);
        btnSoup.setOnClickListener(myClick);
        btnSalad.setOnClickListener(myClick);

        Intent intentAddRecipe  = new Intent(this, AddRecipeByUser.class);
        btnAdd.setOnClickListener(view -> startActivity(intentAddRecipe));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Intent intentSearch = new Intent(StartActivity.this, ListActivity.class);
                intentSearch.putExtra("keySearch" , s);
                startActivity(intentSearch);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return true;
            }

        });

        // get the reference of RecyclerView
        recyclerView = findViewById(R.id.recyclerViewStart);

        LinearLayoutManager linearLayoutManagerStart = new LinearLayoutManager(this);

        // set a LinearLayoutManager with horizontal orientation
        linearLayoutManagerStart.setOrientation(LinearLayoutManager.HORIZONTAL);

        //fill the recyclerView with horizontal linearLayoutManager
        recyclerView.setLayoutManager(linearLayoutManagerStart);

        //  call the constructor of RecipeListAdapterStart to send the reference and data to Adapter
        recipeListAdapterStart = new RecipeListAdapterStartView(StartActivity.this,listOfRecipe, this);

        //set the adapter to recycler view
        recyclerView.setAdapter(recipeListAdapterStart);

        updateUI(null);

    }

    //fetch data from Assets folder
    @Nullable
    private String fetchJsonData() {
        recipes.clear();
        String json;
        try {
            InputStream inputStream = getAssets().open("recipeList.json");
            int sizeOfFile = inputStream.available();
            byte[] bufferData = new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json = new String(bufferData, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
        return json;
    }

    //opens a new activity on each card click
    @Override
    public void onCardClick(int position) {
        ArrayList<String> ingredient = new ArrayList<>();
        ArrayList<String> instruction = new ArrayList<>();
        Recipe recipe = listOfRecipe.get(position);
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

    private class MyClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            updateUI(view);
        }
    }

    //update UI based on the user selection
    private void updateUI(View view){
        String uri = "@drawable/";
        Intent intent = new Intent(this, ListActivity.class);

        try {
            JSONObject jsonObject = new JSONObject((Objects.requireNonNull(fetchJsonData())));
            JSONArray jsonArray = jsonObject.getJSONArray("recipesList");

            //fetch the recipe from json file and stores it in a arraylist
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
                String category = listOfRecipe.getString("category");

                int imageResource = getResources().getIdentifier(uri + "a" + listOfRecipe.getString("id"), null, getPackageName());

                if(null == view){
                    recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories, category));
                    intent.putExtra("key", "More Recipe");


                }else if(view.getId() == R.id.buttonBreakfast){
                    if(mealType.equals("Breakfast")){
                        recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories , category));
                        intent.putExtra("key", "Breakfast");
                    }

                }else if(view.getId() == R.id.buttonLunch){
                    if(mealType.equals("Lunch")){
                        recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories,category));
                        intent.putExtra("key", "Lunch");
                    }

                }else if(view.getId() == R.id.buttonDinner){
                    if(mealType.equals("Dinner")){
                        recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories,category));
                        intent.putExtra("key", "Dinner");
                    }

                }else if(view.getId() == R.id.buttonChinese){
                    if(category.equals("Chinese")){
                        recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories,category));
                        intent.putExtra("key", "Chinese");
                    }

                }else if(view.getId() == R.id.buttonSalad){
                    if(category.equals("Salad")){
                        recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories,category));
                        intent.putExtra("key", "Salad");
                    }

                }else if(view.getId() == R.id.buttonThai){
                    if(category.equals("Thai")){
                        recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories,category));
                        intent.putExtra("key", "Thai");
                    }

                }else if(view.getId() == R.id.buttonItalian){
                    if(category.equals("Italian")){
                        recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories,category));
                        intent.putExtra("key", "Italian");
                    }

                }else if(view.getId() == R.id.buttonSoup){
                    if(category.equals("Soup")){
                        recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories,category));
                        intent.putExtra("key", "Soup");
                    }

                }else if(view.getId() == R.id.buttonIndian){
                    if(category.equals("Indian")){
                        recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories,category));
                        intent.putExtra("key", "Italian");
                    }

                }else if(view.getId() == R.id.buttonMore){
                    recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories, category));
                    intent.putExtra("key", "More Recipe");

                }else if(view.getId() == R.id.searchViewStart){
                    recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories, category));
                    intent.putExtra("key", "More Recipe");

                }else{
                    recipes.addRecipe(new Recipe(id, recipeTitle, mealType, instructions, ingredients, tags, imageResource, serving, time, calories,category));
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        //update the main page(startActivity) with random recipe if view is null
        if(view == null) {
            Random random = new Random();

            for (int i = 0; i < recipes.getListOfRecipes().size() / 2; i++) {
                int randomNum = random.nextInt(recipes.getListOfRecipes().size() / 2);
                Recipe recipe = recipes.getListOfRecipes().get(randomNum);

                //Stores the random recipe in a temporary arraylist
                if (!(listOfRecipe.contains(recipe))) {
                    listOfRecipe.add(recipe);
                }
            }
            //start next activity if  button is clicked (if view is not null)
        }else{
            startActivity(intent);
        }

    }
}