package com.young.youngnews.module.media.channel;

import androidx.fragment.app.Fragment;

import com.young.youngnews.module.video.VideoFragment;

public class MediaChannelFragment extends Fragment {

    private static MediaChannelFragment instance = null;

    public static MediaChannelFragment getInstance() {
        if (instance == null) {
            instance = new MediaChannelFragment();
        }
        return instance;
    }

    public void onDoubleClick() {

    }
}
