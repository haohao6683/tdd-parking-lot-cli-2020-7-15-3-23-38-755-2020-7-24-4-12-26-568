package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_customer_given_a_car_to_parkingBoy() {
        //given
        ParkingBoy boy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        String ticket = boy.park(car);

        //then
        assertTrue(StringUtils.isNotBlank(ticket));
    }
}
