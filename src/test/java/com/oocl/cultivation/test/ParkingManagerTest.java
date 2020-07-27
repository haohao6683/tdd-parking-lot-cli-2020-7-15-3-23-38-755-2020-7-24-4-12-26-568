package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import exception.ParkingLotException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingManagerTest {
    @Test
    void should_specify_a_parkingBoy_on_the_list_to_park_a_car() {
        try {
            //given
            ParkingManager parkingManager = new ParkingManager(new ParkingBoy(Arrays.asList(new ParkingLot(1))));

            //when
            Ticket ticket = parkingManager.park(new Car());

            //then
            assertNotNull(ticket);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }
}
