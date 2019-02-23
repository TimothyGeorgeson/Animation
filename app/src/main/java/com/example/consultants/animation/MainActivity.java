package com.example.consultants.animation;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvAnimate;
    private float translationX;
    private float translationY;
    private TextView tvTranslation;

    private float rotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAnimate = findViewById(R.id.tvAnimate);
        tvTranslation = findViewById(R.id.tvTranslation);
        translationX = 0f;
        translationY = 0f;
        rotation = 0f;
    }

    public void animateTextView(View view) {

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(translationY, translationY + 500f);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setDuration(2000);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                translationY = (float) animation.getAnimatedValue();
                tvAnimate.setTranslationY(translationY);
                tvTranslation.setText(String.valueOf(translationY));
            }
        });

        ValueAnimator valueAnimatorX = ValueAnimator.ofFloat(translationX, translationX + 500f);
        valueAnimatorX.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorX.setDuration(2000);

        valueAnimatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                translationX = (float) animation.getAnimatedValue();
                tvAnimate.setTranslationX(translationX);
            }
        });

        valueAnimator.start();
        valueAnimatorX.start();

        rotation += 360f;
        tvAnimate.animate().rotation(rotation).setDuration(2000).start();
    }

    public void onTextViewClick(View view) {
        Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show();
    }
}
