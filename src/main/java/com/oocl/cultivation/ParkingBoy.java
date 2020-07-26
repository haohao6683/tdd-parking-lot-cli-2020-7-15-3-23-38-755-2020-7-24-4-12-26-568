package com.oocl.cultivation;

import exception.ParkingLotException;
import java.util.List;

public class ParkingBoy {
    protected List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) throws ParkingLotException{
        Ticket ticket = null;

        for(ParkingLot parkingLot : parkingLotList){
            if(!parkingLot.isFull()){
                ticket = parkingLot.park(car);
                break;
            }
        }

        if(ticket == null){
            throw new ParkingLotException("Not enough position.");
        }

        return ticket;
    }

    public Car fetch(Ticket ticket) throws ParkingLotException {
        if(ticket == null){
            throw new ParkingLotException("Please provide your parking ticket.");
        }

        Car car = null;
        for(ParkingLot parkingLot : parkingLotList){
            car = parkingLot.fetch(ticket);
            if (car != null) {
                break;
            }
        }

        if(car == null){
            throw new ParkingLotException("Unrecognized parking ticket.");
        }

        return car;
    }
}
