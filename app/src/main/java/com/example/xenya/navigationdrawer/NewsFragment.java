package com.example.xenya.navigationdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class NewsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager vpNews = view.findViewById(R.id.vp_news);
        TabLayout tbNews = view.findViewById(R.id.tl_news);

        String[] names = new String[]{"IT IS", "JOJO", "REFERENCE"};

        vpNews.setAdapter(new NewsPagerAdapter(getFragmentManager(), names));
        tbNews.setupWithViewPager(vpNews);
    }
}
