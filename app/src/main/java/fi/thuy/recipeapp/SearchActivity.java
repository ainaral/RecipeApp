package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private ArrayList<fi.thuy.recipecontents.Recipe> searchList;

    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // create recipe list
        searchList = new ArrayList<>();
        searchList.add(new fi.thuy.recipecontents.Recipe(1, "Chicken Piccata", "Dinner", "In a shallow bowl, mix flour, salt and pepper", "cup all-purpose flour", "flour", R.drawable.avocadoegg));
        searchList.add(new fi.thuy.recipecontents.Recipe(2, "Li’l Cheddar Meat Loaves", "Dinner", "In a large bowl, whisk egg and milk", "1 large egg", "egg", R.drawable.chickenpiccata));
        searchList.add(new fi.thuy.recipecontents.Recipe(3, "Baked Shrimp Scampi", "Dinner", "Preheat the oven to 425 degrees F", "2/3 cup panko", "flour", R.drawable.pasta));
        searchList.add(new fi.thuy.recipecontents.Recipe(4, "Tomato Basil Soup", "Dinner", "Simmer 30 min", "2/3 cup panko", "soup", R.drawable.pasta));
        searchList.add(new fi.thuy.recipecontents.Recipe(5, "Crock Pot Roast", "Dinner", "Place beef roast in crock pot", "beef roast", "beef", R.drawable.saagpaner));
        searchList.add(new fi.thuy.recipecontents.Recipe(6, "Roasted Asparagus", "Dinner", "Preheat oven to 425°F", "asparagus", "asparagus", R.drawable.pasta));
        searchList.add(new fi.thuy.recipecontents.Recipe(7, "Curried Lentils and Rice", "Lunch", "Bring broth to a low boil", "beef broth", "beef", R.drawable.chickenpiccata));
        searchList.add(new fi.thuy.recipecontents.Recipe(8, "Blueberry Oatmeal Squares", "Breakfast", "Filling: In saucepan, bring blueberries", "rolled oats", "oats", R.drawable.avocadoegg));

        //create recycler view
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        searchAdapter = new SearchAdapter(searchList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(searchAdapter);


        EditText editText = findViewById(R.id.editTextTextRecipe);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                search(editable.toString());

            }
        });

    }

    private void search(String text) {
        ArrayList<fi.thuy.recipecontents.Recipe> searchList = new ArrayList<>();

        for (fi.thuy.recipecontents.Recipe item : this.searchList) {
            if (item.getRecipeName().toLowerCase().contains(text.toLowerCase())) {
                searchList.add(item);
            }
        }

        searchAdapter.filterList(searchList);
    }





}