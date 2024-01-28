package com.parkinglot.controllers;

import com.parkinglot.dto.GenerateTicketRequestDto;
import com.parkinglot.dto.GenerateTicketResponseDto;
import com.parkinglot.exceptions.NoParkingSpotFoundException;
import com.parkinglot.models.ResponseStatus;
import com.parkinglot.models.Ticket;
import com.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) {
        //1.Get the Vehicle from the DB.
        //2. If the Vehicle is there fetch the details, else create the vehicle and store it in the DB.

        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        try {
            Ticket ticket = ticketService.generateTicket(requestDto.getVehicleNumber(), requestDto.getVehicleType(),
                    requestDto.getGateId());
            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (NoParkingSpotFoundException exception) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}