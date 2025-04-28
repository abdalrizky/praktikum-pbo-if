package menu;

import manager.BookingManager;
import manager.ParkingSlotManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VisitorMenu {

    private final Scanner scanner;
    private final ParkingSlotManager parkingSlotManager;
    private final BookingManager bookingManager;

    public VisitorMenu(Scanner scanner, ParkingSlotManager parkingSlotManager, BookingManager bookingManager) {
        this.scanner = scanner;
        this.parkingSlotManager = parkingSlotManager;
        this.bookingManager = bookingManager;
    }

    public void show() {
        while (true) {
            System.out.println("[1] Lihat Slot Parkir");
            System.out.println("[2] Reservasi Slot Parkir");
            System.out.println("[0] Kembali ke menu awal");

            System.out.print("Pilih menu: ");

            int choice;

            try {
                choice = scanner.nextInt();
                if (choice < 0 || choice > 2) {
                    throw new InputMismatchException();
                }
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Silakan coba lagi.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    parkingSlotManager.showParkingSlots();
                    break;
                case 2:
                    bookingManager.reserveParkingSlot();
                    break;
                case 0:
                    return;
            }
        }
    }
}
