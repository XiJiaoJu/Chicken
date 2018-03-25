package com.example.chengzhiyuan.models.ui.activities;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chengzhiyuan.models.R;
import com.example.chengzhiyuan.models.ui.base.ToolbarActivity;
import com.example.chengzhiyuan.models.ui.widgets.PIView;

import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class ViewsActivity extends ToolbarActivity implements View.OnClickListener {

    private static final String TAG = "PIView";
    @BindView(R.id.pi)
    PIView mPI;
    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.pi_cen)
    ImageView mImageview;
    @BindView(R.id.tv_select)
    TextView mTextview;
    Random mRandom;
    private float startCornor = 0f;
    private float endCornor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_views;
    }

    private void init() {
        mRandom = new Random();
    }

    @OnClick(R.id.btn)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                startAnim();
                break;
        }
    }

    @Override
    public boolean canBack() {
        return true;
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
