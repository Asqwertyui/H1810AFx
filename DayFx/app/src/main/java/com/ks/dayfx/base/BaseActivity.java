package com.ks.dayfx.base;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by F0519 on 2019/6/5.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ButterKnife.bind(this);
        initView();
        initData();
        initListener();
        initMvp();
    }

    protected void initMvp() {
    }

    protected void initView() {
    }

    protected void initListener() {
    }

    protected void initData() {
    }

    protected abstract int getLayoutID();
}
