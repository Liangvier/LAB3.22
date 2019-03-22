package com.gaoyu.smarttools.bean;

/**
 * Created by ${高宇} on 17/6/6.
 */

public class AirBean {

    private  int mPower=1; //开关
    private  int mTmp=25;  //温度
    private  int mMode=1;  //模式
    private  int menergy=0;  //节能省电
    private  int mWindDir=1;   //风向
    private  int mWindCount=2; //风量
    public AirBean(){

    }

    public AirBean(int mPower, int mTmp, int mMode, int menergy, int mWindDir, int mWindCount) {
        this.mPower = mPower;
        this.mTmp = mTmp;
        this.mMode = mMode;
        this.menergy = menergy;
        this.mWindDir = mWindDir;
        this.mWindCount = mWindCount;
    }


    public int getmTmp() {
        return mTmp;
    }

    public void setmTmp(int mTmp) {
        this.mTmp = mTmp;
    }

    public int getmMode() {
        return mMode;
    }

    public void setmMode(int mMode) {
        this.mMode = mMode;
    }

    public int getmPower() {
        return mPower;
    }

    public void setmPower(int mPower) {
        this.mPower = mPower;
    }

    public int getmenergy() {
        return menergy;
    }

    public void setmenergy(int menergy) {
        this.menergy = menergy;
    }

    public int getmWindCount() {
        return mWindCount;
    }

    public void setmWindCount(int mWindCount) {
        this.mWindCount = mWindCount;
    }

    public int getmWindDir() {
        return mWindDir;
    }

    public void setmWindDir(int mWindDir) {
        this.mWindDir = mWindDir;
    }

    @Override
    public String toString() {
        return "AirBean{" +
                "mPower=" + mPower +
                ", mTmp=" + mTmp +
                ", mMode=" + mMode +
                ", menergy=" + menergy +
                ", mWindDir=" + mWindDir +
                ", mWindCount=" + mWindCount +
                '}';
    }
}
