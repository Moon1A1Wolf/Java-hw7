import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Device> devices = Arrays.asList(
            new Device("iPhone 12", 2020, 799.99, "Black", "Smartphone"),
            new Device("MacBook Pro", 2021, 1299.99, "Silver", "Laptop"),
            new Device("Samsung Galaxy S21", 2021, 699.99, "Blue", "Smartphone"),
            new Device("Dell XPS 13", 2019, 999.99, "White", "Laptop"),
            new Device("Sony PlayStation 5", 2020, 499.99, "White", "Gaming Console"),
            new Device("iPad Air", 2022, 599.99, "Black", "Tablet"),
            new Device("Xbox Series X", 2020, 499.99, "Black", "Gaming Console"),
            new Device("Google Pixel 6", 2021, 599.99, "Black", "Smartphone"),
            new Device("Lenovo ThinkPad", 2018, 899.99, "Black", "Laptop"),
            new Device("Asus ROG Phone", 2021, 1099.99, "Red", "Smartphone")
        );

        DeviceManager manager = new DeviceManager(devices);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Show all devices");
            System.out.println("2. Show devices by color");
            System.out.println("3. Show devices by year");
            System.out.println("4. Show devices more expensive than price");
            System.out.println("5. Show devices by type");
            System.out.println("6. Show devices by year range");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    manager.showAllDevices();
                    break;
                case 2:
                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();
                    manager.showDevicesByColor(color);
                    break;
                case 3:
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    manager.showDevicesByYear(year);
                    break;
                case 4:
                    System.out.print("Enter minimum price: ");
                    double price = scanner.nextDouble();
                    manager.showDevicesByMinPrice(price);
                    break;
                case 5:
                    System.out.print("Enter device type: ");
                    String type = scanner.nextLine();
                    manager.showDevicesByType(type);
                    break;
                case 6:
                    System.out.print("Enter min year: ");
                    int minYear = scanner.nextInt();
                    System.out.print("Enter max year: ");
                    int maxYear = scanner.nextInt();
                    manager.showDevicesByYearRange(minYear, maxYear);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
