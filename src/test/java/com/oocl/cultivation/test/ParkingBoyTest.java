package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_customer_given_a_car_to_parkingBoy() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertTrue(ticket != null);
    }

    @Test
    void should_return_car_when_customer_given_a_ticket_to_parkingBoy() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.park(car);

        //when
        Car actualCar = parkingBoy.fetch(ticket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    void should_return_correct_car_when_parkingBoy_given_the_corresponding_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticketA = parkingBoy.park(new Car());
        Ticket ticketB = parkingBoy.park(new Car());

        //when
        Car carA = parkingBoy.fetch(ticketA);
        Car carB = parkingBoy.fetch(ticketB);

        //then
        assertTrue(carA != carB);
    }

    @Test
    void should_return_no_ticket_when_parkingLot_given_no_position() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Car car = new Car();
        for(int i=1; i<=10; i++){
            parkingBoy.park(car);
        }
        Ticket ticket = parkingBoy.park(car);

        //then
        assertTrue(ticket == null);
    }
}
