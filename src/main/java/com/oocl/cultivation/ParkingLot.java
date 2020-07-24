package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket,Car> parkingRooms = new HashMap<>();

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        parkingRooms.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car car = parkingRooms.get(ticket);
        parkingRooms.remove(ticket);
        return car;
    }
}
