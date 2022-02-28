package fi.thuy.recipeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MAINACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.buttonGetStarted);

        btnStart.setOnClickListener((view) -> handleStartClick());

    }

    private void handleStartClick(){
        Log.d(TAG,"Get Started clicked");
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}