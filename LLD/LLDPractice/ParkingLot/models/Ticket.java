package ParkingLot.models;

public class Ticket {

    private String ticketId;
    private String parkingSpotId;
    private long entryTime;


    public Ticket(String ticketId, String parkingSpotId) {
        this.ticketId = ticketId;
        this.parkingSpotId = parkingSpotId;
        this.entryTime = System.currentTimeMillis();
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public long getEntryTime() {
        return entryTime;
    }
}


//Notes:
//1. Ticket class has ticketId, parkingSpotId and entryTime.
//Ex: ticketdID = "T1", parkingSpotId = "P1", entryTime = some milliseconds

//with this info we cant really caluate the fare ..so calculateFare wont fit here

