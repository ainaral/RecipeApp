package fi.thuy.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MAINACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        move(null);

        Button btnStart = findViewById(R.id.buttonGetStarted);

        btnStart.setOnClickListener((view) -> handleStartClick());

    }

    private void handleStartClick(){
        Log.d(TAG,"Get Started clicked");
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }

    public void move(View view){
        TextView tv = findViewById(R.id.textViewMain);

        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.move);
        tv.startAnimation(animation1);
    }
}