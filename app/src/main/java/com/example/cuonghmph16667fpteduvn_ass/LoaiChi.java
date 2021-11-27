package com.example.cuonghmph16667fpteduvn_ass;

public class LoaiChi {
    private int id;
    private String tenLoaiChi;

    public LoaiChi(int id, String tenLoaiChi) {
        this.id = id;
        this.tenLoaiChi = tenLoaiChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiChi() {
        return tenLoaiChi;
    }

    public void setTenLoaiChi(String tenLoaiChi) {
        this.tenLoaiChi = tenLoaiChi;
    }
}
