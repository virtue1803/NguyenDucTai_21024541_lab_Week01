package com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {
    private String accountID,fullname, password, email, phone;
    private int status;

    public Account() {
    }

    public Account(String accountID, String fullname, String password, String email, String phone, int status) {
        this.accountID = accountID;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getAccountID(), account.getAccountID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountID());
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID='" + accountID + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
