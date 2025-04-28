package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner;
    private final OperatorMenu operatorMenu;
    private final VisitorMenu visitorMenu;

    public MainMenu(Scanner scanner, OperatorMenu operatorMenu, VisitorMenu visitorMenu) {
        this.scanner = scanner;
        this.operatorMenu = operatorMenu;
        this.visitorMenu = visitorMenu;
    }

    public void show() {
        while (true) {
            System.out.println("Pilih Role:");
            System.out.println("-- [1] Operator");
            System.out.println("-- [2] Pengunjung");
            System.out.println("[0] Keluar dari program");

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
                    operatorMenu.show();
                    break;
                case 2:
                    visitorMenu.show();
                    break;
                default:
                    return;
            }
        }
    }
}
