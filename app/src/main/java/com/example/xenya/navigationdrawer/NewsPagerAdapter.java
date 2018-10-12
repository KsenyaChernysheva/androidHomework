package com.example.xenya.navigationdrawer;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class NewsPagerAdapter extends FragmentPagerAdapter {

    private String[] names;

    public NewsPagerAdapter(FragmentManager fm, String[] names) {
        super(fm);
        this.names = names;
    }

    @Override
    public Fragment getItem(int position) {
        return NewsTabFragment.newInstance(names[position]);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return names[position];
    }
}
