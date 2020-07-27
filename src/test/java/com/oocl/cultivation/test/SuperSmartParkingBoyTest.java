package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import exception.ParkingLotException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest extends ParkingBoyTest {
    protected SuperSmartParkingBoy superSmartParkingBoy;
    @BeforeEach
    public void setup() {
        parkingLotA = new ParkingLot(10);
        parkingLotB = new ParkingLot(10);
        superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(parkingLotA, parkingLotB));
    }

    @Test
    void should_park_car_which_has_a_larger_available_position_rate_when_superSmartParkingBoy_parking() {
        try {
            //given
            parkingLotA.setUsed(parkingLotA.getCapacity()/2);
            parkingLotB.setUsed(parkingLotB.getCapacity());

            //when
            superSmartParkingBoy.park(new Car());

            //then
            assertEquals(6, parkingLotA.getUsed());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

}
