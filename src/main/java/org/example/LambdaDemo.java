package org.example;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class LambdaDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(List.of(
                new Product("001", "Laptop", new BigDecimal("3999.00"), 5),
                new Product("002", "Mysz", new BigDecimal("100.00"), 40)
        ));


        products.sort((Product x, Product y) -> x.price().compareTo(y.price()));

        products.sort((x, y) -> x.price().compareTo(y.price()));

        // p -> p.price()
        // () -> "stala"


        Predicate<Product> valid = p -> {
            if (p.sku() == null) {
                return false;
            }

            return !p.name().isBlank();
        };


        Supplier<String> timestamp = () -> LocalDateTime.now().toString();


        BigDecimal limit = new BigDecimal("1000");
        Predicate<Product> expensive = p -> p.price().compareTo(limit) > 0;
//        limit = new BigDecimal("2000");


        List<String> list = new ArrayList<>();
        Consumer<Product> b = p -> list.add(p.sku());

        b.accept(new Product("001", "Laptop", new BigDecimal("3999.00"), 5));
        b.accept(new Product("002", "Mysz", new BigDecimal("100.00"), 40));
        System.out.println(list);

        Product laptop = new Product("001", "Laptop", new BigDecimal("3999.00"), 5);


        Function<Product, String> toName = p -> p.name();
        System.out.println(toName.apply(laptop));

        Predicate<Product> inStock = p -> p.stock() > 0;
        System.out.println(inStock.test(laptop));

        Consumer<Product> print = p -> System.out.println(p.name());
        print.accept(laptop);

        Supplier<String> id = () -> "id";
        System.out.println(id.get());


        BiFunction<BigDecimal, Integer, BigDecimal> total = (price, qty) -> price.multiply(BigDecimal.valueOf(qty));
        System.out.println(total.apply(new BigDecimal("19.99"), 3));

        BiPredicate<Product, Integer> canFulfill = (p, qty) -> p.stock() >= qty;
        System.out.println(canFulfill.test(laptop, 3));


        BiConsumer<String, Integer> printEntry = (sku, qty) -> System.out.println(sku + "-" + qty);
        printEntry.accept("001", 3);


        Function<String, String> upper1 = s -> s.toUpperCase();
        UnaryOperator<String> upper2 = s -> s.toUpperCase();


        // Function<String, String, String>
        BinaryOperator<String> upper3 = (x, y) -> x.toUpperCase();



        Function<Integer, Integer> square = x -> x * x;
        IntUnaryOperator squareFast = x -> x * x;

        // IntPredicate, IntConsumer, IntSupplier, IntFunction, ToIntFunction, IntUnaryOperator
        // IntBinaryOperator, IntToDoubleFunction, IntToLongFunction

        // referencje do metody
        // metoda statyczna
        Function<String, Integer> parse = Integer::parseInt; // x -> Integer.parseInt(x)


        // metody konkretnego obiektu
        PrintStream out = System.out;
        Consumer<String> print1 = out::println;

        Consumer<String> toList = list::add;

        // metoda dowolnego obiektu danego typu
        Function<Product, String> toName1 = Product::name;


        // konstruktor
        Supplier<List<Product>> newList = ArrayList::new;
        Function<String, BigDecimal> toMoney = BigDecimal::new;


        // nie da sie uzyc referencji
        Function<Product, String> toName2 = p -> p.name().toUpperCase();


        // kompozycja funkcji

        // andThen
        Function<Product, BigDecimal> price = Product::price;
        Function<BigDecimal, BigDecimal> withVat = p -> p.multiply(new BigDecimal("1.23"));
        Function<BigDecimal, String> format = p -> String.format("%.2f zł ", p);

        Function<Product, String> priceLabel = price.andThen(withVat).andThen(format);

        System.out.println(priceLabel.apply(laptop));

        Function<BigDecimal, BigDecimal> minusTen = p -> p.subtract(new BigDecimal("10"));


        // compose - dziala odwrotnie niz andThen()
        withVat.andThen(minusTen).apply(new BigDecimal("100")); // (100 * 1.23) - 10 = 113
        withVat.compose(minusTen).apply(new BigDecimal("100")); // (100 - 10) * 1.23 =  90 * 1.23


        // identity - zwraca argument bez zmian
        Function<Product, Product> asIs = Function.identity();
        System.out.println(asIs.apply(laptop) == laptop);

        Function<BigDecimal, BigDecimal> discount = 1 > 0 ? p -> p.multiply(new BigDecimal("0.9")) : Function.identity();





















    }
}
