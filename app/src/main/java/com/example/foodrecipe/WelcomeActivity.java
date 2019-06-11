package com.example.foodrecipe;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity
{
    ImageView imageView;
    AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        imageView = findViewById(R.id.logo);

        if (imageView == null) throw new AssertionError();
        imageView.setBackgroundResource(R.drawable.animation_loading);

        anim = (AnimationDrawable)imageView.getBackground();
    }

    @Override
    protected void onResume() {
        super.onResume();

        anim.start();


        checkAnimationStatus(50, anim);
    }


    /**
     * check the animation status recursively, keep the animation until it reach the last frame.
     *
     * @param time              period of animation
     * @param animationDrawable animation list
     */
    private void checkAnimationStatus(final int time, final AnimationDrawable animationDrawable) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                if (animationDrawable.getCurrent() != animationDrawable.getFrame(animationDrawable.getNumberOfFrames() - 1))
                    checkAnimationStatus(time, animationDrawable);
                else
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        }, time);
    }
}
