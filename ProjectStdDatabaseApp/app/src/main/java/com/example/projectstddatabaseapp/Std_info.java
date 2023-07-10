package com.example.projectstddatabaseapp;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Std_info {

    public static SQLiteDatabase db;
    public static String dbname="std";

    String roll,name,mobile,addr,branch;

    public String getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddr() {
        return addr;
    }

    public String getBranch() {
        return branch;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public static ArrayList<Std_info> std_collection=new ArrayList<Std_info>();
}
