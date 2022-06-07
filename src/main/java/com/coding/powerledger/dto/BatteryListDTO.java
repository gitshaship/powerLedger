package com.coding.powerledger.dto;

import com.coding.powerledger.model.Battery;

import java.util.List;

public class BatteryListDTO {

    private List<String> batteryList;
    private double averageCapacity;
    private double totalCapacity;

    public BatteryListDTO(List<String> batteryList, double averageCapacity, double totalCapacity) {
        this.batteryList = batteryList;
        this.averageCapacity = averageCapacity;
        this.totalCapacity = totalCapacity;
    }

    public List<String> getBatteryList() {
        return batteryList;
    }

    public void setBatteryList(List<String> batteryList) {
        this.batteryList = batteryList;
    }

    public double getAverageCapacity() {
        return averageCapacity;
    }

    public void setAverageCapacity(double averageCapacity) {
        this.averageCapacity = averageCapacity;
    }

    public double getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(double totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

}
