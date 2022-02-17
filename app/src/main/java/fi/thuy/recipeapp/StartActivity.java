package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnBreakfast = findViewById(R.id.buttonBreakfast);
        Button btnLunch = findViewById(R.id.buttonLunch);
        Button btnDinner = findViewById(R.id.buttonDinner);

        MyClick myClick = new MyClick();

        btnBreakfast.setOnClickListener(myClick);
        btnLunch.setOnClickListener(myClick);
        btnDinner.setOnClickListener(myClick);
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