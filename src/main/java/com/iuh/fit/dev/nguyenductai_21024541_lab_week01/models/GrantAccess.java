package com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models;

import java.util.Objects;

public class GrantAccess {
    private Account accountID;
    private  Role roleID;
    private boolean isGrant;
    private String note;

    public GrantAccess() {
    }

    public GrantAccess(Account accountID, Role roleID, boolean isGrant, String note) {
        this.accountID = accountID;
        this.roleID = roleID;
        this.isGrant = isGrant;
        this.note = note;
    }

    public Account getAccountID() {
        return accountID;
    }

    public void setAccountID(Account accountID) {
        this.accountID = accountID;
    }

    public Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
    }

    public boolean isGrant() {
        return isGrant;
    }

    public void setGrant(boolean grant) {
        isGrant = grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GrantAccess)) return false;
        GrantAccess that = (GrantAccess) o;
        return Objects.equals(getAccountID(), that.getAccountID()) && Objects.equals(getRoleID(), that.getRoleID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountID(), getRoleID());
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "accountID=" + accountID +
                ", roleID=" + roleID +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }
}
