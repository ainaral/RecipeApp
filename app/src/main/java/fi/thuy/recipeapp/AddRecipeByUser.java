package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import fi.thuy.recipecontents.Recipe;
import fi.thuy.recipecontents.RecipeList;

public class AddRecipeByUser extends AppCompatActivity {

    protected static final String FILE_NAME = "recipe.txt";
    RecipeList recipes = RecipeList.getInstance();
    EditText etTitle;
    EditText etMeal;
    EditText etTime;
    EditText etServ;
    EditText etInstruction;
    EditText etIngredients;
    EditText etCalories;
    ArrayList<String> newRecipeList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipeaddbyuser);

        etTitle = findViewById(R.id.addRecipeName);
        etMeal = findViewById(R.id.addMealType);
        etTime = findViewById(R.id.addCookingTime);
        etServ = findViewById(R.id.addServing);
        etIngredients = findViewById(R.id.addIngredients);
        etInstruction = findViewById(R.id.addInstructions);
        etCalories = findViewById(R.id.addCalories);
        Button addButton = findViewById(R.id.btnAddRecipe);
        Button deleteButton = findViewById(R.id.btnDeleteRecipe);
        Button showButton = findViewById(R.id.btnShowRecipe);

        showButton.setOnClickListener(view -> readData());
        deleteButton.setOnClickListener(view -> deleteData());
        addButton.setOnClickListener(view -> saveData());

    }

    public void saveData(){
        String name = etTitle.getText().toString() + "\n";
        String meal = etMeal.getText().toString() + "\n";
        String time = etTime.getText().toString() + " min" + "\n";
        String serving = etServ.getText().toString() + " serving" + "\n";
        String calories = etCalories.getText().toString()+ " calories" + "\n";
        String ingredients = etIngredients.getText().toString() + "\n";
        String instructions = etInstruction.getText().toString()+ "\n";

        try {
            FileOutputStream fileOutputStream = openFileOutput(FILE_NAME,MODE_APPEND);

            fileOutputStream.write(name.getBytes());
            fileOutputStream.write(meal.getBytes());
            fileOutputStream.write(time.getBytes());
            fileOutputStream.write(serving.getBytes());
            fileOutputStream.write(calories.getBytes());
            fileOutputStream.write(ingredients.getBytes());
            fileOutputStream.write(instructions.getBytes());

            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        etTitle.setText("");
        etMeal.setText("");
        etTime.setText("");
        etServ.setText("");
        etCalories.setText("");
        etIngredients.setText("");
        etInstruction.setText("");

    }

    public void readData(){
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("key", "My Recipe");
        try {
            recipes.clear();
            FileInputStream fileInputStream = openFileInput(FILE_NAME);

            Scanner scan = new Scanner(fileInputStream);
            while(scan.hasNextLine()) {
                String line = scan.nextLine();

                if (!line.isEmpty())
                    newRecipeList.add(line);

            }
            for (int i = 0; i < newRecipeList.size(); i+=7) {

                    recipes.addRecipe(new Recipe(newRecipeList.get(i),newRecipeList.get(i+1),newRecipeList.get(i+2),newRecipeList.get(i+3),newRecipeList.get(i+4),newRecipeList.get(i+5),newRecipeList.get(i+6)));
            }

            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            startActivity(intent);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(){
        File file = new File(getFilesDir(), FILE_NAME);
        final boolean delete = file.delete();
    }


}