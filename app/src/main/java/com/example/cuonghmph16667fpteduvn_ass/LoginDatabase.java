package com.example.cuonghmph16667fpteduvn_ass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LoginDatabase extends SQLiteOpenHelper {
    public LoginDatabase( Context context) {
        super(context, "login.db", null, 1);
    }
    public static final String TABLE_NAME = "DULIEUNGUOIDUNG";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE = String.format("CREATE TABLE %s(%s VARCHAR,%s VARCHAR)",TABLE_NAME,USERNAME,PASSWORD);
        db.execSQL(CREATE);
    }

    public long insertData(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME,username);
        values.put(PASSWORD,password);
        long result = db.insert(TABLE_NAME,null,values);
        return result;
    }

    public boolean kiemTra(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
          Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+USERNAME+" = ? AND "+PASSWORD+" = ?",new String[]{username,password});
          if(cursor.getCount()>0){
              return true;
          }else {
              return false;
          }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
