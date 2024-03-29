package com.ks.dayfx.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ks.dayfx.R;

import butterknife.ButterKnife;

/**
 * Created by F0519 on 2019/6/5.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(), null);
        ButterKnife.bind(this, view);
        initMvp();
        initData();
        initView();
        initListener();
        return view;

    }

    protected void initMvp() {
    }

    protected void initData() {
    }

    protected void initView() {
    }

    protected void initListener() {
    }

    protected abstract int getLayoutID();
}
