package com.example.chengzhiyuan.models;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.chengzhiyuan.models.ui.activities.ViewsActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.text1).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text1:
                jumpToActivity(this, ViewsActivity.class);
                break;
        }
    }

    private void jumpToActivity(Context context, Class classA) {
        context.startActivity(new Intent(context, classA));
    }
}
