import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Projector> projectors = Arrays.asList(
            new Projector("Epson EB-1795F", 2022, 1299.99, "Epson"),
            new Projector("BenQ TH685", 2021, 899.99, "BenQ"),
            new Projector("Sony VPL-VW295ES", 2020, 4999.99, "Sony"),
            new Projector("ViewSonic PX747-4K", 2023, 799.99, "ViewSonic"),
            new Projector("Optoma HD28HDR", 2019, 679.99, "Optoma"),
            new Projector("LG CineBeam HU70LA", 2022, 1599.99, "LG"),
            new Projector("Epson Home Cinema 2250", 2023, 999.99, "Epson"),
            new Projector("BenQ TK850i", 2023, 1399.99, "BenQ"),
            new Projector("Sony VPL-HW45ES", 2018, 1999.99, "Sony"),
            new Projector("ViewSonic PJD7828HDL", 2021, 549.99, "ViewSonic")
        );

        ProjectorManager manager = new ProjectorManager(projectors);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Show all projectors");
            System.out.println("2. Show projectors by manufacturer");
            System.out.println("3. Show projectors of the current year");
            System.out.println("4. Show projectors more expensive than price");
            System.out.println("5. Show projectors sorted by price (ascending)");
            System.out.println("6. Show projectors sorted by price (descending)");
            System.out.println("7. Show projectors sorted by year (ascending)");
            System.out.println("8. Show projectors sorted by year (descending)");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                switch (choice) {
                    case 1:
                        manager.showAllProjectors();
                        break;
                    case 2:
                        System.out.print("Enter manufacturer: ");
                        String manufacturer = scanner.nextLine();
                        manager.showProjectorsByManufacturer(manufacturer);
                        break;
                    case 3:
                        manager.showProjectorsByCurrentYear();
                        break;
                    case 4:
                        System.out.print("Enter minimum price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();
                        manager.showProjectorsByMinPrice(price);
                        break;
                    case 5:
                        manager.showProjectorsSortedByPriceAscending();
                        break;
                    case 6:
                        manager.showProjectorsSortedByPriceDescending();
                        break;
                    case 7:
                        manager.showProjectorsSortedByYearAscending();
                        break;
                    case 8:
                        manager.showProjectorsSortedByYearDescending();
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}
