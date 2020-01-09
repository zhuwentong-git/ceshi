package com.mr.zwt.easybuy.entity;

public class MenuEntity {
    private String meId;

    private String meName;

    private String meUrl;

    private String mePid;

    public String getMeId() {
        return meId;
    }

    public void setMeId(String meId) {
        this.meId = meId == null ? null : meId.trim();
    }

    public String getMeName() {
        return meName;
    }

    public void setMeName(String meName) {
        this.meName = meName == null ? null : meName.trim();
    }

    public String getMeUrl() {
        return meUrl;
    }

    public void setMeUrl(String meUrl) {
        this.meUrl = meUrl == null ? null : meUrl.trim();
    }

    public String getMePid() {
        return mePid;
    }

    public void setMePid(String mePid) {
        this.mePid = mePid == null ? null : mePid.trim();
    }
}