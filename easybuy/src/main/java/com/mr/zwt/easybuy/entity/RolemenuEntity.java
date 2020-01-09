package com.mr.zwt.easybuy.entity;

public class RolemenuEntity {
    private String rmId;

    private String roleId;

    private String meId;

    public String getRmId() {
        return rmId;
    }

    public void setRmId(String rmId) {
        this.rmId = rmId == null ? null : rmId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getMeId() {
        return meId;
    }

    public void setMeId(String meId) {
        this.meId = meId == null ? null : meId.trim();
    }
}