package com.parkinglot.services;

import com.parkinglot.models.Vehicle;
import com.parkinglot.models.VehicleType;
import com.parkinglot.repositories.VehicleRepository;

public class VehicleService {
    private VehicleRepository vehicleRepository;
    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    public Vehicle getVehicle(String vehicleNumber){
        return vehicleRepository.getVehicleFromVehicleNumber(vehicleNumber);
    }
    public Vehicle registerVehicle(String vehicleNumber, VehicleType vehicleType){
        return null;
    }
}
