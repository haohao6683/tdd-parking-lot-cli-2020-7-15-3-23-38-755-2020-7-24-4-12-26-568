package com.oocl.cultivation;

import exception.ParkingLotException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public Ticket park(Car car) throws ParkingLotException {
        
        Optional<ParkingLot> validParkingLot = parkingLotList.stream().
                filter(parkingLot -> !parkingLot.isFull())
                .max(Comparator.comparingInt(ParkingLot :: getAvaliable));

        if(validParkingLot.isPresent()){
            return validParkingLot.get().park(car);
        }
        else{
            throw new ParkingLotException("Not enough position.");
        }
    }
}
