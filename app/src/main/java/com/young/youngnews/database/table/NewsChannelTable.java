package com.young.youngnews.database.table;

public class NewsChannelTable {

    public static final String TABLE_NAME = "NewsChannelTable";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String IS_ENABLE = "isEnable";
    public static final String POSITION = "position";

    public static final int ID_ID = 0;
    public static final int ID_NAME = 1;
    public static final int ID_IS_ENABLE = 2;
    public static final int ID_POSITION = 3;

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
            ID + " text primary key, " +
            NAME + " text, " +
            IS_ENABLE + " text default '1', " +
            POSITION + " text)";

}
