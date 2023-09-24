package com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models;

import java.sql.Date;
import java.util.Objects;

public class Log {
    private Account accountID;
    private Date ngayDangNhap;
    private Date ngayDangXuat;
    private  String ghiChu;

    public Log() {
    }

    public Log(Account accountID, Date ngayDangNhap, Date ngayDangXuat, String ghiChu) {
        this.accountID = accountID;
        this.ngayDangNhap = ngayDangNhap;
        this.ngayDangXuat = ngayDangXuat;
        this.ghiChu = ghiChu;
    }

    public Account getAccountID() {
        return accountID;
    }

    public void setAccountID(Account accountID) {
        this.accountID = accountID;
    }

    public Date getNgayDangNhap() {
        return ngayDangNhap;
    }

    public void setNgayDangNhap(Date ngayDangNhap) {
        this.ngayDangNhap = ngayDangNhap;
    }

    public Date getNgayDangXuat() {
        return ngayDangXuat;
    }

    public void setNgayDangXuat(Date ngayDangXuat) {
        this.ngayDangXuat = ngayDangXuat;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Log)) return false;
        Log log = (Log) o;
        return Objects.equals(getAccountID(), log.getAccountID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountID());
    }

    @Override
    public String toString() {
        return "Log{" +
                "accountID=" + accountID +
                ", ngayDangNhap=" + ngayDangNhap +
                ", ngayDangXuat=" + ngayDangXuat +
                ", ghiChu='" + ghiChu + '\'' +
                '}';
    }
}
