package com.thai.quanlicongty.model;

public class Taikhoan {
    private String taiKhoan;
    private String matKhau;
    private String key;

    @Override
    public String toString() {
        return "Taikhoan{" +
                "taiKhoan='" + taiKhoan + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

    public Taikhoan(){

    }
    public Taikhoan(String taiKhoan, String matKhau){
        super();
        this.taiKhoan=taiKhoan;
        this.matKhau=matKhau;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
