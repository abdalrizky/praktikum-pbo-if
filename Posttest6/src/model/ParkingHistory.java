package model;

public class ParkingHistory {
    private final String id;
    private final String parkingSlotId;
    private final String visitorId;
    private final String arrivalTime;
    private String departureTime;

    public ParkingHistory(String parkingSlotId, String visitorId, String arrivalTime) {
        this.id = generateId();
        this.parkingSlotId = parkingSlotId;
        this.visitorId = visitorId;
        this.arrivalTime = arrivalTime;
    }

    public String getId() {
        return id;
    }

    public String getParkingSlotId() {
        return parkingSlotId;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    private String generateId() {
        String uuid = java.util.UUID.randomUUID().toString().replace("-", "");
        return uuid.substring(0, 10);
    }
}
