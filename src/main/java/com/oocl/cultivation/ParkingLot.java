package com.oocl.cultivation;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private int used;
    private final Map<Ticket,Car> parkingRooms = new HashMap<>();

    public Ticket park(Car car){
        if(used >= capacity){
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

    public int getUsed() {
        return parkingRooms.size();
    }
}
