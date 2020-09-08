package com.young.youngnews.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.young.youngnews.Constant;
import com.young.youngnews.InitApp;
import com.young.youngnews.R;
import com.young.youngnews.bean.news.NewsChannelBean;
import com.young.youngnews.database.DatabaseHelper;
import com.young.youngnews.database.table.NewsChannelTable;

import java.util.ArrayList;
import java.util.List;

public class NewsChannelDao {

    private SQLiteDatabase db;

    public NewsChannelDao() {
        db = DatabaseHelper.getDatabase();
    }

    public void initData() {
        String[] categoryId = InitApp.appContext.getResources().getStringArray(R.array.mobile_news_id);
        String[] categoryName = InitApp.appContext.getResources().getStringArray(R.array.mobile_news_name);
        //TODO 不一样
        for (int i = 0; i < categoryId.length; i++) {
            add(categoryId[i], categoryName[i], Constant.NEWS_CHANNEL_ENABLE, i);
        }
    }

    public boolean add(String channelId, String channelName, int enable, int position) {
        ContentValues values = new ContentValues();
        values.put(NewsChannelTable.ID, channelId);
        values.put(NewsChannelTable.NAME, channelName);
        values.put(NewsChannelTable.IS_ENABLE, enable);
        values.put(NewsChannelTable.POSITION, position);
        long result = db.insert(NewsChannelTable.TABLE_NAME, null, values);
        return result != -1;
    }

    public List<NewsChannelBean> query(int isEnable) {
        Cursor cursor = db.query(NewsChannelTable.TABLE_NAME, null, NewsChannelTable.IS_ENABLE + "=?",
                new String[]{isEnable + ""}, null, null, null);
        List<NewsChannelBean> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            NewsChannelBean bean = new NewsChannelBean();
            bean.setChannelId(cursor.getString(NewsChannelTable.ID_ID));
            bean.setChannelName(cursor.getString(NewsChannelTable.ID_NAME));
            bean.setIsEnable(cursor.getInt(NewsChannelTable.ID_IS_ENABLE));
            bean.setPosition(cursor.getInt(NewsChannelTable.ID_POSITION));
            list.add(bean);
        }
        cursor.close();
        return list;
    }


}
