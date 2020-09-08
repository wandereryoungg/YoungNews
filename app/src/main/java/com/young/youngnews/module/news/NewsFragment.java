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
import com.young.youngnews.Constant;
import com.young.youngnews.R;
import com.young.youngnews.bean.news.NewsChannelBean;
import com.young.youngnews.database.dao.NewsChannelDao;
import com.young.youngnews.module.news.channel.NewsChannelActivity;
import com.young.youngnews.module.wenda.article.WendaArticleView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsFragment extends Fragment {

    private LinearLayout linearLayout;
    private NewsChannelDao dao = new NewsChannelDao();
    private List<Fragment> fragmentList;
    private List<Fragment> titleList;
    private Map<String, Fragment> map = new HashMap<>();

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

        initData();

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

    private void initData() {
        initTabs();
    }

    private void initTabs() {
        List<NewsChannelBean> beans = dao.query(Constant.NEWS_CHANNEL_ENABLE);
        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();
        if (beans.size() == 0) {
            dao.initData();
            beans = dao.query(Constant.NEWS_CHANNEL_ENABLE);
        }
        for (NewsChannelBean bean : beans) {
            Fragment fragment = null;
            String channelId = bean.getChannelId();
            switch (channelId) {
                case "question_and_answer":
                    if (map.containsKey(channelId)) {
                        fragmentList.add(map.get(channelId));
                    } else {
                        fragment = WendaArticleView.newInstance();
                    }
                    break;
            }
        }
    }
}
