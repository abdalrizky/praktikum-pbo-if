package managers;

import java.util.Scanner;

public class BookingManager {

    private final Scanner scanner;
    private final ParkingSlotManager parkingSlotManager;

    public BookingManager(Scanner scanner, ParkingSlotManager parkingSlotManager) {
        this.scanner = scanner;
        this.parkingSlotManager = parkingSlotManager;
    }

    public void showMenu() {
        while (true) {
            System.out.println("[1] Lihat Slot Parkir");
            System.out.println("[2] Reservasi Slot Parkir");
            System.out.println("[0] Kembali ke menu awal");

            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    parkingSlotManager.showParkingSlots();
                    break;
                case 2:
                    reserveParkingSlot();
                    break;
                case 0:
                    return;
            }
        }
    }

    public void reserveParkingSlot() {
        parkingSlotManager.showParkingSlots();

        System.out.print("Masukkan ID Slot Parkir: ");
        String parkingSlotId = scanner.next();

        // Masih data dummy
        String visitorId = "0001";
        String reservationTime = "2025-03-16 09:00:00";

        parkingSlotManager.reserveParkingSlot(parkingSlotId, visitorId, reservationTime);
    }

}
