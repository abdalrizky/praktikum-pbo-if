package utils;

import model.ParkingSlot;
import model.Status;

import java.util.ArrayList;

public class DummyData {
    public static ArrayList<ParkingSlot> loadParkingSlots() {
        ArrayList<ParkingSlot> parkingSlots = new ArrayList<>();

        parkingSlots.add(new ParkingSlot("A201", "Motor", Status.AVAILABLE));
        parkingSlots.add(new ParkingSlot("A202", "Motor", Status.AVAILABLE));
        parkingSlots.add(new ParkingSlot("A203", "Motor", Status.AVAILABLE));
        parkingSlots.add(new ParkingSlot("B104", "Mobil", Status.AVAILABLE));
        parkingSlots.add(new ParkingSlot("B105", "Mobil", Status.AVAILABLE));
        parkingSlots.add(new ParkingSlot("B106", "Mobil", Status.AVAILABLE));

        return parkingSlots;
    }
}
