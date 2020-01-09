package com.mr.zwt.easybuy.entity;

public class GoodTypeEntity {
    private String typeId;

    private String typeName;

    private Integer typeOrd;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getTypeOrd() {
        return typeOrd;
    }

    public void setTypeOrd(Integer typeOrd) {
        this.typeOrd = typeOrd;
    }
}