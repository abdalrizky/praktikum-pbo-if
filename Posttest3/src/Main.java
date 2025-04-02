import manager.BookingManager;
import manager.ParkingSlotManager;
import menu.OperatorMenu;
import menu.VisitorMenu;
import model.ParkingHistory;
import model.ParkingSlot;
import model.Reservation;
import utils.DummyData;
import menu.MainMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<ParkingSlot> parkingSlots = DummyData.loadParkingSlots();
        ArrayList<ParkingHistory> parkingHistories = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();

        ParkingSlotManager parkingSlotManager = new ParkingSlotManager(scanner, parkingSlots, reservations, parkingHistories);
        BookingManager bookingManager = new BookingManager(scanner, parkingSlotManager);

        OperatorMenu operatorMenu = new OperatorMenu(scanner, parkingSlotManager);
        VisitorMenu visitorMenu = new VisitorMenu(scanner, parkingSlotManager, bookingManager);

        MainMenu menu = new MainMenu(scanner, operatorMenu, visitorMenu);
        menu.show();
    }
}
