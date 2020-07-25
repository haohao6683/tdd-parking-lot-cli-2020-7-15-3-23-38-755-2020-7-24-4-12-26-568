package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import exception.ParkingLotException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_customer_given_a_car_to_parkingBoy() {
        Ticket ticket = null;
        try {
            //given
            ParkingLot parkingLot = new ParkingLot();
            Car car = new Car();

            //when
            ticket = parkingLot.park(car);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

        //then
        assertTrue(ticket != null);
    }

    @Test
    void should_return_car_when_customer_given_a_ticket_to_parkingBoy() {
        Car car = null;
        Car actualCar = null;
        try {
            //given
            car = new Car();
            ParkingLot parkingLot = new ParkingLot();
            Ticket ticket = parkingLot.park(car);

            //when
            actualCar = parkingLot.fetch(ticket);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

        //then
        assertEquals(car, actualCar);
    }

}
