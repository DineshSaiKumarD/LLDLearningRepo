package ParkingLot.service;

import ParkingLot.enums.VehicleType;

public class FeeCalculator {

    private static final double CAR_RATE_PER_HOUR = 10.0;
    private static final double BIKE_RATE_PER_HOUR = 5.0;
    private static final double TRUCK_RATE_PER_HOUR = 20.0;

    public double calculateFee(VehicleType vehicleType, long durationMillis) {
        double hours = durationMillis / (1000.0 * 60 * 60);
        switch (vehicleType) {
            case CAR:
                return hours * CAR_RATE_PER_HOUR;
            case BIKE:
                return hours * BIKE_RATE_PER_HOUR;
            case TRUCK:
                return hours * TRUCK_RATE_PER_HOUR;
            default:
                return 0.0;
        }
    }
}
