package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    private ParkingBoy parkingBoy;

    @BeforeEach
    public void setup() {
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy = new ParkingBoy(parkingLot);
    }

    @Test
    void should_return_ticket_when_customer_given_a_car_to_parkingBoy() {
        //given
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
        Ticket ticket = parkingBoy.park(car);

        //when
        Car actualCar = parkingBoy.fetch(ticket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    void should_return_correct_car_when_parkingBoy_given_the_corresponding_ticket() {
        //given
        Ticket ticketA = parkingBoy.park(new Car());
        Ticket ticketB = parkingBoy.park(new Car());

        //when
        Car carA = parkingBoy.fetch(ticketA);
        Car carB = parkingBoy.fetch(ticketB);

        //then
        assertNotEquals(carA, carB);
    }

    @Test
    void should_return_no_car_when_parkingBoy_given_the_wrong_ticket() {
        //given
        Ticket ticketA = parkingBoy.park(new Car());

        //when
        Car carA = parkingBoy.fetch(ticketA);
        Car carB = parkingBoy.fetch(new Ticket());
        Car carC = parkingBoy.fetch(null);

        //then
        assertTrue(!carA.equals(carB) && !carA.equals(carC));
    }

    @Test
    void should_return_no_ticket_when_given_parkingLot_is_full() {
        //given
        for(int i = 1; i <= 10; i++){
            parkingBoy.park(new Car());
        }
        //when
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        //then
        assertTrue(ticket == null);
    }
}
