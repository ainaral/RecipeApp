package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    public static final String RECIPE_ID = "recipeID";
    private static final String TAG = "ListView MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = findViewById(R.id.lvRecipes);
        listView.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Recipes.getInstance().getRecipeList())
        );
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Log.d(TAG, " item clicked" + i);
            startListActivity(i);
        });

    }

    private void startListActivity(int i){
        Intent recipeActivity = new Intent(ListActivity.this, RecipeActivity.class);
        recipeActivity.putExtra(RECIPE_ID, i);
        startActivity(recipeActivity);
    }
}