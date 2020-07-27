package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import exception.ParkingLotException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {
    protected ParkingLot parkingLot;

    @BeforeEach
    public void setup() {
        parkingLot = new ParkingLot(10);
    }
    @Test
    void should_specify_a_parkingBoy_on_the_list_to_park_a_car() {
        try {
            //given
            ParkingLot parkingLotA = new ParkingLot(10);
            ParkingManager parkingManager = new ParkingManager(new ParkingBoy(Arrays.asList(parkingLotA)));

            //when
            parkingManager.park(new Car());

            //then
            assertEquals(1, parkingLotA.getUsed());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }
}
