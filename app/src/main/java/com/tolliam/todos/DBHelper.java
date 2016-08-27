package com.tolliam.todos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by wwagner on 8/25/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "toDoItems.db";
    public static final String TABLE_NAME = "items";
    public static final int DATABASE_VERSION = 1;

    public static final String COLUMN_ITEM = "Item";
    public static final String COLUMN_ID = "_id";

    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + "( " + COLUMN_ID +
                                                   " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_ITEM + " TEXT NOT NULL);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(), "Upgrading database from version " + oldVersion +
                                    " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

}
