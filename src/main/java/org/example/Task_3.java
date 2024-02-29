package org.example;
import java.util.Arrays;
import java.util.stream.Collectors;

class TaskThree {
    public static void main(String[] args) {
        String[] arr = {"1, 2, 0", "4, 5"};

        String result = Arrays.stream(arr)
                .flatMap(str -> Arrays.stream(str.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}