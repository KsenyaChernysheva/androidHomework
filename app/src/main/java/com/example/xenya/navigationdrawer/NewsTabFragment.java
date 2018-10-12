package com.example.xenya.navigationdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NewsTabFragment extends Fragment {

    private static final String KEY_NAME = "NAME";

    public static NewsTabFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString(KEY_NAME, name);
        NewsTabFragment fragment = new NewsTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvNews = view.findViewById(R.id.tv_news);
        tvNews.setText(getArguments().getString(KEY_NAME));
    }
}
