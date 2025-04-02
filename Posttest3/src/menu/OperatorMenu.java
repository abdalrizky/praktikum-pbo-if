package menu;

import manager.ParkingSlotManager;

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

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    parkingSlotManager.showParkingSlots();
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
}
