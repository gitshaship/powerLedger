package com.coding.powerledger.controller;

import com.coding.powerledger.dto.BatteryListDTO;
import com.coding.powerledger.model.Battery;
import com.coding.powerledger.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BatteryController {

    @Autowired
    private BatteryService batteryService;

    @PostMapping("/battery-list")
    public List<Battery> saveBatteryList(@Valid @RequestBody List<Battery> batteryList) {
        return batteryService.saveBatteryList(batteryList);
    }

    @GetMapping("/battery-list")
    @ResponseBody
    public List<Battery> fetchBatteryList() {
        return batteryService.fetchBatteryList();
    }

    @GetMapping("/battery-list/statistics")
    @ResponseBody
    public ResponseEntity<Object> fetchSortedBatteryList(@RequestParam(name = "StartCode") String startCode, @RequestParam(name = "EndCode") String endCode) {

        BatteryListDTO response = batteryService.getBatteryListFilteredByPostalCode(startCode, endCode);
        if (response != null) {
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.badRequest().body("Bad Request");
        }

    }

}
