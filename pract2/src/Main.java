import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Human> humans = List.of(
                new Human(25, "John", "Doe", LocalDate.of(1999, 5, 15), 70),
                new Human(30, "Jane", "Smith", LocalDate.of(1994, 8, 20), 65),
                new Human(40, "Alice", "Johnson", LocalDate.of(1984, 3, 10), 80),
                new Human(80, "Michael", "Brown", LocalDate.of(1944, 9, 25), 75),
                new Human(62, "Emily", "Williams", LocalDate.of(1962, 12, 10), 60),
                new Human(45, "David", "Taylor", LocalDate.of(1979, 7, 5), 85)
        );

        System.out.println("Исходный список:");
        humans.forEach(System.out::println);

        // Сортировка по последней букве фамилии
        List<Human> sortedByLastName = humans.stream()
                .sorted((h1, h2) -> h1.getLastName().substring(h1.getLastName().length() - 1)
                        .compareToIgnoreCase(h2.getLastName().substring(h2.getLastName().length() - 1)))
                .collect(Collectors.toList());
        System.out.println("\nСписок после сортировки по последней букве фамилии:");
        sortedByLastName.forEach(System.out::println);

        // Фильтрация по признаку «возраст больше, чем вес»
        List<Human> filteredByAgeGreaterThanWeight = humans.stream()
                .filter(human -> human.getAge() > human.getWeight())
                .collect(Collectors.toList());
        System.out.println("\nСписок после фильтрации по признаку «возраст больше, чем вес»:");
        filteredByAgeGreaterThanWeight.forEach(System.out::println);

        // Сортировка по дате рождения
        List<Human> sortedByBirthDate = humans.stream()
                .sorted((h1, h2) -> h1.getBirthDate().compareTo(h2.getBirthDate()))
                .collect(Collectors.toList());
        System.out.println("\nСписок после сортировки по дате рождения:");
        sortedByBirthDate.forEach(System.out::println);

        // Произведение всех возрастов
        long ageProduct = humans.stream()
                .mapToLong(Human::getAge)
                .reduce(1, (a, b) -> a * b);
        System.out.println("\nПроизведение всех возрастов: " + ageProduct);
    }
}
