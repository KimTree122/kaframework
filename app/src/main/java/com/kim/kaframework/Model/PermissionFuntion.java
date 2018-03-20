package com.kim.kaframework.Model;

public class PermissionFuntion {

    private int ID;
    private int FID;
    private int PorF;
    private String PFEName;
    private String PFCName;
    private String LayoutName;

    public int getFID() {
        return FID;
    }

    public void setFID(int FID) {
        this.FID = FID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPorF() {
        return PorF;
    }

    public void setPorF(int porF) {
        PorF = porF;
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

    public String getLayoutName() {
        return LayoutName;
    }

    public void setLayoutName(String layoutName) {
        LayoutName = layoutName;
    }
}
