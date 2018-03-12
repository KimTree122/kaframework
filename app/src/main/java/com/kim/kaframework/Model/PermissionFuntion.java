package com.kim.kaframework.Model;

public class PermissionFuntion {

    private int PFID;
    private int FID;
    private String PFEName;
    private String PFCName;

    public int getFID() {
        return FID;
    }

    public void setFID(int FID) {
        this.FID = FID;
    }

    public int getPFID() {
        return PFID;
    }

    public void setPFID(int PFID) {
        this.PFID = PFID;
    }

    public String getPFEName() {
        return PFEName;
    }

    public void setPFEName(String PFEName) {
        this.PFEName = PFEName;
    }

    public String getPFCName() {
        return PFCName;
    }

    public void setPFCName(String PFCName) {
        this.PFCName = PFCName;
    }
}
