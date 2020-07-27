package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import exception.ParkingLotException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuperSmartParkingBoyTest extends ParkingBoyTest {
    protected SuperSmartParkingBoy superSmartParkingBoy;
    @BeforeEach
    public void setup() {
        parkingLotA = new ParkingLot(10);
        parkingLotB = new ParkingLot(10);
        parkingBoy = new ParkingBoy(Arrays.asList(parkingLotA, parkingLotB));
        superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(parkingLotA, parkingLotB));
    }

    @Test
    void should_park_car_which_has_a_larger_available_position_rate_when_spuerSmartParkingBoy_parking() {
        try {
            //given
            parkingLotA.setUsed(parkingLotA.getCapacity()/2);

            //when
            superSmartParkingBoy.park(new Car());

            //then
            assertTrue(parkingLotA.getUsed() == 5 && parkingLotB.getUsed() == 1);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

}
