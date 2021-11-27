package com.example.cuonghmph16667fpteduvn_ass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class KhoanChiDAO extends SQLiteOpenHelper {

    public KhoanChiDAO(@Nullable Context context) {
            super(context, "khoanchi.db", null, 1);
        }


    public static final String LOAICHI = "LOAICHI";
    public static final String IDLOAICHI = "IDLOAICHI";
    public static final String TENLOAICHI = "TENLOAICHI";

    public static final String KHOANCHI = "KHOANCHI";
    public static final String IDKHOANCHI = "IDKHOANCHI";
    public static final String TENKHOANCHI = "TENKHOANCHI";
    public static final String NGAYCHI = "NGAYCHI";
    public static final String SOTIEN = "SOTIEN";
    public static final String GHICHU = "GHICHU";
    public static final String TENNGUOICHI = "TENNGUOICHI";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOAICHI = "CREATE TABLE "+LOAICHI+"("+IDLOAICHI+" INTEGER PRIMARY KEY AUTOINCREMENT,"+TENLOAICHI+" NVARCHAR )";
        db.execSQL(CREATE_LOAICHI);

        String CREATE_KHOANCHI = "CREATE TABLE KHOANCHI (IDKHOANCHI INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TENKHOANCHI NVARCHAR," +
                "NGAYCHI DATE," +
                "SOTIEN FLOAT," +
                "GHICHU NVARCHAR," +
                "TENNGUOICHI NVARCHAR,"+
                "FOREIGN KEY(IDLOAICHI) REFERENCES LOAICHI)";
        db.execSQL(CREATE_KHOANCHI);
    }

    public long insertKhoanChi(KhoanChi khoanChi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(IDKHOANCHI,khoanChi.getId());
        values.put(TENKHOANCHI,khoanChi.getTenKhoanChi());
        values.put(NGAYCHI,khoanChi.getNgayChi());
        values.put(SOTIEN,khoanChi.getSoTien());
        values.put(GHICHU,khoanChi.getGhiChu());
        values.put(TENNGUOICHI,khoanChi.getTenNguoiChi());
        long result = db.insert(KHOANCHI,null,values);
        return result;
    }

    public void updateKhoanThu(KhoanChi khoanChi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(IDKHOANCHI,khoanChi.getId());
        values.put(TENKHOANCHI,khoanChi.getTenKhoanChi());
        values.put(NGAYCHI,khoanChi.getNgayChi());
        values.put(SOTIEN,khoanChi.getSoTien());
        values.put(GHICHU,khoanChi.getGhiChu());
        values.put(TENNGUOICHI,khoanChi.getTenNguoiChi());
        db.update(KHOANCHI,values,IDKHOANCHI +"=?",new String[]{String.valueOf(khoanChi.getId())});
    }

    public int deleteKhoanThu(KhoanChi khoanChi){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(KHOANCHI,IDKHOANCHI +"=?",new String[]{String.valueOf(khoanChi.getId())});
        return result;
    }

    public ArrayList<KhoanChi> getAllKhoanThu(){
        ArrayList<KhoanChi> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String SELECT = "SELECT * FROM "+KHOANCHI;
        Cursor cursor = db.rawQuery(SELECT,null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            if(cursor.isAfterLast()){
                int id = cursor.getInt(cursor.getColumnIndex(IDKHOANCHI));
                String tenKhoanThu = cursor.getString(cursor.getColumnIndex(TENKHOANCHI));
                String  ngayThu = cursor.getString(cursor.getColumnIndex(NGAYCHI));
                float soTien = cursor.getFloat(cursor.getColumnIndex(SOTIEN));
                String  ghiChu = cursor.getString(cursor.getColumnIndex(GHICHU));
                String  tenNguoiThu = cursor.getString(cursor.getColumnIndex(TENNGUOICHI));

                KhoanChi khoanChi = new KhoanChi(id,tenKhoanThu,ngayThu,soTien,ghiChu,tenNguoiThu);
                list.add(khoanChi);
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
