package org.example;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(List.of(
                new Product("001", "Laptop", new BigDecimal("3999.00"), 0, "ELEKTRONIKA"),
                new Product("002", "Mysz", new BigDecimal("100.00"), 40, "INNE"),
                new Product("003", "Mysz", new BigDecimal("100.00"), 0, "INNE"),
                new Product("004", "Mysz", new BigDecimal("100.00"), 40, "INNE"),
                new Product("005", "Mysz", new BigDecimal("100.00"), 0, "INNE"),
                new Product("006", "Mysz", new BigDecimal("100.00"), 40, "INNE")
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



        List<String> result = products.stream()
                .peek(p -> System.out.println(p.sku()))
                .filter(p -> p.stock() > 20)
                .peek(p -> System.out.println(p.sku()))
                .map(Product::name)
                .peek(System.out::println)
                .toList();

        // toList() - immutable
//        result.add("123");

        // count - ile elementow przeszlo przez stream
        long available = products.stream()
                .filter(p -> p.stock() > 0)
                .count();



        Optional<Product> stock0 = products.stream()
                .filter(p -> p.stock() == 0)
                .findFirst();

        System.out.println(stock0);

        Optional<Product> mostExpensive = products.stream()
                .max(Comparator.comparing(Product::price));

        Optional<Product> cheapest = products.stream()
                .min(Comparator.comparing(Product::price));


        Optional<Product> stock = products.stream()
                .filter(p -> p.stock() == 0)
                .findAny();

        System.out.println(stock);

        // findFirst - gwarantuje pierwszy element w kolejnosci zrodla
        // findAny - zwraca dowolny pasujacy

        products.parallelStream()
                .filter(p -> p.stock() == 0)
                .findFirst()
                .ifPresent(p -> System.out.println(p.sku()));

        products.parallelStream()
                .filter(p -> p.stock() == 0)
                .findAny()
                .ifPresent(p -> System.out.println(p.sku()));


        boolean anyMatch = products.stream()
                .anyMatch(p -> p.stock() == 0);

        boolean allMatch = products.stream()
                .allMatch(p -> p.stock() >= 0);

        boolean noneMatch = products.stream()
                .noneMatch(p -> p.stock() == 0);

        System.out.println(anyMatch);
        System.out.println(allMatch);
        System.out.println(noneMatch);


        // z wartoscia poczatkowa
        BigDecimal reduce = products.stream()
                .map(p -> p.price().multiply(BigDecimal.valueOf(p.stock())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        // bez wartosci poczatkowej
        Optional<BigDecimal> highestPrice = products.stream()
                .map(Product::price)
                .reduce(BigDecimal::max);


        Map<String, Long> counter = products.stream()
                .collect(Collectors.groupingBy(Product::category, Collectors.counting()));


        List<String> mutable = products.stream()
                .map(Product::name)
                .collect(Collectors.toList());


        mutable.add("123");

        List<String> immutable1 = products.stream()
                .map(Product::name)
                .collect(Collectors.toUnmodifiableList());

//        immutable1.add("123");


        Set<String> categories = products.stream()
                .map(Product::category)
                .collect(Collectors.toSet());

        TreeSet<String> sortedCategories = products.stream()
                .map(Product::category)
                .collect(Collectors.toCollection(TreeSet::new));

        String list = products.stream()
                .filter(p -> p.stock() == 0)
                .map(Product::name)
                .collect(Collectors.joining(", "));

        System.out.println(list);


        String list1 = products.stream()
                .filter(p -> p.stock() == 0)
                .map(Product::name)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(list1);


        Map<String, String> byCode = products.stream()
                .collect(Collectors.toMap(Product::sku, Product::name));

        System.out.println(byCode);

        // zduplikowane klucze
        Map<String, String> byCategory = products.stream()
                .collect(Collectors.toMap(Product::category, Product::sku, (a, b) -> b));

        System.out.println(byCategory);

        long counter1 = products.stream()
                .collect(Collectors.counting());

        double priceSum = products.stream()
                .collect(Collectors.summingDouble(p -> p.price().doubleValue()));

        double average = products.stream()
                .collect(Collectors.averagingDouble(p -> p.price().doubleValue()));

        DoubleSummaryStatistics statistics = products.stream()
                .collect(Collectors.summarizingDouble(p -> p.price().doubleValue()));

        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());
        System.out.println(statistics.getAverage());

        Map<String, List<Product>> byCategory1 = products.stream()
                .collect(Collectors.groupingBy(Product::category));


        byCategory1.forEach((category, elements) -> System.out.println(category + ": " + elements.size()));



        Map<String, Double> averagePrice = products.stream()
                .collect(Collectors.groupingBy(Product::category, Collectors.averagingDouble(p -> p.price().doubleValue())));


        Map<String, List<String>> names1 = products.stream()
                .collect(Collectors.groupingBy(Product::category, Collectors.mapping(Product::name, Collectors.toList())));

        System.out.println(names1);

        Map<String, Optional<Product>> mostExpensiveProductByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::category,
                        Collectors.maxBy(Comparator.comparing(Product::price))));
        System.out.println(mostExpensiveProductByCategory);


        Map<String, Optional<Product>> cheapestProductByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::category,
                        Collectors.minBy(Comparator.comparing(Product::price))));


        Map<String, String> joinedNames = products.stream()
                .collect(Collectors.groupingBy(Product::category,
                        Collectors.mapping(Product::name, Collectors.joining(", "))));
        System.out.println(joinedNames);


        Map<String, BigDecimal> valueByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::category,
                        Collectors.reducing(BigDecimal.ZERO, Product::price, BigDecimal::add)));

        System.out.println(valueByCategory);


        TreeMap<String, Long> sortedMap = products.stream()
                .collect(Collectors.groupingBy(Product::category, TreeMap::new, Collectors.counting()));

        System.out.println(sortedMap);

        Map<String, Map<Boolean, List<String>>> mapInMap = products.stream()
                .collect(Collectors.groupingBy(Product::category,
                        Collectors.groupingBy(p -> p.stock() > 0, Collectors.mapping(Product::name, Collectors.toList()))));

        System.out.println(mapInMap);

        Map<Boolean, List<Product>> partition = products.stream()
                .collect(Collectors.partitioningBy(p -> p.price().compareTo(new BigDecimal("1000")) > 0));

        Map<Boolean, Long> partitionCount = products.stream()
                .collect(Collectors.partitioningBy(p -> p.price().compareTo(new BigDecimal("1000")) > 0, Collectors.counting()));


        // IntStream, LongStream, DoubleStream
        IntStream stocks = products.stream()
                .mapToInt(Product::stock);


        // dedykowane metody
