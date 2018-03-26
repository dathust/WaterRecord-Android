package com.wr.datpt.waterrecord.Model.ObjectClass;

/**
 * Created by DatPT on 25/03/2018.
 */

public class Customer {
    private int maKhachHang;
    private String tenKhachHang;
    private String tenKhac;
    private String diaChi;
    private int dienThoai;
    private String maSoThue;
    private int maSoDongHo;
    private int maBangGia;
    private int maTram;
    private int tongChiSo;
    private float toaDoX;
    private float getToaDoY;
    private String ghiChu;

    public Customer() {
    }

    public Customer(int maKhachHang, String tenKhachHang, String tenKhac, String diaChi, int dienThoai, String maSoThue, int maSoDongHo, int maBangGia, int maTram, int tongChiSo, float toaDoX, float getToaDoY, String ghiChu) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.tenKhac = tenKhac;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.maSoThue = maSoThue;
        this.maSoDongHo = maSoDongHo;
        this.maBangGia = maBangGia;
        this.maTram = maTram;
        this.tongChiSo = tongChiSo;
        this.toaDoX = toaDoX;
        this.getToaDoY = getToaDoY;
        this.ghiChu = ghiChu;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenKhac() {
        return tenKhac;
    }

    public void setTenKhac(String tenKhac) {
        this.tenKhac = tenKhac;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(int dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public int getMaSoDongHo() {
        return maSoDongHo;
    }

    public void setMaSoDongHo(int maSoDongHo) {
        this.maSoDongHo = maSoDongHo;
    }

    public int getMaBangGia() {
        return maBangGia;
    }

    public void setMaBangGia(int maBangGia) {
        this.maBangGia = maBangGia;
    }

    public int getMaTram() {
        return maTram;
    }

    public void setMaTram(int maTram) {
        this.maTram = maTram;
    }

    public int getTongChiSo() {
        return tongChiSo;
    }

    public void setTongChiSo(int tongChiSo) {
        this.tongChiSo = tongChiSo;
    }

    public float getToaDoX() {
        return toaDoX;
    }

    public void setToaDoX(float toaDoX) {
        this.toaDoX = toaDoX;
    }

    public float getGetToaDoY() {
        return getToaDoY;
    }

    public void setGetToaDoY(float getToaDoY) {
        this.getToaDoY = getToaDoY;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
