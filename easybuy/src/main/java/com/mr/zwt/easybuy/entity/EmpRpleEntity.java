package com.mr.zwt.easybuy.entity;

public class EmpRpleEntity {
    private String erId;

    private String roleId;

    private String empId;

    public String getErId() {
        return erId;
    }

    public void setErId(String erId) {
        this.erId = erId == null ? null : erId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }
}