package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;


public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnBreakfast = findViewById(R.id.buttonBreakfast);
        Button btnLunch = findViewById(R.id.buttonLunch);
        Button btnDinner = findViewById(R.id.buttonDinner);
        Button btnMore = findViewById(R.id.buttonMore);
        Button btnSearch = findViewById(R.id.buttonSearch);

        MyClick myClick = new MyClick();

        btnBreakfast.setOnClickListener(myClick);
        btnLunch.setOnClickListener(myClick);
        btnDinner.setOnClickListener(myClick);
        btnMore.setOnClickListener(myClick);
        btnSearch.setOnClickListener(myClick);
    }


    private class MyClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            updateUI(view);
        }
    }

    private void updateUI(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        Intent searchIntent = new Intent(this, SearchActivity.class);
        Intent moreIntent = new Intent(this, ThirdActivity.class);

        if(view.getId() == R.id.buttonBreakfast){
            intent.putExtra("key", "Breakfast" );
            startActivity(intent);

        }else if(view.getId() == R.id.buttonLunch){
            intent.putExtra("key", "Lunch");
            startActivity(intent);

        }else if(view.getId() == R.id.buttonDinner){
            intent.putExtra("key","Dinner");
            startActivity(intent);

        }else if (view.getId() == R.id.buttonSearch){
            intent.putExtra("key","Search");
            startActivity(searchIntent);
        }else {
            intent.putExtra("key","More");
            startActivity(moreIntent);
        }

    }



    }
