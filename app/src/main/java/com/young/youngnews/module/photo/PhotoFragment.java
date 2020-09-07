package com.young.youngnews.module.photo;

import androidx.fragment.app.Fragment;

public class PhotoFragment extends Fragment {

    private static PhotoFragment instance = null;

    public static PhotoFragment getInstance() {
        if (instance == null) {
            instance = new PhotoFragment();
        }
        return instance;
    }

    public void onDoubleClick() {

    }
}
