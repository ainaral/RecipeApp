package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    public static final String TAG = "ACTIVITY";

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

        btnMore.setOnClickListener((view) -> handleStartClick());
    }

    private void handleStartClick(){
        Log.d(TAG,"button more clicked");
        Intent listActivity = new Intent(this, ListActivity.class);
        startActivity(listActivity);
    }


    private class MyClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            updateUI(view);
        }
    }

    private void updateUI(View view){

    }
}