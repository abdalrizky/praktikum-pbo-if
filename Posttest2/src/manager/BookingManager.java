package manager;

import java.util.Scanner;

public class BookingManager {

    private final Scanner scanner;
    private final ParkingSlotManager parkingSlotManager;

    public BookingManager(Scanner scanner, ParkingSlotManager parkingSlotManager) {
        this.scanner = scanner;
        this.parkingSlotManager = parkingSlotManager;
    }

    public void reserveParkingSlot() {
        parkingSlotManager.showParkingSlots();

        System.out.print("Masukkan ID Slot Parkir: ");
        String parkingSlotId = scanner.nextLine();

        // Masih data dummy
        String visitorId = "0001";
        String reservationTime = "2025-03-16 09:00:00";

        parkingSlotManager.reserveParkingSlot(parkingSlotId, visitorId, reservationTime);
    }

}
