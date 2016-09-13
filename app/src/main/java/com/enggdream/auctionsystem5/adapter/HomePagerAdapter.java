package com.enggdream.auctionsystem5.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.enggdream.auctionsystem5.ui.fragment.AvailableAuctionFragment;
import com.enggdream.auctionsystem5.ui.fragment.MyAuctionFragment;

/**
 * Created by PareshDudhat on 13-09-2016.
 */
public class HomePagerAdapter extends FragmentStatePagerAdapter {
    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MyAuctionFragment();
            case 1:
                return new AvailableAuctionFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "My Auction";
            case 1:
                return "Auctions";
        }
        return null;
    }
}
