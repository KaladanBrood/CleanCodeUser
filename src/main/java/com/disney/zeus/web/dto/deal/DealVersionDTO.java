package com.disney.zeus.web.dto.deal;

import java.io.Serializable;
import java.util.Date;

public class DealVersionDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long dealId;
    private String versionNumber;
    private Date date;
    private String user;
    private boolean  isZeus3 = true;

    /**
     * @return the dealId
     */
    public Long getDealId() {
        return dealId;
    }
    /**
     * @param dealId the dealId to set
     */
    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }
    /**
     * @return the versionNumber
     */
    public String getVersionNumber() {
        return versionNumber;
    }
    /**
     * @param versionNumber the versionNumber to set
     */
    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }
    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }
    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }
    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }
    public boolean isZeus3() {
        return isZeus3;
    }
    public void setZeus3(boolean isZeus3) {
        this.isZeus3 = isZeus3;
    }

}
