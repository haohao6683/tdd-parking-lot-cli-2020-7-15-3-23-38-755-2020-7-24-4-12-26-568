package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import exception.ParkingLotException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    private ParkingBoy parkingBoy;

    @BeforeEach
    public void setup() {
        ParkingLot parkingLotA = new ParkingLot(10);
        ParkingLot parkingLotB = new ParkingLot(10);
        parkingBoy = new ParkingBoy(Arrays.asList(parkingLotA,parkingLotB));
    }

    @Test
    void should_return_ticket_when_customer_given_a_car_to_parkingBoy() {
        Ticket ticket = null;
        try {
            //given
            Car car = new Car();

            //when
            ticket = parkingBoy.park(car);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_customer_given_a_ticket_to_parkingBoy() {
        Car car = null;
        Car actualCar = null;
        try {
            //given
            car = new Car();
            Ticket ticket = parkingBoy.park(car);

            //when
            actualCar = parkingBoy.fetch(ticket);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

        //then
        assertEquals(car, actualCar);
    }

    @Test
    void should_return_correct_car_when_parkingBoy_given_the_corresponding_ticket() {
        Car carA = null;
        Car carB = null;
        try {
            //given
            Ticket ticketA = parkingBoy.park(new Car());
            Ticket ticketB = parkingBoy.park(new Car());

            //when
            carA = parkingBoy.fetch(ticketA);
            carB = parkingBoy.fetch(ticketB);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

        //then
        assertNotEquals(carA, carB);
    }

    @Test
    void should_return_no_car_when_parkingBoy_given_the_wrong_ticket() {
        Car carA = null;
        Car carB = null;
        Car carC = null;
        try {
            //given
            Ticket ticketA = parkingBoy.park(new Car());

            //when
            carA = parkingBoy.fetch(ticketA);
            carB = parkingBoy.fetch(new Ticket());
            carC = parkingBoy.fetch(null);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

        //then
        assertTrue(!carA.equals(carB) && !carA.equals(carC));
    }

    @Test
    void should_return_no_car_when_parkingBoy_given_the_used_ticket() {
        Car carA = null;
        Car carB = null;
        try {
            //given
            Ticket ticketA = parkingBoy.park(new Car());

            //when
            carA = parkingBoy.fetch(ticketA);
            carB = parkingBoy.fetch(ticketA);
        } catch (ParkingLotException e) {
            //then
            assertEquals("Unrecognized parking ticket.", e.getMessage());
        }
    }

    @Test
    void should_return_no_ticket_when_given_parkingLot_is_full() {
        Ticket ticket = null;
        try {
            //given
            for(int i = 1; i <= 10; i++){
                parkingBoy.park(new Car());
            }

            //when
            Car car = new Car();
            ticket = parkingBoy.park(car);

        } catch (ParkingLotException e) {
            //then
            assertEquals("Unrecognized parking ticket.", e.getMessage());
        }
    }

    @Test
    void should_return_error_message_when_customer_give_the_wrong_ticket() {
        try{
            //given
            Ticket ticketA = parkingBoy.park(new Car());

            //when
            parkingBoy.fetch(ticketA);
            parkingBoy.fetch(new Ticket());
        }
        catch (ParkingLotException e){
            //then
            assertEquals("Unrecognized parking ticket.", e.getMessage());
        }
    }

    @Test
    void should_return_error_message_when_customer_give_no_ticket() {
        try{
            //given
            parkingBoy.park(new Car());

            //when
            parkingBoy.fetch(null);
        }
        catch (ParkingLotException e){
            //then
            assertEquals("Please provide your parking ticket.", e.getMessage());
        }
    }

    @Test
    void should_return_error_message_when_parkingLot_has_no_position() {
        try{
            //given
            for(int i = 1; i <= 10; i++){
                parkingBoy.park(new Car());
            }

            //when
            parkingBoy.park(new Car());
        }
        catch (ParkingLotException e){
            //then
            assertEquals("Not enough position.", e.getMessage());
        }
    }

    @Test
    void should_park_car_sequentially_when_some_parkingLot_if_full() {
        try{
            //given
            for(int i = 1; i <= 10; i++){
                parkingBoy.park(new Car());
            }

            //when
            Ticket ticket = parkingBoy.park(new Car());

            //then
            assertNotNull(ticket);
        }
        catch (ParkingLotException e){
            e.printStackTrace();
        }
    }
}
