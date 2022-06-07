package com.coding.powerledger.service;

import com.coding.powerledger.dto.BatteryListDTO;
import com.coding.powerledger.model.Battery;

import java.util.List;

public interface BatteryService {

    List<Battery> saveBatteryList(List<Battery> batteryList);

    List<Battery> fetchBatteryList();

    BatteryListDTO getBatteryListFilteredByPostalCode(String startCode, String endCode);
}
