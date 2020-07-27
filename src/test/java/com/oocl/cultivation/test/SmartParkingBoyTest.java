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

public class SmartParkingBoyTest extends ParkingBoyTest{
    protected SmartParkingBoy smartParkingBoy;
    @BeforeEach
    public void setup() {
        parkingLotA = new ParkingLot(10);
        parkingLotB = new ParkingLot(10);
        smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLotA,parkingLotB));
    }

    @Test
    void should_park_car_which_contains_more_empty_positions_when_smartParkingBoy_parking() {
        try{
            //given
            parkingLotA.setUsed(parkingLotA.getCapacity()/2);

            //when
            smartParkingBoy.park(new Car());

            //then
            //todo assert要简单明确，不要把两个合起来
            assertEquals(1, parkingLotB.getUsed());
        }
        catch (ParkingLotException e){
            e.printStackTrace();
        }
    }
}
