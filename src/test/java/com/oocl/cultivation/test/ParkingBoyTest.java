package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import exception.ParkingLotException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class ParkingBoyTest {
    protected ParkingBoy parkingBoy;
    protected ParkingLot parkingLotA;
    protected ParkingLot parkingLotB;

    @BeforeEach
    public void setup() {
        parkingLotA = new ParkingLot(10);
        parkingLotB = new ParkingLot(10);
        parkingBoy = new ParkingBoy(Arrays.asList(parkingLotA,parkingLotB));
    }

    @Test
    void should_return_ticket_when_customer_given_a_car_to_parkingBoy() {
        try {
            //given
            Car car = new Car();

            //when
            Ticket ticket = parkingBoy.park(car);

            //then
            assertNotNull(ticket);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void should_return_car_when_customer_given_a_ticket_to_parkingBoy() {
        try {
            //given
            Car car = new Car();
            Ticket ticket = parkingBoy.park(car);

            //when
            Car actualCar = parkingBoy.fetch(ticket);

            //then
            assertEquals(car, actualCar);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void should_return_correct_car_when_parkingBoy_given_the_corresponding_ticket() {
        try {
            //given
            Ticket ticketA = parkingBoy.park(new Car());
            Ticket ticketB = parkingBoy.park(new Car());

            //when
            Car carA = parkingBoy.fetch(ticketA);
            Car carB = parkingBoy.fetch(ticketB);

            //then
            assertNotEquals(carA, carB);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void should_return_no_car_when_parkingBoy_given_the_wrong_ticket() {

        try {
            //given
            parkingBoy.park(new Car());

            //when
            Car car = parkingBoy.fetch(new Ticket());

            //then
            assertNull(car);
        } catch (ParkingLotException e) {
            assertEquals("Unrecognized parking ticket.", e.getMessage());
        }
    }

    @Test
    void should_return_no_car_when_parkingBoy_given_the_used_ticket() {
        try {
            //given
            Ticket ticketA = parkingBoy.park(new Car());

            //when
            parkingBoy.fetch(ticketA);
            Car car = parkingBoy.fetch(ticketA);

            //then
            assertNull(car);
        } catch (ParkingLotException e) {
            assertEquals("Unrecognized parking ticket.", e.getMessage());
        }
    }

    @Test
    void should_return_ticket_when_parkingLotA_is_full() {
        try {
            //given
            parkingLotA.setUsed(parkingLotA.getCapacity());

            //when
            Ticket ticket = parkingBoy.park(new Car());

            //then
            assertNotNull(ticket);
        } catch (ParkingLotException e) {
            //then
            e.printStackTrace();
        }
    }

    @Test
    void should_return_error_message_when_customer_give_the_wrong_ticket() {
        try{
            //given
            parkingBoy.park(new Car());

            //when
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
            parkingLotA.setUsed(parkingLotA.getCapacity());
            parkingLotB.setUsed(parkingLotB.getCapacity());

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
            parkingLotA.setUsed(parkingLotA.getCapacity());

            //when
            parkingBoy.park(new Car());

            //then
            assertEquals(1, parkingLotB.getUsed());
        }
        catch (ParkingLotException e){
            e.printStackTrace();
        }
    }

}
