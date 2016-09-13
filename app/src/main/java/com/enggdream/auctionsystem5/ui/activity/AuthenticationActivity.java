package com.enggdream.auctionsystem5.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.enggdream.auctionsystem5.R;
import com.enggdream.auctionsystem5.adapter.AuthPagerAdapter;
import com.enggdream.auctionsystem5.util.PreferenceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PareshDudhat on 12-09-2016.
 */


public class AuthenticationActivity extends AppCompatActivity {
    @BindView(R.id.tab)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (PreferenceUtil.getActiveUserID(this) > 0L) {
            startActivity(new Intent(this, MainActivity.class));
            this.finish();
            return;
        }
        setContentView(R.layout.activity_authentication);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        AuthPagerAdapter adapter = new AuthPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
