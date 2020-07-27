package com.oocl.cultivation;

import exception.ParkingLotException;

public interface Parkable {
    Ticket park(Car car) throws ParkingLotException;
    Car fetch(Ticket ticket) throws ParkingLotException;
    boolean isFull();
}
