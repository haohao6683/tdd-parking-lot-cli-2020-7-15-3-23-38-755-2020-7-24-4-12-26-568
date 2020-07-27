package com.oocl.cultivation;

import exception.ParkingLotException;
import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    protected List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) throws ParkingLotException{
        Optional<ParkingLot> validParkingLot = parkingLotList.stream().
                                        filter(parkingLot -> !parkingLot.isFull())
                                        .findFirst();

        if(validParkingLot.isPresent()){
            return validParkingLot.get().park(car);
        }
        else{
            throw new ParkingLotException("Not enough position.");
        }
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
