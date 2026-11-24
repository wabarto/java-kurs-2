package org.example;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(List.of(
                new Product("001", "Laptop", new BigDecimal("3999.00"), 5),
                new Product("002", "Mysz", new BigDecimal("100.00"), 40)
        ));

        Stream<String> example = products.stream()
                .filter(p -> {
                    System.out.println("filtering: " + p.sku());
                    return p.stock() > 0;
                })
                .map(p -> {
                    System.out.println("map: " + p.sku());
                    return p.name();
                });


        List<String> names = example.toList();

        Optional<Product> first = products.stream()
                .filter(p -> {
                    System.out.println("Checking: " + p.sku());
                    return p.price().compareTo(new BigDecimal("1000")) > 0;
                })
                .findFirst();


        // z tablicy
        String[] codes = {"001", "002"};
        Arrays.stream(codes).forEach(System.out::println);


        // z konkretnych wartości
        Stream.of("001", "002").forEach(System.out::println);

        // zakres liczb
        IntStream.range(1, 5).forEach(System.out::println); //1234

        IntStream.rangeClosed(1, 5).forEach(System.out::println); //12345

        // ciagi

        Stream.iterate(1, n -> n * 2)
                .limit(8)
                .forEach(n -> System.out.println(n + " ")); // 1, 2, 4, 8, 16, 32, 64, 128

        Stream.generate(Math::random)
                .limit(3)
                .forEach(System.out::println);



        products.stream()
                .filter(p -> p.stock() > 2)
                .forEach(p -> System.out.println(p.name()));

        products.stream()
                .map(Product::name)
                .forEach(System.out::println);


        products.stream()
                .map(Product::name)
                .distinct()
                .forEach(System.out::println);


        products.stream()
                .map(Product::name)
                .sorted()
                .forEach(System.out::println);

        products.stream()
                .sorted(Comparator.comparing(Product::price))
                .forEach(System.out::println);

        products.stream()
                .limit(3)
                .forEach(System.out::println); // pierwsze 3

        products.stream()
                .skip(1)
                .forEach(System.out::println); // pomija pierwsze n elementow - od drugiego

        List<Order> orders = List.of(
                new Order("1", products),
                new Order("2", products)
        );


        Stream<List<Product>> streamList = orders.stream()
                .map(Order::items);


        // ord - 1 -> 001, 002
        // ord - 2 -> 001, 002
        // 001, 002, 001, 002

        // flatMap -> rozwija kazda liste i skleja wszystko w jeden strumien
        List<String> all = orders.stream()
                .flatMap(o -> o.items().stream()) // Stream<Order -> Stream<Product>
                .map(Product::sku)
                .toList();

        System.out.println(all);

















    }
}
