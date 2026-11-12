package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class NewDemo {
    public static void main(String[] args) {
        // dobrze - gdy typ widac w tej samej linijce
        // nie dla pol, parametrow, typow zwracanych, tylko dla zmiennych lokalnych
        var accounts = new ArrayList<BankAccount>();

        var savingsAccount = new ArrayList<SavingsAccount>();

        // źle
//        var x = repo.findById("PL01");


        // text block
        // przed
        String header = "===\n " + "123" + "\n------";

        System.out.println(header);

        // po
        String header1 = """
                ===
                 123
                ------
                """;

        System.out.println(header1);

        // sealed - typ z zamkniętą listą podtypów


        // punkt wyjscia refleksji Class<?>
        // getClass()
        // SavingsAccount.class, savingAccount.getClass()
        // getDeclaredMethods(), getDeclaredFields() -> isAnnotationPresent(), getAnnotation()




        BankAccount account = new SavingsAccount("PL01", BigDecimal.ZERO, 0.3);

        for (int i = 0; i < 10; i++) {
            account.deposit(BigDecimal.valueOf(0.10));
        }

        System.out.println(account.getBalance());
        System.out.println(account.getBalance().equals(1.0));

        // 0,333333

        // zle
        System.out.println(new BigDecimal(0.1));


        // poprawnie
        System.out.println(new BigDecimal("0.1"));
        System.out.println(BigDecimal.valueOf(0.1));

        BigDecimal a = new BigDecimal("100.50");
        BigDecimal b = new BigDecimal("30.25");

        a.add(b); // 130.75 // dodawanie
        a.subtract(b); // odejmowanie
        a.multiply(b); // mnozenie
        a.remainder(b); // reszta z dzielenia
        a.negate(); // negacja -100.5
        a.abs(); // wartosc bezwzgledna 100.5


        BigDecimal x1 = new BigDecimal("2.3449"); // 0.49
        System.out.println(x1.scale()); // liczba miejsc po przecinku


//        System.out.println(x1.setScale(2, RoundingMode.UP)); // 2.35
//        System.out.println(x1.setScale(2, RoundingMode.DOWN)); // 2.34
//        System.out.println(x1.setScale(2, RoundingMode.CEILING)); // 2.35
//        System.out.println(x1.setScale(2, RoundingMode.FLOOR)); // 2.34
//        System.out.println(x1.setScale(2, RoundingMode.HALF_UP)); // 2.34
//        System.out.println(x1.setScale(2, RoundingMode.HALF_DOWN)); // 2.34
//        System.out.println(x1.setScale(2, RoundingMode.HALF_EVEN)); // 2.34

//        BigDecimal x2 = new BigDecimal("2.3450"); // 0.50
//
//        System.out.println(x2.setScale(2, RoundingMode.UP)); // 2.35
//        System.out.println(x2.setScale(2, RoundingMode.DOWN)); // 2.34
//        System.out.println(x2.setScale(2, RoundingMode.CEILING)); // 2.35
//        System.out.println(x2.setScale(2, RoundingMode.FLOOR)); // 2.34
//        System.out.println(x2.setScale(2, RoundingMode.HALF_UP)); // 2.35
//        System.out.println(x2.setScale(2, RoundingMode.HALF_DOWN)); // 2.34
//        System.out.println(x2.setScale(2, RoundingMode.HALF_EVEN)); // 2.34
//
//        BigDecimal x3 = new BigDecimal("2.34500001"); // 0.51
//
//        System.out.println(x3.setScale(2, RoundingMode.UP)); // 2.35
//        System.out.println(x3.setScale(2, RoundingMode.DOWN)); // 2.34
//        System.out.println(x3.setScale(2, RoundingMode.CEILING)); // 2.35
//        System.out.println(x3.setScale(2, RoundingMode.FLOOR)); // 2.34
//        System.out.println(x3.setScale(2, RoundingMode.HALF_UP)); // 2.35
//        System.out.println(x3.setScale(2, RoundingMode.HALF_DOWN)); // 2.35
//        System.out.println(x3.setScale(2, RoundingMode.HALF_EVEN)); // 2.35
//
//        BigDecimal x4 = new BigDecimal("2.3499"); // 0.99
//
//        System.out.println(x4.setScale(2, RoundingMode.UP)); // 2.35
//        System.out.println(x4.setScale(2, RoundingMode.DOWN)); // 2.34
//        System.out.println(x4.setScale(2, RoundingMode.CEILING)); // 2.35
//        System.out.println(x4.setScale(2, RoundingMode.FLOOR)); // 2.34
//        System.out.println(x4.setScale(2, RoundingMode.HALF_UP)); // 2.35
//        System.out.println(x4.setScale(2, RoundingMode.HALF_DOWN)); // 2.35
//        System.out.println(x4.setScale(2, RoundingMode.HALF_EVEN)); // 2.35
//
//        BigDecimal x5 = new BigDecimal("2.3501"); // 0.01
//
//        System.out.println(x5.setScale(2, RoundingMode.UP));
//        System.out.println(x5.setScale(2, RoundingMode.DOWN)); // 3.15
//        System.out.println(x5.setScale(2, RoundingMode.CEILING)); // 3.15
//        System.out.println(x5.setScale(2, RoundingMode.FLOOR)); // 3.15
//        System.out.println(x5.setScale(2, RoundingMode.HALF_UP)); // 3.14
//        System.out.println(x5.setScale(2, RoundingMode.HALF_DOWN)); // 3.14
//        System.out.println(x5.setScale(2, RoundingMode.HALF_EVEN)); // 3.14
//
        BigDecimal x6 = new BigDecimal("2.3550"); // 0.50

        System.out.println(x6.setScale(2, RoundingMode.UP)); // 2.36
        System.out.println(x6.setScale(2, RoundingMode.DOWN)); // 2.35
        System.out.println(x6.setScale(2, RoundingMode.CEILING)); // 2.36
        System.out.println(x6.setScale(2, RoundingMode.FLOOR)); // 2.35
        System.out.println(x6.setScale(2, RoundingMode.HALF_UP)); // 2.36
        System.out.println(x6.setScale(2, RoundingMode.HALF_DOWN)); // 2.35
        System.out.println(x6.setScale(2, RoundingMode.HALF_EVEN)); // 2.36
//
//        BigDecimal x7 = new BigDecimal("2.3650"); // 0.50
//
//        System.out.println(x7.setScale(2, RoundingMode.UP));
//        System.out.println(x7.setScale(2, RoundingMode.DOWN)); // 3.15
//        System.out.println(x7.setScale(2, RoundingMode.CEILING)); // 3.15
//        System.out.println(x7.setScale(2, RoundingMode.FLOOR)); // 3.15
//        System.out.println(x7.setScale(2, RoundingMode.HALF_UP)); // 3.14
//        System.out.println(x7.setScale(2, RoundingMode.HALF_DOWN)); // 3.14
//        System.out.println(x7.setScale(2, RoundingMode.HALF_EVEN)); // 3.14
//
//
//        System.out.println(new BigDecimal("-7").signum());
//        System.out.println(BigDecimal.ZERO.signum());
//        System.out.println(new BigDecimal("7").signum());
//
//        new BigDecimal("10").divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
//
//
//
//        BigDecimal a1 = new BigDecimal("5.0");
//        BigDecimal a2 = new BigDecimal("5.00");
//
//
//        System.out.println(a1.equals(a2));
//
//        System.out.println(a1.compareTo(a2) == 0);

        long start = System.nanoTime();
        String slow = "";
        for (int i = 0; i < 1000; i++) {
            slow += i;
        }

        long time1 = System.nanoTime() - start;
        start = System.nanoTime();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }

        long time2 = System.nanoTime() - start;

        System.out.println(time1);
        System.out.println(time2);

        savingsAccount.add(new SavingsAccount("PL01", BigDecimal.valueOf(3000), 0.3));

        accounts.add(new SavingsAccount("PL01", BigDecimal.valueOf(3000), 0.3));
        accounts.add(new CheckingAccount("PL03", BigDecimal.valueOf(2000), 5.0));

        System.out.println(accounts);

        Collections.sort(accounts);
//        accounts.sort(null);

        System.out.println(accounts);

        accounts.sort(Comparator.comparing(BankAccount::getBalance));

        savingsAccount.sort(Comparator.comparingDouble(SavingsAccount::getMonthlyCost));

        accounts.sort(Comparator.comparing(BankAccount::getBalance).reversed());


        // 2 kryteria malejaco
        savingsAccount.sort(Comparator
                .comparing(SavingsAccount::getBalance)
                .thenComparingDouble(SavingsAccount::getMonthlyCost)
                .reversed());



        // 1 kryterium rosnaco, a drugie malejaco
        savingsAccount.sort(Comparator
                .comparing(SavingsAccount::getBalance)
                .thenComparing(Comparator.comparingDouble(SavingsAccount::getMonthlyCost).reversed()));



        savingsAccount.sort(Comparator.nullsFirst(Comparator.comparing(SavingsAccount::getBalance)));

        savingsAccount.sort(Comparator.nullsLast(Comparator.comparing(SavingsAccount::getBalance)));

        savingsAccount.sort(Comparator.naturalOrder());



//        Customer customer = new Customer("test", new Address(), new Address());
//        customer.getName();
//        customer.getMailingAddress();

        Customer customer = Customer.builder()
                .name("test")
                .count(15)
                .tag("123")
                .firstName("123")
                .build();

        System.out.println(customer);

        Customer customer1 = customer.withName("123");
        System.out.println(customer1);

        Address address = customer.getMailingAddress();
//        address.getName(); // kompiluje

        Optional<String> o1 = Optional.of("Anna");
        Optional<String> o2 = Optional.ofNullable(customer.getName());
        Optional<String> o3 = Optional.empty();

//        Optional.of(null);


        System.out.println(o1.isPresent());
        System.out.println(o1.isEmpty());

        System.out.println(o1.orElse("123"));
        System.out.println(o3.orElse("brak"));

//        System.out.println(o3.orElseThrow());
//        System.out.println(o3.orElseThrow(() -> new IllegalArgumentException()));

        System.out.println(o3.orElseGet(() -> expensive()));


        o1.ifPresent(o -> System.out.println(o));
        o3.ifPresentOrElse(
                o -> System.out.println(o),
                () -> System.out.println("Nie ma")
        );


        // TAK SIE NIE PISZE

//        if (o1.isPresent()) {
//            o1.get();
//            //
//        }


        System.out.println(o1.map(String::toUpperCase));

        System.out.println(o3.map(String::toUpperCase));


        Optional<BankAccount> bankAccountOptional = Optional.of(new SavingsAccount("PL01", BigDecimal.valueOf(3000), 0.3));

        Optional<BankAccount> active = bankAccountOptional.filter(bankAccount -> bankAccount.getBalance().signum() > 0);

        System.out.println(active);

        Optional<Customer> optionalCustomer = Optional.of(customer1);


//        Optional<String> withMap = optionalCustomer.map(Customer::getSomething);
        // ERROR: Optional<Optional<String>> -> Optional<String>

        Optional<String> withFlatMap = optionalCustomer.flatMap(Customer::getSomething);
        // jesli metoda zwraca Optionala -> flatmap, jesli wartosc to map

        String name = Optional.ofNullable(customer1)
                .flatMap(Customer::getAddress)
                .flatMap(Address::getName)
                .orElse("123");

        // ZlE
        if (Optional.ofNullable(customer1).isPresent()) {
            System.out.println(customer1.getName());
        }


        // DOBRZE
        if (customer1 != null) {
            System.out.println(customer1.getName());
        }
    }

    static String expensive() {
        System.out.println("123");
        //
        //
        //
        return "123";
    }
}
