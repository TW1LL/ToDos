package com.tolliam.todos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wwagner on 8/25/2016.
 */
public class ItemsDataSource {

    // Database fields
    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private String[] allColumns = {DBHelper.COLUMN_ID, DBHelper.COLUMN_ITEM};

    public ItemsDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Item create(String item) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_ITEM, item);
        long insertId = database.insert(DBHelper.TABLE_NAME, null, values);
        Cursor cursor = database.query(DBHelper.TABLE_NAME, allColumns, DBHelper.COLUMN_ID + " = " +
                                       insertId, null, null, null, null);
        cursor.moveToFirst();
        Item newItem = cursorToItem(cursor);
        cursor.close();
        return newItem;
    }

    public void delete(Item item) {
        long id = item.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(DBHelper.TABLE_NAME, DBHelper.COLUMN_ID + " = " + id, null);
    }

    public List<Item> getAll() {
        List<Item> items = new ArrayList<Item>();

        Cursor cursor = database.query(DBHelper.TABLE_NAME, allColumns, null, null, null,
                                                                        null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Item item = cursorToItem(cursor);
            items.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        return items;
    }

    private Item cursorToItem(Cursor cursor) {
        Item item = new Item();
        item.setId(cursor.getLong(0));
        item.setItem(cursor.getString(1));
        return item;
    }
}
