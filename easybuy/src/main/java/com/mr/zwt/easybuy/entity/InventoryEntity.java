package com.mr.zwt.easybuy.entity;

import java.util.Date;

public class InventoryEntity {
    private String ioId;

    private String empId;

    private Integer ioType;

    private Integer ioCount;

    private Date ioDate;

    public String getIoId() {
        return ioId;
    }

    public void setIoId(String ioId) {
        this.ioId = ioId == null ? null : ioId.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public Integer getIoType() {
        return ioType;
    }

    public void setIoType(Integer ioType) {
        this.ioType = ioType;
    }

    public Integer getIoCount() {
        return ioCount;
    }

    public void setIoCount(Integer ioCount) {
        this.ioCount = ioCount;
    }

    public Date getIoDate() {
        return ioDate;
    }

    public void setIoDate(Date ioDate) {
        this.ioDate = ioDate;
    }
}