package com.oocl.cultivation;

import exception.ParkingLotException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParkingManager{
    private List<Parkable> parkables;

    public ParkingManager(Parkable...parkables) {
        this.parkables = Arrays.asList(parkables);
    }

    public Ticket park(Car car) throws ParkingLotException {
        Optional<Parkable> validParkingLot = parkables.stream().
                filter(parkable -> !parkable.isFull())
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
        for(Parkable parkingLot : parkables){
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
