package com.coding.powerledger;

import com.coding.powerledger.dto.BatteryListDTO;
import com.coding.powerledger.model.Battery;
import com.coding.powerledger.service.BatteryService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class PowerLedgerApplicationTests {

    @Autowired
    private BatteryService batteryService;

    @Test
    public void testGetBatteryListFilteredByPostalCode() {
        List<Battery> batteryList = new ArrayList<>();

        batteryList.add(new Battery("Ootha", "2875", (long) 13500));
        batteryList.add(new Battery("Carmel", "6076", (long) 13500));
        batteryList.add(new Battery("Bentley", "6102", (long) 85000));
        batteryList.add(new Battery("Armadale", "6992", (long) 25000));
        batteryList.add(new Battery("Norfolk Island", "2899", (long) 13500));

        batteryService.saveBatteryList(batteryList);

        double totalCapacityForPO6000 = 13500 + 85000 + 25000;
        double averageCapacityForPO6000 = (13500 + 85000 + 25000) / 3.0;

        BatteryListDTO result = batteryService.getBatteryListFilteredByPostalCode("6000", "7000");

        //total
        Assert.assertEquals((long) totalCapacityForPO6000, (long) result.getTotalCapacity());
        //average
        Assert.assertEquals((long) averageCapacityForPO6000, (long) result.getAverageCapacity());
        //order
        Assert.assertTrue(result.getBatteryList().get(0).startsWith("A"));
    }


}


