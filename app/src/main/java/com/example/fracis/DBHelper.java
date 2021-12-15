package com.example.fracis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Fracis.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table Member (mem_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "fname TEXT, mname TEXT, lname TEXT, extname TEXT, barangay TEXT, gender TEXT, dob TEXT, " +
                "pob TEXT, contact TEXT, civilstatus TEXT,spouse TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists Member");
        onCreate(DB);
    }
}
