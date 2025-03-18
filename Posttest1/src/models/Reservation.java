package models;

public class Reservation {
    private final String id;
    private final String visitorId;
    private final String parkingSlotId;
    private final String reservationTime;

    public Reservation(String visitorId, String parkingSlotId, String reservationTime) {
        this.id = generateId();
        this.visitorId = visitorId;
        this.parkingSlotId = parkingSlotId;
        this.reservationTime = reservationTime;
    }

    public String getId() {
        return id;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public String getParkingSlotId() {
        return parkingSlotId;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    private String generateId() {
        return "R" + (int) (Math.random() * 1000);
    }
}
