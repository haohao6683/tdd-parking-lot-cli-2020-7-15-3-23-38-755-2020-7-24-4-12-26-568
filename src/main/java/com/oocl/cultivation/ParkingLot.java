package com.oocl.cultivation;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private int used = 0;

    public void setUsed(int used) {
        this.used = used;
    }

    private final Map<Ticket,Car> parkingRooms = new HashMap<>();

    public Ticket park(Car car){
        if(used >= capacity){
            return null;
        }
        Ticket ticket = new Ticket();
        parkingRooms.put(ticket,car);
        used++;
        capacity--;
        return ticket;
    }

    public Car fetch(Ticket ticket){
        Car car = parkingRooms.get(ticket);
        if(car == null){
           return null;
        }
        used--;
        capacity++;
        parkingRooms.remove(ticket);
        return car;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
    }

    public int getUsed() {
        return used;
    }
}
