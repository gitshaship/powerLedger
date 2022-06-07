package com.coding.powerledger.service;

import com.coding.powerledger.dto.BatteryListDTO;
import com.coding.powerledger.model.Battery;
import com.coding.powerledger.repository.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryServiceImpl implements BatteryService {

    @Autowired
    private BatteryRepository batteryRepository;

    @Override
    public List<Battery> saveBatteryList(List<Battery> batteryList){
        return (List<Battery>) batteryRepository.saveAll(batteryList);
    }

    @Override
    public List<Battery> fetchBatteryList(){
        return (List<Battery>) batteryRepository.findAll();
    }

    @Override
    public BatteryListDTO getBatteryListFilteredByPostalCode(String startCode, String endCode){
        int std = Integer.parseInt(startCode);
        int end = Integer.parseInt(endCode);

        List<Battery> sortedList = getSortedByNameList(std, end);
        if(sortedList != null && !sortedList.isEmpty()){
            List<String> nameList = sortedList
                    .stream()
                    .map(Battery::getName)
                    .collect(Collectors.toList());
            return new BatteryListDTO(nameList, getAverageCapacity(sortedList), getTotalCapacity(sortedList));
        }
        else{
            return null;
        }
    }

    private Double getAverageCapacity(List<Battery> batteryList){
        return batteryList.stream()
                .mapToDouble(Battery::getCapacity)
                .average()
                .orElse(0);
    }

    private Double getTotalCapacity(List<Battery> batteryList){
        return batteryList.stream()
                .mapToDouble(Battery::getCapacity)
                .sum();
    }

    //get battery list for given post code range, sorted by Name
    private List<Battery> getSortedByNameList(int startCode, int endCode){
        return ((List<Battery>)batteryRepository.findAll()).stream()
                .filter(battery -> Integer.parseInt(battery.getPostcode()) >= startCode && Integer.parseInt(battery.getPostcode()) <= endCode )
                .sorted(Comparator.comparing(Battery::getName))
                .collect(Collectors.toList());
    }


}
