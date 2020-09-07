package com.young.youngnews.module.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.young.youngnews.R;
import com.young.youngnews.module.news.channel.NewsChannelActivity;

public class NewsFragment extends Fragment {

    private LinearLayout linearLayout;

    private static NewsFragment instance = null;

    public static NewsFragment getInstance() {
        if (instance == null) {
            instance = new NewsFragment();
        }
        return instance;
    }

    public void onDoubleClick() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_tab, container, false);


        initView(view);

        return view;
    }

    private void initView(View view) {
        TabLayout tabLayout = view.findViewById(R.id.tab_layout_news);
        ViewPager viewPager = view.findViewById(R.id.view_pager_news);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        ImageView ivAddChannel = view.findViewById(R.id.iv_add_channel);
        ivAddChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewsChannelActivity.class);
                startActivity(intent);
            }
        });

        linearLayout = view.findViewById(R.id.header_layout);
        //TODO
    }
}
