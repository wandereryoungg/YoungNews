package com.young.youngnews.module.video;

import androidx.fragment.app.Fragment;

public class VideoFragment extends Fragment {
    private static VideoFragment instance = null;

    public static VideoFragment getInstance() {
        if (instance == null) {
            instance = new VideoFragment();
        }
        return instance;
    }

    public void onDoubleClick() {

    }
}
