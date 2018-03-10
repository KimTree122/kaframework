package com.kim.kaframework.Model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

@Entity
public class UserInfo {
    @Id(autoincrement = true)
    private Long id;
    private String UName;
    private String UPost;
    @Generated(hash = 2139232172)
    public UserInfo(Long id, String UName, String UPost) {
        this.id = id;
        this.UName = UName;
        this.UPost = UPost;
    }
    @Generated(hash = 1279772520)
    public UserInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUName() {
        return this.UName;
    }
    public void setUName(String UName) {
        this.UName = UName;
    }
    public String getUPost() {
        return this.UPost;
    }
    public void setUPost(String UPost) {
        this.UPost = UPost;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", UName='" + UName + '\'' +
                ", UPost='" + UPost + '\'' +
                '}';
    }
}
