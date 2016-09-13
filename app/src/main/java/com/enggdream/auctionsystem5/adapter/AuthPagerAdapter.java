package com.enggdream.auctionsystem5.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.enggdream.auctionsystem5.ui.fragment.LoginFragment;
import com.enggdream.auctionsystem5.ui.fragment.RegistrationFragment;

/**
 * Created by PareshDudhat on 12-09-2016.
 */
public class AuthPagerAdapter extends FragmentStatePagerAdapter {
    public AuthPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LoginFragment();
            case 1:
                return new RegistrationFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Login";
            case 1:
                return "Registration";
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
