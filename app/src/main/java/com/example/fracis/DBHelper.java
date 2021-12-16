package com.example.fracis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public boolean insertuserdata(String fname, String mname, String lname, String extname, String barangay, String gender, String dob, String pob, String contact, String civilstatus, String spouse) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fname",fname);
        contentValues.put("mname",mname);
        contentValues.put("lname",lname);
        contentValues.put("extname",extname);
        contentValues.put("barangay",barangay);
        contentValues.put("gender",gender);
        contentValues.put("dob",dob);
        contentValues.put("pob",pob);
        contentValues.put("contact",contact);
        contentValues.put("civilstatus",civilstatus);
        contentValues.put("spouse",spouse);
                long result= DB.insert("member", null, contentValues);
        if (result==-1){
            return false;
        }else{
            return true;

        }
    }

    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from member", null);
        return cursor;
    }

}
