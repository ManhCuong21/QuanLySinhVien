package com.example.cuonghmph16667fpteduvn_ass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class KhoanThuDAO extends SQLiteOpenHelper {
    public KhoanThuDAO(@Nullable Context context) {
        super(context, "khoanthu.db", null, 1);
    }

    public static final String LOAITHU = "LOAITHU";
    public static final String IDLOAITHU = "IDLOAITHU";
    public static final String TENLOAITHU = "TENLOAITHU";

    public static final String KHOANTHU = "KHOANTHU";
    public static final String IDKHOANTHU = "IDKHOANTHU";
    public static final String TENKHOANTHU = "TENKHOANTHU";
    public static final String NGAYTHU = "NGAYTHU";
    public static final String SOTIEN = "SOTIEN";
    public static final String GHICHU = "GHICHU";
    public static final String TENNGUOITHU = "TENNGUOITHU";


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOAITHU = "CREATE TABLE "+LOAITHU+"("+IDLOAITHU +" INTEGER PRIMARY KEY AUTOINCREMENT,"+TENLOAITHU+" NVARCHAR )";

        db.execSQL(CREATE_LOAITHU);
        String CREATE_KHOANTHU = "CREATE TABLE "+KHOANTHU+
                "("+IDKHOANTHU +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +TENKHOANTHU+" NVARCHAR,"
                +NGAYTHU +" DATE,"
                +SOTIEN+" FLOAT,"+ GHICHU+" NVARCHAR,"
                + TENNGUOITHU+" NVARCHAR,"
                +"FOREIGN KEY("+IDLOAITHU+")REFERENCES "+LOAITHU+")";
        db.execSQL(CREATE_KHOANTHU);
    }

    public long insertKhoanThu(KhoanThu khoanThu){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(IDKHOANTHU,khoanThu.getId());
        values.put(TENKHOANTHU,khoanThu.getTenKhoanThu());
        values.put(NGAYTHU,khoanThu.getNgayThu());
        values.put(SOTIEN,khoanThu.getSoTien());
        values.put(GHICHU,khoanThu.getGhiChu());
        values.put(TENNGUOITHU,khoanThu.getTenNguoiThu());
        long result = db.insert(KHOANTHU,null,values);
        return result;
    }

    public void updateKhoanThu(KhoanThu khoanThu){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TENKHOANTHU,khoanThu.getTenKhoanThu());
        values.put(NGAYTHU,khoanThu.getNgayThu());
        values.put(SOTIEN,khoanThu.getSoTien());
        values.put(GHICHU,khoanThu.getGhiChu());
        values.put(TENNGUOITHU,khoanThu.getTenNguoiThu());
        db.update(KHOANTHU,values,IDKHOANTHU +"=?",new String[]{String.valueOf(khoanThu.getId())});
    }

    public int deleteKhoanThu(KhoanThu khoanThu){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(KHOANTHU,IDKHOANTHU +"=?",new String[]{String.valueOf(khoanThu.getId())});
        return result;
    }

    public ArrayList<KhoanThu> getAllKhoanThu(){
        ArrayList<KhoanThu> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String SELECT = "SELECT * FROM "+KHOANTHU;
        Cursor cursor = db.rawQuery(SELECT,null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            if(cursor.isAfterLast()){
                int id = cursor.getInt(cursor.getColumnIndex(IDKHOANTHU));
                String tenKhoanThu = cursor.getString(cursor.getColumnIndex(TENKHOANTHU));
                String  ngayThu = cursor.getString(cursor.getColumnIndex(NGAYTHU));
                float soTien = cursor.getFloat(cursor.getColumnIndex(SOTIEN));
                String  ghiChu = cursor.getString(cursor.getColumnIndex(GHICHU));
                String  tenNguoiThu = cursor.getString(cursor.getColumnIndex(TENNGUOITHU));

                KhoanThu khoanThu = new KhoanThu(id,tenKhoanThu,ngayThu,soTien,ghiChu,tenNguoiThu);
                list.add(khoanThu);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return list;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
