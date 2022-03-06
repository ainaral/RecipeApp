package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class AddRecipeByUser extends AppCompatActivity {
    EditText etTitle;
    EditText etMeal;
    EditText etTime;
    EditText etServ;
    ArrayList<String> newRecipeList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipeaddbyuser);

        etTitle = findViewById(R.id.etRecipeName);
        etMeal = findViewById(R.id.etMealType);
        etTime = findViewById(R.id.etCookingTime);
        etServ = findViewById(R.id.etServing);
        Button addButton = findViewById(R.id.btnAddRecipe);
        addButton.setOnClickListener(view -> {
            saveInternalCache(view);
            readData();
        });

    }

    public void saveInternalCache(View view){
        String name = etTitle.getText().toString() + " ";
        String meal = etMeal.getText().toString() + " ";
        String time = etTime.getText().toString() + " ";
        String serving = etServ.getText().toString();

        File folder = getCacheDir();
        File myFile = new File(folder, "recipe.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(myFile);
            fileOutputStream.write(name.getBytes());
            fileOutputStream.write(meal.getBytes());
            fileOutputStream.write(time.getBytes());
            fileOutputStream.write(serving.getBytes());
            newRecipeList.add(name + meal + time + serving);

        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        etTitle.setText("");
        etMeal.setText("");
        etTime.setText("");
        etServ.setText("");
    }

    public void readData(){
        System.out.println(newRecipeList.size());
        System.out.println(newRecipeList);
    }
}