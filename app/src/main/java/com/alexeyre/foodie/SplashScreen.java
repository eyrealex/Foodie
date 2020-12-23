package com.alexeyre.foodie;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import androidx.appcompat.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Create animation object with listener so we can do something when it is finished
        Animation fadeInAnimationObject = new AlphaAnimation(00.1f, 1.00f); //From fully transparent to no transparency
        fadeInAnimationObject.setDuration(2000); // 2 seconds
        fadeInAnimationObject.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashScreen.this, HomeActivity.class));
                finish();
            }
        });

        //Apply animation to the app logo imageView
        findViewById(R.id.iv_splash).startAnimation(fadeInAnimationObject);

    }
}