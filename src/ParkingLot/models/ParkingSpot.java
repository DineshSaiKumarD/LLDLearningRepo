package ParkingLot.models;

import ParkingLot.enums.VehicleType;

public class ParkingSpot {

    private String spotId;
    private boolean isOccupied;
    private VehicleType spotType; // e.g., CAR, BIKE, TRUCK
    private Vehicle vehicle;

    public ParkingSpot(String spotId, VehicleType spotType) {
        this.spotId = spotId;
        this.isOccupied = false;
        this.spotType = spotType;
    }

    public String getSpotId() {
        return spotId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    //we can alos check whether the vehicle type can fit this place or not
        public boolean canFitVehicle(Vehicle vehicle) {
            if (this.spotType == VehicleType.CAR && vehicle.getType() == VehicleType.CAR) {
                return true;
            } else if (this.spotType == VehicleType.BIKE && vehicle.getType() == VehicleType.BIKE) {
                return true;
            } else if (this.spotType == VehicleType.TRUCK && vehicle.getType() == VehicleType.TRUCK) {
                return true;
            }
            return false;
        }
}

//notes :
//this class has below data members :
//ex: spot id : 1, is occupied : false, spot type : car, vehicle : null
//so with this data what can we do Wwith this data ?? ---> this idea will provide
// the responsibilities or functions of this class :

//1. assignVehicle(Vehicle vehicle) : this function will assign a vehicle to this parking spot and mark it as occupied.
//2. removeVehicle() : this function will remove the vehicle from this park ing spot and mark it as unoccupied.
//3. canFitVehicle(Vehicle vehicle) : this function will check whether the given vehicle