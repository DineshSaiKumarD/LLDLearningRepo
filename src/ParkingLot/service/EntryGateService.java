package ParkingLot.service;

import ParkingLot.models.ParkingSpot;
import ParkingLot.models.Ticket;
import ParkingLot.models.Vehicle;

public class EntryGateService {

    private ParkingLotService parkingLotService;

    public EntryGateService(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        if (parkingLotService.isSpotAvailable(vehicle.getType())) {
            ParkingSpot availableSpot = parkingLotService.findAvailableSpot(vehicle.getType());
            if (availableSpot != null) {
                parkingLotService.assignSpotToVehicle(availableSpot, vehicle);
                return parkingLotService.generateTicket(vehicle, availableSpot);
            }
        }
        return null; // No spot available
    }
}
