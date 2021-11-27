package com.example.cuonghmph16667fpteduvn_ass;

public class KhoanChi {
    private String tenKhoanChi,ngayChi,ghiChu,tenNguoiChi;
    private float soTien;
    private int id;

    public KhoanChi(int id,String tenKhoanChi, String ngayChi, float soTien, String ghiChu, String tenNguoiChi ) {
        this.tenKhoanChi = tenKhoanChi;
        this.ngayChi = ngayChi;
        this.ghiChu = ghiChu;
        this.tenNguoiChi = tenNguoiChi;
        this.soTien = soTien;
        this.id = id;
    }

    public String getTenKhoanChi() {
        return tenKhoanChi;
    }

    public void setTenKhoanChi(String tenKhoanChi) {
        this.tenKhoanChi = tenKhoanChi;
    }

    public String getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(String ngayChi) {
        this.ngayChi = ngayChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTenNguoiChi() {
        return tenNguoiChi;
    }

    public void setTenNguoiChi(String tenNguoiChi) {
        this.tenNguoiChi = tenNguoiChi;
    }

    public float getSoTien() {
        return soTien;
    }

    public void setSoTien(float soTien) {
        this.soTien = soTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
