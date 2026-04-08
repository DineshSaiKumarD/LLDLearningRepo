package ParkingLot.service;

import ParkingLot.models.ParkingSpot;
import ParkingLot.models.Ticket;
import ParkingLot.models.Vehicle;

public class ExitGateService {

    private ParkingLotService parkingLotService;
    private FeeCalculator feeCalculator;

    public ExitGateService(ParkingLotService parkingLotService, FeeCalculator feeCalculator) {
        this.parkingLotService = parkingLotService;
        this.feeCalculator = feeCalculator;
    }

    public double unparkVehicle(Ticket ticket) {
        // Find the spot by ticket
        ParkingSpot spot = findSpotByTicket(ticket);
        if (spot != null && spot.isOccupied()) {
            parkingLotService.releaseSpot(spot);
            long exitTime = System.currentTimeMillis();
            long duration = exitTime - ticket.getEntryTime();
            return feeCalculator.calculateFee(spot.getSpotType(), duration);
        }
        return 0.0; // Error or no vehicle
    }

    private ParkingSpot findSpotByTicket(Ticket ticket) {
        return parkingLotService.getSpotByTicket(ticket);
    }
}

//notes;
//1. how i decided the resbonsibilities of this class?
// exit gate collects the ticket from the driver and
// calculates the fee based on the duration of parking and the type of spot.
// It also needs to release the spot once the vehicle leaves.
// Hence, it has two main responsibilities...
// 1.handling the exit process and 2.calculating the fee.
//so it must interact with parkinglotservice to unpark the vehicle and also needs farecalculator service to calculate the fee.
//2. how i decided the methods of this class?
//the unparkvehicle method can be there in parkinglotservice but i decided to keep it here
// because it is more related to the exit process and fee calculation.
//and also parkinglot service dont have fee calculation logic so it is better to keep it here insetaf ofpasing fare logic to parkinglot service
//
// .