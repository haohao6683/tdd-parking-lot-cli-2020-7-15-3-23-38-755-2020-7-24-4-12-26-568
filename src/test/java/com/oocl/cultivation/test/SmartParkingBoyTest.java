package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import exception.ParkingLotException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartParkingBoyTest {
    private ParkingBoy parkingBoy;
    private SmartParkingBoy smartParkingBoy;
    private ParkingLot parkingLotA;
    private ParkingLot parkingLotB;

    @BeforeEach
    public void setup() {
        parkingLotA = new ParkingLot(10);
        parkingLotB = new ParkingLot(10);
        parkingBoy = new ParkingBoy(Arrays.asList(parkingLotA,parkingLotB));
        smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLotA,parkingLotB));
    }

    @Test
    void should_park_car_which_contains_more_empty_positions_when_smartParkingBoy_parking() {
        try{
            //given
            for(int i = 1; i <= 5; i++){
                parkingBoy.park(new Car());
            }

            //when
            smartParkingBoy.park(new Car());

            //then
            assertTrue(parkingLotA.getUsed() == 5 && parkingLotB.getUsed() == 1);
        }
        catch (ParkingLotException e){
            e.printStackTrace();
        }
    }
}
