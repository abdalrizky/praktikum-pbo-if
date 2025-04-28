package manager;

import model.ParkingHistory;
import model.ParkingSlot;
import model.Reservation;
import model.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingSlotManager implements IParkingSlotManager {

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

    public final void showParkingSlots() {
        System.out.println("Slot Parkir:");
        for (ParkingSlot parkingSlot : parkingSlots) {
            System.out.println("ID: " + parkingSlot.getId());
            System.out.println("Nama: " + parkingSlot.getName());
            System.out.println("Tipe: " + parkingSlot.getType());
            System.out.println("Status: " + parkingSlot.getStatus());
            System.out.println();
        }
    }

    public final void showParkingSlots(String type) {
        List<ParkingSlot> parkingSlotsFiltered = parkingSlots.stream().filter(slot -> slot.getType().equalsIgnoreCase(type)).toList();
        if (!parkingSlotsFiltered.isEmpty()) {
            System.out.println("Slot Parkir:");
            for (ParkingSlot parkingSlot : parkingSlotsFiltered) {
                System.out.println("ID: " + parkingSlot.getId());
                System.out.println("Nama: " + parkingSlot.getName());
                System.out.println("Tipe: " + parkingSlot.getType());
                System.out.println("Status: " + parkingSlot.getStatus());
                System.out.println();
            }
        } else {
            System.out.println("Tidak ada slot parkir yang sesuai");
        }

    }

    public final void showParkingSlots(String type, Status status) {
        List<ParkingSlot> parkingSlotsFiltered = parkingSlots.stream().filter(slot -> slot.getStatus() == status).toList();
        if (!parkingSlotsFiltered.isEmpty()) {
            System.out.println("Slot Parkir:");
            for (ParkingSlot parkingSlot : parkingSlotsFiltered) {
                System.out.println("Nama: " + parkingSlot.getName());
                System.out.println("Tipe: " + parkingSlot.getType());
                System.out.println("Status: " + parkingSlot.getStatus());
                System.out.println();
            }
        } else {
            System.out.println("Tidak ada slot parkir yang sesuai");
        }
    }

    @Override
    public void addParkingSlot() {
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("Tipe: ");
        String type = scanner.nextLine();

        parkingSlots.add(new ParkingSlot(name, type, Status.AVAILABLE));
        System.out.println("Slot parkir berhasil ditambahkan");
    }

    @Override
    public void editParkingSlot() {
        System.out.print("ID: ");
        String id = scanner.nextLine();

        ParkingSlot parkingSlot = parkingSlots.stream()
            .filter(slot -> slot.getId().equals(id))
            .findFirst()
            .orElse(null);

        if (parkingSlot == null) {
            System.out.println("Slot parkir tidak ditemukan");
            return;
        }

        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("Tipe: ");
        String type = scanner.nextLine();

        parkingSlot.setName(name);
        parkingSlot.setType(type);

        System.out.println("Slot parkir berhasil diubah");
    }

    @Override
    public void deleteParkingSlot() {
        System.out.print("ID: ");
        String id = scanner.nextLine();

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
        String id = scanner.nextLine();

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

    @Override
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

    @Override
    public void releaseParkingSlot() {

        System.out.print("ID Slot Parkir: ");
        String id = scanner.nextLine();

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
