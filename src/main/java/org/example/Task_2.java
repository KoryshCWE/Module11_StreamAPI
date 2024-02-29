package org.example;
import java.util.List;
import java.util.stream.Collectors;

class TaskSortNames {
    public static List<String> uppercaseAndSortDescending(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> namesList = List.of("Ivan", "Maria", "Peter", "John", "Olga");

        List<String> result = uppercaseAndSortDescending(namesList);

        result.forEach(System.out::println);
    }
}
