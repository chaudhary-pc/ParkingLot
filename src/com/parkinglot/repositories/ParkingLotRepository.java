package com.parkinglot.repositories;

import com.parkinglot.models.Gate;
import com.parkinglot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLots = new HashMap<>();

    public ParkingLot getParkingLotByGate(Gate gate){
        for(ParkingLot parkingLot : parkingLots.values()){
            for(Gate gate1 : parkingLot.getGates()){
                if(Objects.equals(gate1.getId(), gate.getId())){
                    return parkingLot;
                }
            }
        }
        return null;
    }
}
