import java.util.List;
import java.util.stream.Collectors;

public class DeviceManager {
    private List<Device> devices;

    public DeviceManager(List<Device> devices) {
        this.devices = devices;
    }

    public void showAllDevices() {
        devices.forEach(System.out::println);
    }

    public void showDevicesByColor(String color) {
        List<Device> result = devices.stream()
            .filter(d -> d.getColor().equalsIgnoreCase(color))
            .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No devices found with color: " + color);
        } else {
            result.forEach(System.out::println);
        }
    }

    public void showDevicesByYear(int year) {
        List<Device> result = devices.stream()
            .filter(d -> d.getYear() == year)
            .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No devices found from year: " + year);
        } else {
            result.forEach(System.out::println);
        }
    }

    public void showDevicesByMinPrice(double minPrice) {
        List<Device> result = devices.stream()
            .filter(d -> d.getPrice() > minPrice)
            .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No devices found more expensive than $" + minPrice);
        } else {
            result.forEach(System.out::println);
        }
    }

    public void showDevicesByType(String type) {
        List<Device> result = devices.stream()
            .filter(d -> d.getType().equalsIgnoreCase(type))
            .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No devices found of type: " + type);
        } else {
            result.forEach(System.out::println);
        }
    }

    public void showDevicesByYearRange(int minYear, int maxYear) {
        List<Device> result = devices.stream()
            .filter(d -> d.getYear() >= minYear && d.getYear() <= maxYear)
            .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No devices found between " + minYear + " and " + maxYear);
        } else {
            result.forEach(System.out::println);
        }
    }
}
