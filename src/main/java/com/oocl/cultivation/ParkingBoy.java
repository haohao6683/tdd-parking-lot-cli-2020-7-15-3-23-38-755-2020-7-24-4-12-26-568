package com.oocl.cultivation;

import exception.ParkingLotException;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) throws ParkingLotException{
        return parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) throws ParkingLotException {
        return parkingLot.fetch(ticket);
    }
}
