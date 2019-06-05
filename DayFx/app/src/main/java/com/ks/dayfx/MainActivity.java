package com.ks.dayfx;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ks.dayfx.base.BaseActivity;
import com.ks.dayfx.fragment.Hotfragment;
import com.ks.dayfx.fragment.NewFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tl)
    Toolbar mTl;
    @BindView(R.id.fm)
    FrameLayout mFm;
    @BindView(R.id.tb)
    TabLayout mTb;
    @BindView(R.id.dl)
    DrawerLayout mDl;
    @BindView(R.id.tv)
    TextView mTv;
    private ActionBarDrawerToggle mToggle;
    private ArrayList<Fragment> mFragments;
    private FragmentManager mManager;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void initView() {
        setSupportActionBar(mTl);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDl, mTl, R.string.app_name, R.string.app_name);
        mDl.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        mFragments = new ArrayList<>();
        mFragments.add(new Hotfragment());
        mFragments.add(new NewFragment());
        mTb.addTab(mTb.newTab().setText("热门"));
        mTb.addTab(mTb.newTab().setText("新闻"));
        mManager = getSupportFragmentManager();
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.replace(R.id.fm, mFragments.get(0));
        transaction.commit();
        mTb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                if (position == 0) {
                    mTv.setText("热门");
                    getSupportFragmentManager().beginTransaction().replace(R.id.fm, mFragments.get(position)).commit();

                } else {
                    mTv.setText("新闻");
                    getSupportFragmentManager().beginTransaction().replace(R.id.fm, mFragments.get(position)).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

}
