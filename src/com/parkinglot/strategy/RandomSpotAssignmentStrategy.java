package com.parkinglot.strategy;

import com.parkinglot.models.*;
import com.parkinglot.services.ParkingLotService;
import com.parkinglot.services.ParkingSpotService;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    private ParkingLotService parkingLotService;
    private ParkingSpotService parkingSpotService;
    public RandomSpotAssignmentStrategy(ParkingLotService parkingLotService, ParkingSpotService parkingSpotService){
        this.parkingSpotService = parkingSpotService;
        this.parkingLotService = parkingLotService;
    }
    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {
        ParkingLot parkingLot = parkingLotService.getParkingLotForGate(gate);
        List<ParkingSpot> parkingSpotList = parkingSpotService.getParkingSpotsByLot(parkingLot);

        for(ParkingSpot parkingSpot : parkingSpotList){
            if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) &&
            parkingSpot.getSupportedVehicleTypes().contains(vehicleType)){
                return parkingSpot;
            }
        }
        return null;
    }
}
