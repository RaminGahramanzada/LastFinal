package az.iktlab.util;

import az.iktlab.dto.FlightDto;
import az.iktlab.model.User;

import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner sc = new Scanner(System.in);

    public static int getMenu() {
        int index = sc.nextInt();
        return index;
        //sc.close();
    }

    public static int getFlightId() {
        System.out.println("Enter flight id:");
        int index = sc.nextInt();
        return index;
      //  sc.close();
    }

    public static FlightDto getFlightData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter destination:");
        String destination = scanner.nextLine();
        System.out.println("Enter date(You have to use this format(yyyy-MM-dd HH:mm:ss))");
        String date = scanner.nextLine();
        System.out.println("Enter count of people:");
        int count = scanner.nextInt();
        return new FlightDto(destination, date, count);
      //  scanner.close();
    }

    public static int geNum() {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        return index;
        //scanner.close();
    }

    public static User getUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter surname");
        String surname = scanner.nextLine();
        return new User(name, surname);
      //  scanner.close();
    }

    public static String getFullName() {
        System.out.print("Enter your full name: ");
        return sc.nextLine();
   //     sc.close();
    }

    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            sc.next();
        }
        sc.close();
        return sc.nextInt();
    }

}