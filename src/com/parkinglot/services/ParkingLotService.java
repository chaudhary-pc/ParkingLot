package com.parkinglot.services;

import com.parkinglot.models.Gate;
import com.parkinglot.models.ParkingLot;
import com.parkinglot.repositories.ParkingLotRepository;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }
    public ParkingLot getParkingLotForGate(Gate gate){
        return parkingLotRepository.getParkingLotByGate(gate);
    }
}
