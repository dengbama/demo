package com.deng.entity;

import org.springframework.context.annotation.Scope;

/**
 * @Author：dengwenxin-wb
 * @Project：filedeal
 * @name：InfoTower
 * @Date：2024/2/2 14:53
 */
public class InfoTower {
   private int towerId;
   private String towerCode;
   private double lng;
   private double lat;
   private String lineName;

    public InfoTower() {
    }

    public InfoTower(int towerId, String towerCode, double lng, double lat, String lineName) {
        this.towerId = towerId;
        this.towerCode = towerCode;
        this.lng = lng;
        this.lat = lat;
        this.lineName = lineName;
    }

    public int getTowerId() {
        return towerId;
    }

    public void setTowerId(int towerId) {
        this.towerId = towerId;
    }

    public String getTowerCode() {
        return towerCode;
    }

    public void setTowerCode(String towerCode) {
        this.towerCode = towerCode;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    @Override
    public String toString() {
        return "InfoTower{" +
                "towerId=" + towerId +
                ", towerCode='" + towerCode + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", lineName='" + lineName + '\'' +
                '}';
    }
}
