package com.young.youngnews.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

import com.young.youngnews.InitApp;
import com.young.youngnews.R;

public class SettingUtil {

    private static final SettingUtil instance = new SettingUtil();
    private SharedPreferences setting = InitApp.appContext.getSharedPreferences("setting", Context.MODE_PRIVATE);

    public static SettingUtil getInstance() {
        return instance;
    }

    public int getColor() {
        int defaultColor = InitApp.appContext.getResources().getColor(R.color.colorPrimary);
        int color = setting.getInt("color", defaultColor);
        if (color != 0 && Color.alpha(color) != 255) {
            return defaultColor;
        }
        return color;
    }


}
