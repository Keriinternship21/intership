package model;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;
    private String diachi;
    private String email;
    private String pass;
    private String maTax;
    private String permission;
    private String sdt;
    private String ten;

    public User() {
    }

    public User(String userId, String ten, String email,String sdt, String diachi,String pass,String maTax, String permission) {
        this.userId = userId;
        this.diachi = diachi;
        this.pass = pass;
        this.maTax = maTax;
        this.email = email;
        this.permission = permission;
        this.sdt = sdt;
        this.ten = ten;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMaTax() {
        return maTax;
    }

    public void setMaTax(String maTax) {
        this.maTax = maTax;
    }
}
