package com.oocl.cultivation;

import exception.ParkingLotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private final Map<Ticket,Car> parkingRooms = new HashMap<>();

    public Ticket park(Car car){
        if(parkingRooms.size() >= capacity){
            return null;
        }
        Ticket ticket = new Ticket();
        parkingRooms.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket){
        Car car = parkingRooms.get(ticket);
        if(car == null){
           return null;
        }
        parkingRooms.remove(ticket);
        return car;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }
}
