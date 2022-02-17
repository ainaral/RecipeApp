package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    public static final String TAG = "ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnMore = findViewById(R.id.buttonMore);
        btnMore.setOnClickListener((view) -> handleStartClick());
    }

    private void handleStartClick(){
        Log.d(TAG,"button more clicked");
        Intent listActivity = new Intent(this, ListActivity.class);
        startActivity(listActivity);
    }
}