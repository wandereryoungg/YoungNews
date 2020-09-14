package com.young.youngnews;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.young.youngnews.module.base.BaseActivity;
import com.young.youngnews.module.media.channel.MediaChannelFragment;
import com.young.youngnews.module.news.NewsFragment;
import com.young.youngnews.module.photo.PhotoFragment;
import com.young.youngnews.module.video.VideoFragment;
import com.young.youngnews.module.wenda.article.WendaArticleView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static String TAG = "MainActivity";

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;

    private static final int FRAGMENT_NEWS = 0;
    private static final int FRAGMENT_PHOTO = 1;
    private static final int FRAGMENT_VIDEO = 2;
    private static final int FRAGMENT_MEDIA = 3;

    private int position;
    private long firstClickTime = 0;
    private long exitTime = 0;

    private NewsFragment newsFragment;
    private PhotoFragment photoFragment;
    private VideoFragment videoFragment;
    private MediaChannelFragment mediaChannelFragment;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
    }

    private void initView() {
        ActionBar actionBar = getSupportActionBar();
        toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_activity_main);
        if (actionBar == null) {
            setSupportActionBar(toolbar);
            MLog.e(TAG, "actionBar == null");
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_news:
                        showFragment(FRAGMENT_NEWS);
                        doubleClick(FRAGMENT_NEWS);
                        break;
                    case R.id.action_photo:
                        showFragment(FRAGMENT_PHOTO);
                        doubleClick(FRAGMENT_PHOTO);
                        break;
                    case R.id.action_video:
                        showFragment(FRAGMENT_VIDEO);
                        doubleClick(FRAGMENT_VIDEO);
                        break;
                    case R.id.action_media:
                        showFragment(FRAGMENT_MEDIA);
                        break;
                }
                return true;
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void showFragment(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        hideFragment(ft);
        position = index;

        switch (index) {
            case FRAGMENT_NEWS:
                toolbar.setTitle(R.string.title_news);
                if (newsFragment == null) {
                    newsFragment = NewsFragment.getInstance();
                    ft.add(R.id.container, newsFragment, newsFragment.getClass().getName());
                } else {
                    ft.show(newsFragment);
                }
                break;
            case FRAGMENT_PHOTO:
                toolbar.setTitle(R.string.title_photo);
                if (photoFragment == null) {
                    photoFragment = PhotoFragment.getInstance();
                    ft.add(R.id.container, photoFragment, photoFragment.getClass().getName());
                } else {
                    ft.show(photoFragment);
                }
                break;
            case FRAGMENT_VIDEO:
                toolbar.setTitle(R.string.title_video);
                if (videoFragment == null) {
                    videoFragment = VideoFragment.getInstance();
                    ft.add(R.id.container, videoFragment, videoFragment.getClass().getName());
                } else {
                    ft.show(videoFragment);
                }
                break;
            case FRAGMENT_MEDIA:
                toolbar.setTitle(R.string.title_media);
                if (mediaChannelFragment == null) {
                    mediaChannelFragment = MediaChannelFragment.getInstance();
                    ft.add(R.id.container, mediaChannelFragment, mediaChannelFragment.getClass().getName());
                } else {
                    ft.show(mediaChannelFragment);
                }
                break;
        }
        ft.commit();
    }

    private void doubleClick(int index) {
        long secondClickTime = System.currentTimeMillis();
        if ((secondClickTime - firstClickTime) < 500) {
            switch (index) {
                case FRAGMENT_NEWS:
                    newsFragment.onDoubleClick();
                    break;
                case FRAGMENT_PHOTO:
                    photoFragment.onDoubleClick();
                    break;
                case FRAGMENT_VIDEO:
                    videoFragment.onDoubleClick();
                    break;
            }
        } else {
            firstClickTime = secondClickTime;
        }

    }

    private void hideFragment(FragmentTransaction ft) {
        if (newsFragment != null) {
            ft.hide(newsFragment);
        }
        if (photoFragment != null) {
            ft.hide(photoFragment);
        }
        if (videoFragment != null) {
            ft.hide(videoFragment);
        }
        if (mediaChannelFragment != null) {
            ft.hide(mediaChannelFragment);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_switch_night_mode:

                break;
            case R.id.nav_setting:

                break;
            case R.id.nav_share:

                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - exitTime < 2000) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, R.string.double_click_exit, Toast.LENGTH_LONG).show();
            exitTime = currentTime;
        }
    }
}