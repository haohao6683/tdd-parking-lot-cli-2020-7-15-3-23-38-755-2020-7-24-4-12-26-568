package com.oocl.cultivation;

import exception.ParkingLotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity = 10;
    private final Map<Ticket,Car> parkingRooms = new HashMap<>(10);

    public Ticket park(Car car) {
        if(parkingRooms.size() >= capacity){
            return null;
        }
        Ticket ticket = new Ticket();
        parkingRooms.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket) throws ParkingLotException {
        Car car = parkingRooms.get(ticket);
        if(car == null){
            throw new ParkingLotException("Unrecognized parking ticket.");
        }
        parkingRooms.remove(ticket);
        return car;
    }
}
