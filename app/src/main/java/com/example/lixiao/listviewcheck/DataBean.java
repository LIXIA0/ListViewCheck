package com.example.lixiao.listviewcheck;

/**
 * Created by lixiao on 2017/10/29.
 */

public class DataBean {
    private String name;
    private boolean ischeck;

    public DataBean() {
    }

    public DataBean(String name, boolean ischeck) {
        this.name = name;
        this.ischeck = ischeck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean ischeck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }
}
