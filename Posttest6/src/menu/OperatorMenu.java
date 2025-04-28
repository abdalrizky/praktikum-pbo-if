package menu;

import manager.ParkingSlotManager;
import model.Status;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OperatorMenu {

    private final Scanner scanner;
    private final ParkingSlotManager parkingSlotManager;

    public OperatorMenu(Scanner scanner, ParkingSlotManager parkingSlotManager) {
        this.scanner = scanner;
        this.parkingSlotManager = parkingSlotManager;
    }

    public void show() {
        while (true) {
            System.out.println("[1] Lihat Slot Parkir");
            System.out.println("[2] Tambah Slot Parkir");
            System.out.println("[3] Edit Slot Parkir");
            System.out.println("[4] Hapus Slot Parkir");
            System.out.println("[5] Konfirmasi Kedatangan Pengunjung");
            System.out.println("[6] Bebaskan Slot Parkir");
            System.out.println("[0] Kembali ke menu awal");

            System.out.print("Pilih menu: ");

            int choice;

            try {
                choice = scanner.nextInt();
                if (choice < 0 || choice > 6) {
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
                    showParkingSlotMenu();
                    break;
                case 2:
                    parkingSlotManager.addParkingSlot();
                    break;
                case 3:
                    parkingSlotManager.editParkingSlot();
                    break;
                case 4:
                    parkingSlotManager.deleteParkingSlot();
                    break;
                case 5:
                    parkingSlotManager.confirmVisitorArrival();
                    break;
                case 6:
                    parkingSlotManager.releaseParkingSlot();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void showParkingSlotMenu() {
        while (true) {
            System.out.println("[1] Lihat Semua Slot Parkir");
            System.out.println("[2] Lihat Slot Parkir Berdasarkan Tipe");
            System.out.println("[3] Lihat Slot Parkir Berdasarkan Status");
            System.out.println("[0] Kembali");

            System.out.print("Pilih menu: ");

            int choice;

            try {
                choice = scanner.nextInt();
                if (choice < 0 || choice > 3) {
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
                    System.out.print("Masukkan tipe slot parkir: ");
                    String type = scanner.nextLine();
                    parkingSlotManager.showParkingSlots(type);
                    break;
                case 3:
                    System.out.println("Pilih status slot parkir:");

                    for (Status status : Status.values()) {
                        System.out.println("[" + status.ordinal() + "] " + status);
                    }

                    System.out.print("Pilih status: ");
                    int statusChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (statusChoice >= 0 && statusChoice < Status.values().length) {
                        Status status = Status.values()[statusChoice];
                        parkingSlotManager.showParkingSlots(null, status);
                    } else {
                        System.out.println("Status tidak valid.");
                    }
                    break;
                case 0:
                    return;
            }
        }
    }
}
