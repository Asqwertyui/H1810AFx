package com.ks.dayfx.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ks.dayfx.R;
import com.ks.dayfx.adapter.RCLhotMyadapter;
import com.ks.dayfx.base.BaseMvpFragment;
import com.ks.dayfx.bean.Hot;
import com.ks.dayfx.model.Mymodel;
import com.ks.dayfx.persent.Mypersent;
import com.ks.dayfx.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Hotfragment extends BaseMvpFragment<Mymodel, MyView, Mypersent> implements MyView {
    @BindView(R.id.rv)
    RecyclerView mRv;
    Unbinder unbinder;
    private ArrayList<Hot.RecentBean> mRecentBeans;
    private RCLhotMyadapter mRCLhotMyadapter;

    @Override
    protected void initData() {
        initPresent.getHot();
    }

    @Override
    protected void initView() {
       mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecentBeans = new ArrayList<>();
        mRCLhotMyadapter = new RCLhotMyadapter(mRecentBeans, getActivity());
        mRv.setAdapter(mRCLhotMyadapter);
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    protected MyView initViewView() {
        return this;
    }

    @Override
    protected Mymodel InitMvpmodel() {
        return new Mymodel();
    }

    @Override
    protected Mypersent initMvpPersent() {
        return new Mypersent();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_hotfragment;
    }

    @Override
    public void OnSuccess(Hot hot) {
            if(hot!=null){
                List<Hot.RecentBean> recent = hot.getRecent();
                mRecentBeans.addAll(recent);
                mRCLhotMyadapter.notifyDataSetChanged();

            }
    }

    @Override
    public void OnFail(String msg) {
        Log.e("tag",msg);
    }
}
