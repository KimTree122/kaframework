package com.kim.kfdao.Model;

public class PermissionFuntion {

    private int ID;
    private int FID;
    private String PFEName;
    private String PFCName;
    private String LayoutName;

    public PermissionFuntion(){}

    public PermissionFuntion (PermissionFuntion p){
        PermissionFuntion pf = new PermissionFuntion();
        pf.setFID(p.getFID());
        pf.setID(p.getID());
        pf.setPFCName(p.getPFCName());
        pf.setPFEName(p.getPFEName());
        pf.setLayoutName(p.getLayoutName());
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFID() {
        return FID;
    }

    public void setFID(int FID) {
        this.FID = FID;
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
