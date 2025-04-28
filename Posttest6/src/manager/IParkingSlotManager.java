package manager;

public interface IParkingSlotManager {
    void addParkingSlot();
    void editParkingSlot();
    void deleteParkingSlot();
    void reserveParkingSlot(String parkingSlotId, String visitorId, String reservationTime);
    void releaseParkingSlot();
}
