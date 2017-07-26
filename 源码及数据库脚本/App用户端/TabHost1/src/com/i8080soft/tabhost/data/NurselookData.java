package com.i8080soft.tabhost.data;

import java.io.Serializable;

public class NurselookData implements Serializable{

	  /**
     * nurseId : nurse1
     * nurseName : 护工0
     * sex : 0
     * major : 医疗管理
     * age : 0
     * birthday : Jul 1, 2017 9:23:40 AM
     * createTime : Jul 1, 2017 9:26:13 AM
     * nurseLevel : 0
     * wage : 20
     * nurseIdcard : 123456789123456789
     * address : 广东省黄浦区揽月路8号东软大厦
     * introduce : 你好！我是护工0。
     * isfree : 0
     */

    private String nurseId;
    private String nurseName;
    private int sex;
    private String major;
    private int age;
    private String birthday;
    private String createTime;
    private int nurseLevel;
    private int wage;
    private String nurseIdcard;
    private String address;
    private String introduce;
    private int isfree;
    private int pic;

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public NurselookData(String nurseId, String nurseName, String major, String createTime, String introduce,int pic,int isfree,int sex,String address) {
        this.nurseId = nurseId;
        this.nurseName = nurseName;
        this.major = major;
        this.createTime = createTime;
        this.introduce = introduce;
        this.pic=pic;
        this.isfree=isfree;
        this.address=address;
        this.sex=sex;
       
    }

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getNurseLevel() {
        return nurseLevel;
    }

    public void setNurseLevel(int nurseLevel) {
        this.nurseLevel = nurseLevel;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public String getNurseIdcard() {
        return nurseIdcard;
    }

    public void setNurseIdcard(String nurseIdcard) {
        this.nurseIdcard = nurseIdcard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getIsfree() {
        return isfree;
    }

    public void setIsfree(int isfree) {
        this.isfree = isfree;
    }
}

