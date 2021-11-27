package com.example.cuonghmph16667fpteduvn_ass;

public class KhoanThu {
    private String tenKhoanThu,ngayThu,ghiChu,tenNguoiThu;
    private float soTien;
    private int id;


    public int getId() {
        return id;
    }

    public KhoanThu(int id, String tenKhoanThu, String ngayThu, float soTien, String ghiChu, String tenNguoiThu ) {
        this.tenKhoanThu = tenKhoanThu;
        this.ngayThu = ngayThu;
        this.ghiChu = ghiChu;
        this.tenNguoiThu = tenNguoiThu;
        this.soTien = soTien;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KhoanThu() {
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public String getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(String ngayThu) {
        this.ngayThu = ngayThu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTenNguoiThu() {
        return tenNguoiThu;
    }

    public void setTenNguoiThu(String tenNguoiThu) {
        this.tenNguoiThu = tenNguoiThu;
    }

    public float getSoTien() {
        return soTien;
    }

    public void setSoTien(float soTien) {
        this.soTien = soTien;
    }
}
