package ParkingLot;

import ParkingLot.enums.VehicleType;
import ParkingLot.models.Vehicle;
import ParkingLot.models.ParkingSpot;
import ParkingLot.models.Ticket;
import ParkingLot.service.ParkingLotService;
import ParkingLot.service.EntryGateService;
import ParkingLot.service.ExitGateService;
import ParkingLot.service.FeeCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotDriver {

    public static void main(String[] args) {
        //create parking spots
        ParkingSpot spot1 = new ParkingSpot("1", VehicleType.CAR);
        ParkingSpot spot2 = new ParkingSpot("2", VehicleType.BIKE);
        ParkingSpot spot3 = new ParkingSpot("3", VehicleType.CAR);
        ParkingSpot spot4 = new ParkingSpot("4", VehicleType.TRUCK);
        ParkingSpot spot5 = new ParkingSpot("5", VehicleType.CAR);
        ParkingSpot spot6 = new ParkingSpot("6", VehicleType.BIKE);
        ParkingSpot spot7 = new ParkingSpot("7", VehicleType.CAR);
        ParkingSpot spot8 = new ParkingSpot("8", VehicleType.TRUCK);
        ParkingSpot spot9 = new ParkingSpot("9", VehicleType.CAR);
        ParkingSpot spot10 = new ParkingSpot("10", VehicleType.BIKE);


        Map<VehicleType, List<ParkingSpot>> parkingSpotsMap = new HashMap<>();
        parkingSpotsMap.put(VehicleType.CAR, new ArrayList<>(Arrays.asList(spot1, spot3, spot5, spot7, spot9)));
        parkingSpotsMap.put(VehicleType.BIKE, new ArrayList<>(Arrays.asList(spot2, spot6, spot10)));
        parkingSpotsMap.put(VehicleType.TRUCK, new ArrayList<>(Arrays.asList(spot4, spot8)));

        //create parking lot
        ParkingLotService parkingLotService = new ParkingLotService(parkingSpotsMap);


        //create vehicle
        Vehicle vehicle1 = new Vehicle("V1", VehicleType.CAR);
        Vehicle vehicle2 = new Vehicle("V2", VehicleType.BIKE);
        Vehicle vehicle3 = new Vehicle("V3", VehicleType.CAR);
        Vehicle vehicle4 = new Vehicle("V4", VehicleType.TRUCK);
        Vehicle vehicle5 = new Vehicle("V5", VehicleType.CAR);
        Vehicle vehicle6 = new Vehicle("V6", VehicleType.BIKE);
        Vehicle vehicle7 = new Vehicle("V7", VehicleType.CAR);
        Vehicle vehicle8 = new Vehicle("V8", VehicleType.TRUCK);
        Vehicle vehicle9 = new Vehicle("V9", VehicleType.CAR);
        Vehicle vehicle10 = new Vehicle("V10", VehicleType.BIKE);


        //create services
        EntryGateService entryGate = new EntryGateService(parkingLotService);
        FeeCalculator feeCalculator = new FeeCalculator();
        ExitGateService exitGate = new ExitGateService(parkingLotService, feeCalculator);

        // Park vehicles
        Ticket ticket1 = entryGate.parkVehicle(vehicle1);
        if (ticket1 != null) {
            System.out.println("Parked " + vehicle1.getId() + " with ticket " + ticket1.getTicketId() + " at spot " + ticket1.getParkingSpotId());
        } else {
            System.out.println("No spot for " + vehicle1.getId());
        }

        Ticket ticket2 = entryGate.parkVehicle(vehicle2);
        if (ticket2 != null) {
            System.out.println("Parked " + vehicle2.getId() + " with ticket " + ticket2.getTicketId() + " at spot " + ticket2.getParkingSpotId());
        }

        // Simulate time passage (in real system, use actual time)
        try {
            Thread.sleep(1000); // 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Unpark vehicle1
        double fee1 = exitGate.unparkVehicle(ticket1);
        System.out.println("Unparked " + vehicle1.getId() + ", fee: $" + fee1);

        // Park another vehicle in the freed spot
        Ticket ticket3 = entryGate.parkVehicle(vehicle3);
        if (ticket3 != null) {
            System.out.println("Parked " + vehicle3.getId() + " with ticket " + ticket3.getTicketId() + " at spot " + ticket3.getParkingSpotId());
        }
    }
}