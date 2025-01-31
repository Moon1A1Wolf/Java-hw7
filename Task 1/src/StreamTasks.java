import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Random;

public class StreamTasks {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = IntStream.generate(() -> random.nextInt(2000) - 1000)
                .limit(30)
                .boxed()
                .collect(Collectors.toList());

        long positiveCount = numbers.stream()
                .filter(n -> n > 0)
                .count();

        long negativeCount = numbers.stream()
                .filter(n -> n < 0)
                .count();

        long twoDigitCount = numbers.stream()
                .filter(n -> {
                    int absN = Math.abs(n);
                    return absN >= 10 && absN <= 99;
                })
                .count();

        long palindromicCount = numbers.stream()
                .filter(n -> {
                    String original = Integer.toString(n);
                    String reversed = new StringBuilder(original).reverse().toString();
                    return original.equals(reversed);
                })
                .count();

        System.out.println("Сгенеровані числа:");
        String numbersString = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(numbersString + "\n");

        System.out.println("Кількість додатних: " + positiveCount);
        System.out.println("Кількість від'ємних: " + negativeCount);
        System.out.println("Кількість двозначних: " + twoDigitCount);
        System.out.println("Кількість дзеркальних: " + palindromicCount);
    }
}