package com.example.chengzhiyuan.models.ui.activities;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chengzhiyuan.models.R;

import java.util.Random;

public class ViewsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "PIView";
    private View mPI;
    private Button mBtn;
    private ImageView mImageview;
    private Random mRandom;
    private float startCornor = 0f;
    private float endCornor;
    private TextView mTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);

        init();
    }

    private void init() {
        mPI = findViewById(R.id.pi);
        mBtn = (Button) findViewById(R.id.btn);
        mImageview = (ImageView) findViewById(R.id.pi_cen);
        mTextview = (TextView) findViewById(R.id.tv_select);
        mBtn.setOnClickListener(this);

        mRandom = new Random();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                startAnim();
                break;
        }
    }

    private void startAnim() {
        float corner = mRandom.nextFloat() * 360 * 5;
        Log.e(TAG, "startAnim: " + corner);
        endCornor = startCornor + corner;
        ObjectAnimator animator = ObjectAnimator.ofFloat(mImageview, "rotation", startCornor, endCornor);

        animator.setDuration(1000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                startCornor = endCornor;
                float cor = (endCornor + 270) % 360;
                int current = (int) (cor / (360 / 15)) + 1;

                mTextview.setText(String.valueOf(current));
                Log.e(TAG, "onAnimationStart: " + current);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();

    }
}
