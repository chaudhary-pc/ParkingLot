package com.parkinglot.services;

import com.parkinglot.models.ParkingLot;
import com.parkinglot.models.ParkingSpot;
import com.parkinglot.repositories.ParkingSpotRepository;

import java.util.List;

public class ParkingSpotService {
    private ParkingSpotRepository parkingSpotRepository;
    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }
     public List<ParkingSpot> getParkingSpotsByLot(ParkingLot parkingLot){
        return parkingSpotRepository.getParkingSpotForParkingLot(parkingLot);
    }
}
