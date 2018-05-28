package com.disney.zeus.deal.entity;

public class DealAmendmentMemo {

    private Deal deal;
    private String newVersion;
    private String oldVersion;
    private String user;

    public String getNewVersion() {
        return newVersion;
    }

    public String getOldVersion() {
        return oldVersion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    public void setOldVersion(String oldVersion) {
        this.oldVersion = oldVersion;
    }
}
