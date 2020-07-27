package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import exception.ParkingLotException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Spliterator;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {
    protected ParkingLot parkingLot;
    ParkingManager parkingManager;

    @BeforeEach
    public void setup() {
        parkingLot = new ParkingLot(10);
        parkingManager = new ParkingManager(new ParkingBoy(Arrays.asList(parkingLot)));
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

            //when
            Ticket ticket = parkingManager.park(car);

            //then
            assertNotNull(ticket);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void should_return_car_when_customer_given_a_ticket_to_parkingManager() {
        try {
            //given
            Car car = new Car();
            Ticket ticket = parkingManager.park(car);;

            //when
            Car actualCar = parkingManager.fetch(ticket);

            //then
            assertEquals(car, actualCar);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void should_return_error_message_when_customer_give_the_wrong_ticket() {
        try{
            //given
            parkingManager.park(new Car());

            //when
            parkingManager.fetch(new Ticket());
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
            parkingManager.park(new Car());

            //when
            parkingManager.fetch(null);
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
            ParkingLot parkingLotA = new ParkingLot(10);
            ParkingLot parkingLotB = new ParkingLot(10);
            parkingLotA.setUsed(parkingLotA.getCapacity());
            parkingLotB.setUsed(parkingLotB.getCapacity());

            //when
            parkingManager.park(new Car());
        }
        catch (ParkingLotException e){
            //then
            assertEquals("Not enough position.", e.getMessage());
        }
    }

    @Test
    void should_park_car_when_parkingManager_manage_parkingLot_and_the_other_boy(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(1)));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(1)));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot(1)));
        ParkingManager parkingManagerA = new ParkingManager(parkingBoy,smartParkingBoy,superSmartParkingBoy,parkingLot);

        try {
            //when
            Ticket ticketA = parkingManagerA.park(new Car());
            Ticket ticketB = parkingManagerA.park(new Car());
            Ticket ticketC = parkingManagerA.park(new Car());

            //then
            assertNotNull(ticketA);
            assertNotNull(ticketB);
            assertNotNull(ticketC);

        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }
}
