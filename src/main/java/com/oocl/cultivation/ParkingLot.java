package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity = 10;
    private Map<Ticket,Car> parkingRooms = new HashMap<>(10);

    public Ticket park(Car car) {
        if(parkingRooms.size() >= capacity){
            return null;
        }
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
