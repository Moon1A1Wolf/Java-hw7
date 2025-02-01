import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ProjectorManager {
    private List<Projector> projectors;

    public ProjectorManager(List<Projector> projectors) {
        this.projectors = projectors;
    }

    public void showAllProjectors() {
        projectors.forEach(System.out::println);
    }

    public void showProjectorsByManufacturer(String manufacturer) {
        List<Projector> result = projectors.stream()
            .filter(p -> p.getManufacturer().equalsIgnoreCase(manufacturer))
            .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No projectors found from manufacturer: " + manufacturer);
        } else {
            result.forEach(System.out::println);
        }
    }

    public void showProjectorsByCurrentYear() {
        int currentYear = java.time.Year.now().getValue();
        List<Projector> result = projectors.stream()
            .filter(p -> p.getYear() == currentYear)
            .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No projectors found from the current year (" + currentYear + ")");
        } else {
            result.forEach(System.out::println);
        }
    }

    public void showProjectorsByMinPrice(double minPrice) {
        List<Projector> result = projectors.stream()
            .filter(p -> p.getPrice() > minPrice)
            .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No projectors found more expensive than $" + minPrice);
        } else {
            result.forEach(System.out::println);
        }
    }

    public void showProjectorsSortedByPriceAscending() {
        projectors.stream()
            .sorted(Comparator.comparingDouble(Projector::getPrice))
            .forEach(System.out::println);
    }

    public void showProjectorsSortedByPriceDescending() {
        projectors.stream()
            .sorted(Comparator.comparingDouble(Projector::getPrice).reversed())
            .forEach(System.out::println);
    }

    public void showProjectorsSortedByYearAscending() {
        projectors.stream()
            .sorted(Comparator.comparingInt(Projector::getYear))
            .forEach(System.out::println);
    }

    public void showProjectorsSortedByYearDescending() {
        projectors.stream()
            .sorted(Comparator.comparingInt(Projector::getYear).reversed())
            .forEach(System.out::println);
    }
}
