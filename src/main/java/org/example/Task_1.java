package org.example;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TaskNames {
    public static String oddIndexNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(names::get)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        List<String> namesList = List.of("Ivan", "Maria", "Peter", "John", "Olga");

        String result = oddIndexNames(namesList);
        System.out.println(result);
    }
}

