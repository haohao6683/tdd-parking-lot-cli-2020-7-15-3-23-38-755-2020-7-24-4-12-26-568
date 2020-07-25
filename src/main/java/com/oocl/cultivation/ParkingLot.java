package com.oocl.cultivation;

import exception.ParkingLotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity = 10;
    private final Map<Ticket,Car> parkingRooms = new HashMap<>(10);

    public Ticket park(Car car) throws ParkingLotException {
        if(parkingRooms.size() >= capacity){
            throw new ParkingLotException("Not enough position.");
        }
        Ticket ticket = new Ticket();
        parkingRooms.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket) throws ParkingLotException {
        if(ticket == null){
            throw new ParkingLotException("Please provide your parking ticket.");
        }
        Car car = parkingRooms.get(ticket);
        if(car == null){
            throw new ParkingLotException("Unrecognized parking ticket.");
        }
        parkingRooms.remove(ticket);
        return car;
    }
}
