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
}
