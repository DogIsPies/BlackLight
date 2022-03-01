package com.example.aquascheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;

import com.plattysoft.leonids.ParticleSystem;

public class show extends AppCompatActivity {

    private ParticleSystem follow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                follow = new ParticleSystem(this, 100, R.drawable.deszcz,1000);
                follow.setScaleRange(0.7f, 1.3f);
                follow.setSpeedRange(0.05f, 0.1f);
                follow.setRotationSpeedRange(90, 180);
                follow.setFadeOut(200, new AccelerateInterpolator());
                follow.emit((int) event.getX(), (int) event.getY(), 40);
                break;
            case MotionEvent.ACTION_MOVE:
                follow.updateEmitPoint((int)event.getX(),(int)event.getY());
                break;
            case MotionEvent.ACTION_UP:
                follow.stopEmitting();
        }
        return true;
    }
}