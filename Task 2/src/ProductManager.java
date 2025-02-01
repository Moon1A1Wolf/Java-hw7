import java.util.*;

public class ProductManager {
    private static final Map<String, String> PRODUCT_CATEGORIES = Map.ofEntries(
        Map.entry("Milk", "milk"),        Map.entry("Cheese", "milk"),      Map.entry("Yogurt", "milk"),
        Map.entry("Apple", "fruit"),      Map.entry("Banana", "fruit"),     Map.entry("Orange", "fruit"),
        Map.entry("Carrot", "vegetable"), Map.entry("Potato", "vegetable"), Map.entry("Tomato", "vegetable"),
        Map.entry("Chicken", "meat"),     Map.entry("Salmon", "meat"),      Map.entry("Beef", "meat"),
        Map.entry("Rice", "grains"),      Map.entry("Wheat", "grains"),      Map.entry("Oats", "grains"),   
        Map.entry("Juice", "drinks"),     Map.entry("Water", "drinks"),     Map.entry("Tea", "drinks")
    );

    public static void main(String[] args) {
        List<String> products = Arrays.asList(
                "Milk", "Cheese", "Yogurt", "Carrot", "Potato", "Tomato",
                "Apple", "Banana", "Orange", "Beef", "Chicken", "Salmon",
                "Rice", "Oats", "Wheat", "Water", "Juice", "Tea", "Milk", "Cheese"
        );
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Show all products");
            System.out.println("2. Show products with names shorter than 5 characters");
            System.out.println("3. Count occurrences of a product");
            System.out.println("4. Show products starting with a specific letter");
            System.out.println("5. Show products from \"milk\" category");
            System.out.println("0. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> showAllProducts(products);
                case 2 -> showShortNamedProducts(products);
                case 3 -> countProductOccurrences(products, scanner);
                case 4 -> showProductsByLetter(products, scanner);
                case 5 -> showMilkCategory();
                case 0 -> {
                    System.out.println("Exiting program.");
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void showAllProducts(List<String> products) {
        products.stream().distinct().forEach(System.out::println);
    }

    private static void showShortNamedProducts(List<String> products) {
        List<String> result = products.stream()
                .filter(p -> p.length() < 5)
                .distinct()
                .toList();
        
        if (result.isEmpty()) {
            System.out.println("No products found with less than 5 characters.");
        } else {
            result.forEach(System.out::println);
        }
    }

    private static void countProductOccurrences(List<String> products, Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        long count = products.stream().filter(p -> p.equalsIgnoreCase(name)).count();
        System.out.println(count > 0 ? name + " appears " + count + " times." : "Product not found.");
    }

    private static void showProductsByLetter(List<String> products, Scanner scanner) {
        System.out.print("Enter the starting letter: ");
        String letter = scanner.nextLine().toLowerCase();
        List<String> result = products.stream()
                .filter(p -> p.toLowerCase().startsWith(letter))
                .distinct()
                .toList();
        
        if (result.isEmpty()) {
            System.out.println("No products found starting with " + letter + ".");
        } else {
            result.forEach(System.out::println);
        }
    }

    private static void showMilkCategory() {
        String category = "milk";
        List<String> result = PRODUCT_CATEGORIES.entrySet().stream()
                .filter(entry -> entry.getValue().equalsIgnoreCase(category))
                .map(Map.Entry::getKey)
                .toList();
        
        if (result.isEmpty()) {
            System.out.println("No products found in category " + category + ".");
        } else {
            result.forEach(System.out::println);
        }
    }
}
