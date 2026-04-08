package ParkingLot.service;

import ParkingLot.enums.VehicleType;
import ParkingLot.models.Ticket;
import ParkingLot.models.Vehicle;
import ParkingLot.models.ParkingSpot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotService {

    private Map<VehicleType , List<ParkingSpot>> availableSpots ;
    private Map<String, ParkingSpot> ticketToSpot = new HashMap<>();
    private int ticketCounter = 1;

    //constructor
    public ParkingLotService(Map<VehicleType, List<ParkingSpot>> availableSpots) {
        this.availableSpots = availableSpots;
    }


    //find the avaibale spot for the vehicle

    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        List<ParkingSpot> spots = availableSpots.get(vehicleType);
        if (spots != null && !spots.isEmpty()) {
            return spots.get(0); // Return the first available spot
        }
        return null; // No available spot for this vehicle type
    }


    public void assignSpotToVehicle(ParkingSpot spot, Vehicle vehicle) {
        spot.assignVehicle(vehicle);
        availableSpots.get(spot.getSpotType()).remove(spot); // Remove the spot from available spots
    }

    public void releaseSpot(ParkingSpot spot) {
        spot.removeVehicle();
        availableSpots.get(spot.getSpotType()).add(spot); // Add the spot back to available spots
    }


    public boolean isSpotAvailable(VehicleType vehicleType) {
        List<ParkingSpot> spots = availableSpots.get(vehicleType);
        return spots != null && !spots.isEmpty();
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot spot) {
        // Generate a ticket for the parked vehicle
        Ticket ticket = new Ticket(String.valueOf(ticketCounter++), spot.getSpotId());
        ticketToSpot.put(ticket.getTicketId(), spot);
        return ticket;
    }

    public ParkingSpot getSpotByTicket(Ticket ticket) {
        return ticketToSpot.get(ticket.getTicketId());
    }
}
