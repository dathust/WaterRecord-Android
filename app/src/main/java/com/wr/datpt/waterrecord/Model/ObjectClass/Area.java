package com.wr.datpt.waterrecord.Model.ObjectClass;

import java.sql.Date;

/**
 * Created by DatPT on 11/02/2018.
 */

public class Area {

    private int maKhuVuc;
    private byte xoa;
    private String  nguoiTao;
    private String doi;
    private String thon;
    private String xa;
    private String huyen;
    private String tinh;
    private String chiTiet;
    private String ghiChu;

    public Area() {
    }

    public Area(int maKhuVuc, byte xoa, String  nguoiTao, String doi, String thon, String xa, String huyen, String tinh, String chiTiet, String ghiChu) {
        this.maKhuVuc = maKhuVuc;
        this.xoa = xoa;
        this.nguoiTao = nguoiTao;
        this.doi = doi;
        this.thon = thon;
        this.xa = xa;
        this.huyen = huyen;
        this.tinh = tinh;
        this.chiTiet = chiTiet;
        this.ghiChu = ghiChu;
    }

    public int getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(int maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public byte getXoa() {
        return xoa;
    }

    public void setXoa(byte xoa) {
        this.xoa = xoa;
    }

    public String  getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getThon() {
        return thon;
    }

    public void setThon(String thon) {
        this.thon = thon;
    }

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }

    public String getHuyen() {
        return huyen;
    }

    public void setHuyen(String huyen) {
        this.huyen = huyen;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
