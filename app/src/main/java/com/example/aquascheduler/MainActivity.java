package com.example.aquascheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

import com.plattysoft.leonids.ParticleSystem;

public class MainActivity extends AppCompatActivity {

    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.go);



    }


    public void goDraw(View arg0) {
        Intent intent = new Intent(this, show.class);
        startActivity(intent);

    }

    public void letItGo(View view) {
        new ParticleSystem(this,200,R.drawable.deszcz,5000)
                .setSpeedByComponentsRange(0f, 0f, 0.05f, 0.1f)
                .setAcceleration(0.000005f,0)
                .setFadeOut(1000, new AccelerateInterpolator())
                .emitWithGravity(findViewById(R.id.drop), Gravity.BOTTOM,10);
    }
}