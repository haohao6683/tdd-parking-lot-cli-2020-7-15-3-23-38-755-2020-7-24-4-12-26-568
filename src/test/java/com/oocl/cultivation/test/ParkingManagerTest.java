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

    @Test
    void should_specify_a_parkingBoy_on_the_list_to_fetch_a_car() {
        try {
            //given
            ParkingLot parkingLotA = new ParkingLot(10);
            ParkingManager parkingManager = new ParkingManager(new ParkingBoy(Arrays.asList(parkingLotA)));
            Ticket ticket = parkingManager.park(new Car());

            //when
            //todo don't know which guy is doing the fetch action.
             Car car = parkingManager.fetch(ticket);

            //then
            assertNotNull(car);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void should_return_ticket_when_customer_given_a_car_to_parkingManager() {
        try {
            //given
            Car car = new Car();
            ParkingManager parkingManager = new ParkingManager(new ParkingBoy(Arrays.asList(parkingLot)));

            //when
            Ticket ticket = parkingManager.park(car);

            //then
            assertNotNull(ticket);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }
}
