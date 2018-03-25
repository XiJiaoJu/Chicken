package com.example.chengzhiyuan.models;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.chengzhiyuan.models.ui.activities.ViewsActivity;
import com.example.chengzhiyuan.models.ui.base.ToolbarActivity;

import butterknife.OnClick;

public class MainActivity extends ToolbarActivity implements View.OnClickListener {

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.text1)
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
