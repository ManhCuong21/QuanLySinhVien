package com.example.cuonghmph16667fpteduvn_ass;

public class LoaiThu {
    private int id;
    private String tenLoaiThu;

    public LoaiThu(int id, String tenLoaiThu) {
        this.id = id;
        this.tenLoaiThu = tenLoaiThu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiThu() {
        return tenLoaiThu;
    }

    public void setTenLoaiThu(String tenLoaiThu) {
        this.tenLoaiThu = tenLoaiThu;
    }
}
