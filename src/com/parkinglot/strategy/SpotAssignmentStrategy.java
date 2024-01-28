package com.parkinglot.strategy;

import com.parkinglot.models.Gate;
import com.parkinglot.models.ParkingSpot;
import com.parkinglot.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}
