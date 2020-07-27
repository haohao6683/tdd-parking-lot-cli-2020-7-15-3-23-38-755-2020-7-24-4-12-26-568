package com.oocl.cultivation;

import exception.ParkingLotException;

import java.util.List;

//todo 还要把story6实现
public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public Ticket park(Car car) throws ParkingLotException {
        //todo 看能不能不用下面这个比较的对象
        ParkingLot morePosLot = null;

        for(ParkingLot parkingLot : parkingLotList){
            if(morePosLot == null){
                morePosLot = parkingLot;
            }
            if(parkingLot.getUsed() < morePosLot.getUsed()){
                morePosLot = parkingLot;
            }
        }
        Ticket ticket = morePosLot.park(car);

        if(ticket == null){
            throw new ParkingLotException("Not enough position.");
        }

        return ticket;
    }
}
