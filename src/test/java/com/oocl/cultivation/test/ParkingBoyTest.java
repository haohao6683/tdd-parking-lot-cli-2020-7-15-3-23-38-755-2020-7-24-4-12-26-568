package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_customer_given_a_car_to_parkingBoy() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        Ticket ticket = parkingLot.park(car);

        //then
        assertTrue(ticket != null);
    }
}
