package managers;

import models.ParkingHistory;
import models.ParkingSlot;
import models.Reservation;
import models.Status;

import java.util.ArrayList;
import java.util.Scanner;

public class ParkingSlotManager {

    private final Scanner scanner;
    private final ArrayList<ParkingSlot> parkingSlots;
    private final ArrayList<Reservation> reservations;
    private final ArrayList<ParkingHistory> parkingHistories;

    public ParkingSlotManager(Scanner scanner, ArrayList<ParkingSlot> parkingSlots, ArrayList<Reservation> reservations, ArrayList<ParkingHistory> parkingHistories) {
        this.scanner = scanner;
        this.parkingSlots = parkingSlots;
        this.reservations = reservations;
        this.parkingHistories = parkingHistories;
    }

    public void showMenu() {
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

            switch (choice) {
                case 1:
                    showParkingSlots();
                    break;
                case 2:
                    addParkingSlot();
                    break;
                case 3:
                    editParkingSlot();
                    break;
                case 4:
                    deleteParkingSlot();
                    break;
                case 5:
                    confirmVisitorArrival();
                    break;
                case 6:
                    releaseParkingSlot();
                    break;
                case 0:
                    return;
            }
        }
    }

    public void showParkingSlots() {
        System.out.println("Slot Parkir:");
        for (ParkingSlot parkingSlot : parkingSlots) {
            System.out.println("ID: " + parkingSlot.getId());
            System.out.println("Nama: " + parkingSlot.getName());
            System.out.println("Tipe: " + parkingSlot.getType());
            System.out.println("Status: " + parkingSlot.getStatus());
            System.out.println();
        }
    }

    public void addParkingSlot() {
        System.out.print("Nama: ");
        String name = scanner.next();
        System.out.print("Tipe: ");
        String type = scanner.next();

        parkingSlots.add(new ParkingSlot(name, type, Status.AVAILABLE));
        System.out.println("Slot parkir berhasil ditambahkan");
    }

    public void editParkingSlot() {
        System.out.print("ID: ");
        String id = scanner.next();

        ParkingSlot parkingSlot = parkingSlots.stream()
            .filter(slot -> slot.getId().equals(id))
            .findFirst()
            .orElse(null);

        if (parkingSlot == null) {
            System.out.println("Slot parkir tidak ditemukan");
            return;
        }

        System.out.print("Nama: ");
        String name = scanner.next();
        System.out.print("Tipe: ");
        String type = scanner.next();

        parkingSlot.setName(name);
        parkingSlot.setType(type);

        System.out.println("Slot parkir berhasil diubah");
    }

    public void deleteParkingSlot() {
        System.out.print("ID: ");
        String id = scanner.next();

        ParkingSlot parkingSlot = parkingSlots.stream()
            .filter(slot -> slot.getId().equals(id))
            .findFirst()
            .orElse(null);

        if (parkingSlot == null) {
            System.out.println("Slot parkir tidak ditemukan");
            return;
        }

        parkingSlots.remove(parkingSlot);

        System.out.println("Slot parkir berhasil dihapus");
    }

    // Proses pada beberapa fungsi di bawah belum sepenuhnya selesai, jadi mohon diabaikan saja
    public void confirmVisitorArrival() {
        System.out.print("ID Slot Parkir: ");
        String id = scanner.next();

        ParkingSlot parkingSlot = parkingSlots.stream()
            .filter(slot -> slot.getId().equals(id))
            .findFirst()
            .orElse(null);

        Reservation visitorReservation = reservations.stream()
                .filter(reservation -> reservation.getParkingSlotId().equals(id))
                .findFirst()
                .orElse(null);

        if (parkingSlot == null) {
            System.out.println("Slot parkir tidak ditemukan");
            return;
        }

        if (visitorReservation == null) {
            System.out.println("Belum ada pengunjung yang reservasi slot parkir ini");
            return;
        }

        parkingHistories.add(new ParkingHistory(visitorReservation.getParkingSlotId(), visitorReservation.getVisitorId(), visitorReservation.getReservationTime()));
        parkingSlot.setStatus(Status.CLAIMED);
    }

    public void reserveParkingSlot(String parkingSlotId, String visitorId, String reservationTime) {
        ParkingSlot parkingSlot = parkingSlots.stream()
            .filter(slot -> slot.getId().equals(parkingSlotId))
            .findFirst()
            .orElse(null);

        if (parkingSlot == null) {
            System.out.println("Slot parkir tidak ditemukan");
            return;
        }

        if (parkingSlot.getStatus() == Status.RESERVED || parkingSlot.getStatus() == Status.CLAIMED) {
            System.out.println("Slot parkir tidak tersedia");
            return;
        }

        Reservation reservation = new Reservation(visitorId, parkingSlotId, reservationTime);
        reservations.add(reservation);

        parkingSlot.setStatus(Status.RESERVED);

        System.out.println("Slot parkir berhasil direservasi");
    }

    public void releaseParkingSlot() {

        System.out.print("ID Slot Parkir: ");
        String id = scanner.next();

        ParkingSlot parkingSlot = parkingSlots.stream()
            .filter(slot -> slot.getId().equals(id))
            .findFirst()
            .orElse(null);

        if (parkingSlot == null) {
            System.out.println("Slot parkir tidak ditemukan");
            return;
        }

        if (parkingSlot.getStatus() == Status.AVAILABLE) {
            System.out.println("Slot parkir masih tersedia");
            return;
        }

        parkingSlot.setStatus(Status.AVAILABLE);

        System.out.println("Slot parkir berhasil dibebaskan");

    }
}
