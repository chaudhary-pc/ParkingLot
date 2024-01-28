package com.parkinglot;

import com.parkinglot.controllers.TicketController;
import com.parkinglot.dto.GenerateTicketRequestDto;
import com.parkinglot.dto.GenerateTicketResponseDto;
import com.parkinglot.models.Ticket;
import com.parkinglot.models.VehicleType;
import com.parkinglot.repositories.ParkingLotRepository;
import com.parkinglot.repositories.ParkingSpotRepository;
import com.parkinglot.repositories.VehicleRepository;
import com.parkinglot.services.*;
import com.parkinglot.strategy.RandomSpotAssignmentStrategy;
import com.parkinglot.strategy.SpotAssignmentStrategy;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to Parking Lot Application");

        ObjectContainer objectContainer = new ObjectContainer();
        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        GateService gateService = new GateService();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingSpotService parkingSpotService = new ParkingSpotService(parkingSpotRepository);
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingLotService, parkingSpotService);

        TicketService ticketService = new TicketService(vehicleService, gateService, spotAssignmentStrategy);
        TicketController ticketController = new TicketController(ticketService);


        objectContainer.register("vehicleRepository", vehicleRepository);
        objectContainer.register("vehicleService", vehicleService);
        objectContainer.register("gateService", gateService);
        objectContainer.register("parkingLotRepository", parkingLotRepository);
        objectContainer.register("parkingLotService", parkingLotService);
        objectContainer.register("parkingSpotRepository", parkingSpotRepository);
        objectContainer.register("parkingSpotService", parkingSpotService);
        objectContainer.register("spotAssignmentStrategy", spotAssignmentStrategy);
        objectContainer.register("ticketService", ticketService);
        objectContainer.register("ticketController", ticketController);


        GenerateTicketRequestDto requestDto = new GenerateTicketRequestDto();
        requestDto.setVehicleNumber("DL0001");
        requestDto.setGateId(100L);
        requestDto.setVehicleType(VehicleType.LARGE);

        GenerateTicketResponseDto responseDto = ticketController.generateTicket(requestDto);
        Ticket ticket = responseDto.getTicket();
    }
}