//        stocks.sum();
//        stocks.average();
//        stocks.max();


        List<Integer> stocksList = products.stream()
                .mapToInt(Product::stock)
                .boxed()
                .toList();


        stocks.mapToObj(i -> i + "str")
                .forEach(System.out::println);


        int sum = products.stream()
                .map(Product::stock)
                .reduce(0, Integer::sum);


        // pulapki
        // streamy sa jednorazowe
        Stream<Product> stream = products.stream();
        long count = stream.count();
        System.out.println(count);

//        List<Product> list2 = stream.toList();


        // skutki uboczne

        // tak nie robimy mimo ze dziala
        List<String> result2 = new ArrayList<>();
        products.stream()
                .filter(p -> p.stock() > 0)
                .forEach(p -> result2.add(p.name()));


        // poprawnie
        List<String> results = products.stream()
                .filter(p -> p.stock() > 0)
                .map(Product::name)
                .toList();





        List<Integer> large = IntStream.rangeClosed(1, 20_000_000).boxed().toList();
        long start = System.nanoTime();
        long sum1 = large.stream().mapToLong(Integer::longValue).sum();

        System.out.println("sekwencyjnie: " + (System.nanoTime() - start));

        start = System.nanoTime();
        long sum2 = large.parallelStream().mapToLong(Integer::longValue).sum();
        System.out.println("rownolegle: " + (System.nanoTime() - start));


//        IntStream.rangeClosed(1, 10_000_000).parallel()











    }
}
