package com.example.mylibrary.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by kiplening on 30/11/2016.
 */

public class DataBaseUtils {
    private SQLiteDatabase db;
    private String databaseName;
    private String tableName;

    public DataBaseUtils(String databaseName, String tableName, Context context){
        this.databaseName = databaseName;
        this.tableName = tableName;
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context, databaseName,null,1);
        db = dataBaseHelper.getWritableDatabase();
    }

    public String get(String name, String tableName){
        String result;
        Cursor mCursor = db.rawQuery("select * from " + tableName,null);
        if (mCursor.moveToFirst()){
            if (mCursor.getString(mCursor.getColumnIndex(name)) != null){
                result = mCursor.getString(mCursor.getColumnIndex(name));
                return result;
            }else {
                return null;
            }
        }
        else
            return null;
    }
}
