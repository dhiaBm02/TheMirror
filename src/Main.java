import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 10000;
        while (input < 0 || input >= 10000) {
            System.out.println("Bitte eine maximal vierstellige Zahl eingeben:");
            input = Integer.parseInt(scanner.nextLine());
        }


        Number initNumber = new Number(input);
        Mirror mirror = new Mirror(initNumber);
        MirrorPrinter mirrorPrinter = new MirrorPrinter(mirror);

        String choice = "";

        mirrorPrinter.print();

        while (!choice.equalsIgnoreCase("q")) {
            // Display menu options
            System.out.println("Menu:");
            System.out.println("1. 'x' for mirroring on the X-axis");
            System.out.println("2. 'y' for mirroring on the Y-axis");
            System.out.println("3. 'c' to clear the mirror");
            System.out.println("4. 'i' to choose a new number");
            System.out.println("5. 'q/Q' to Quit");
            System.out.print("Enter your choice: ");

            // Read user input
            choice = scanner.nextLine();

            // Handle user input
            switch (choice) {
                case "x":
                    mirror.mirrorX();
                    mirrorPrinter.print();
                    break;
                case "y":
                    mirror.mirrorY();
                    mirrorPrinter.print();
                    break;
                case "c":
                    mirror.clear();
                    mirrorPrinter.print();
                    break;
                case "i":
                    int newInput = 10000;
                    while (newInput < 0 || newInput >= 10000) {
                        System.out.println("Bitte eine maximal vierstellige Zahl eingeben:");
                        newInput = Integer.parseInt(scanner.nextLine());
                    }
                    Number newNumber = new Number(newInput);
                    mirror.setInitNumber(newNumber);
                    mirrorPrinter.print();
                    break;
                case "q":
                case "Q":
                    System.out.println("Exiting the menu. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}