package com.enggdream.auctionsystem5.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enggdream.auctionsystem5.R;
import com.enggdream.auctionsystem5.adapter.HomePagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PareshDudhat on 13-09-2016.
 */
public class HomeFragment extends Fragment {
    @BindView(R.id.tab)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        HomePagerAdapter adapter = new HomePagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
