package com.oocl.cultivation;

import exception.ParkingLotException;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public Ticket park(Car car) throws ParkingLotException {
        ParkingLot morePosRateLot = null;

        for(ParkingLot parkingLot : parkingLotList){
            if(morePosRateLot == null){
                morePosRateLot = parkingLot;
            }
            if(parkingLot.getAvaliable()/parkingLot.getCapacity() > morePosRateLot.getAvaliable()/morePosRateLot.getCapacity()){
                morePosRateLot = parkingLot;
            }
        }
        Ticket ticket = morePosRateLot.park(car);

        if(ticket == null){
            throw new ParkingLotException("Not enough position.");
        }

        return ticket;
    }
}
