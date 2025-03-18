package utils;

import managers.BookingManager;
import managers.ParkingSlotManager;

import java.util.Scanner;


public class MainMenu {

    private final Scanner scanner;
    private final ParkingSlotManager parkingSlotManager;
    private final BookingManager bookingManager;

    public MainMenu(Scanner scanner, ParkingSlotManager parkingSlotManager, BookingManager bookingManager) {
        this.scanner = scanner;
        this.parkingSlotManager = parkingSlotManager;
        this.bookingManager = bookingManager;
    }

    public void show() {
        while (true) {
            System.out.println("Pilih Role:");
            System.out.println("-- [1] Operator");
            System.out.println("-- [2] Pengunjung");
            System.out.println("[0] Keluar dari program");

            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    parkingSlotManager.showMenu();
                    break;
                case 2:
                    bookingManager.showMenu();
                    break;
                default:
                    return;
            }
        }
    }
}
