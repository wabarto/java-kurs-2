package org.example;


import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo {
    public static void main(String[] args) {
        List<String> skus = new ArrayList<>();
        skus.add("001");
        skus.add(0, "002");
        skus.addAll(List.of("003", "004"));

        String first = skus.get(0);
        int pos = skus.indexOf("002");
        boolean has = skus.contains("003");

        skus.set(0, "009");
        skus.remove("003");
        skus.remove(2);
        skus.removeIf(s -> s.startsWith("003"));

        skus.size();
        skus.isEmpty();

        // remove(1), remove(Integer.valueOf(10)


        List<String> constants = List.of("001", "002", "003");
//        constants.add("004");

        List<String> changes = new ArrayList<>(List.of("001", "002", "003"));
        changes.add("004");

        List<String> copied = List.copyOf(changes);

        List<String> changes2 = Arrays.asList("123", "124");


        System.out.println(skus);

        // tak nie robimy, nie modyfikujemy podczas iteracji
//        for (String sku : skus) {
//            if (sku.equals("001")) {
//                skus.remove(sku);
//            }
//        }


        // 1
        skus.removeIf(s -> s.equals("001"));

        List<String> toRemove = new ArrayList<>();
//        for (String sku : skus) {
//            if (sku.equals("001")) {
//                toRemove.add(sku);
//            }
//        }

        // 2
        skus.removeAll(toRemove);


        Set<String> categories = new HashSet<>();
        categories.add("ELEKTRONIKA");
        categories.add("SPOZYWCZE");
        categories.add("ELEKTRONIKA");
        categories.add("A");

        System.out.println(categories);

        List<String> duplicates = List.of("A", "B", "A");
        Set<String> uniques = new HashSet<>(duplicates);
        System.out.println(uniques);


        Set<String> sum = new HashSet<>(categories);
        sum.addAll(uniques);
        System.out.println(sum);

        Set<String> common = new HashSet<>(categories);
        common.retainAll(uniques);
        System.out.println(common);

        Set<String> difference = new HashSet<>(categories);
        difference.removeAll(uniques);
        System.out.println(difference);


        Set<String> hash = new HashSet<>(List.of("Bartek", "Adrian", "Kajtek"));
        Set<String> linked = new LinkedHashSet<>(List.of("Bartek", "Adrian", "Kajtek"));
        TreeSet<String> tree = new TreeSet<>(List.of("Bartek", "Adrian", "Kajtek"));

        TreeSet<Integer> numbers = new TreeSet<>(List.of(10, 20, 30, 40, 50));

        System.out.println(hash);
        System.out.println(linked);
        System.out.println(tree);

        System.out.println(tree.first());
        System.out.println(tree.last());
        System.out.println(numbers.floor(30)); // <= 25 najwiekszy
        System.out.println(numbers.ceiling(25)); // >= 25 najmniejszy
        System.out.println(numbers.headSet(30)); // mniejsze niz 30
        System.out.println(numbers.tailSet(30)); // od 30 w gore
        System.out.println(numbers.subSet(20, 40)); // od 20 wlacznie do 40 wylacznie



        Set<String> byLength = new TreeSet<>(Comparator.comparingInt(String::length));
        byLength.add("ABC");
        byLength.add("XYZ");

        System.out.println(byLength);

        // map

        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();


        for (Map<String, Integer> m : List.of(hashMap, linkedHashMap, treeMap)) {
            m.put("003", 5);
            m.put("001", 12);
            m.put("002", 3);
        }

        System.out.println(hashMap);
        System.out.println(linkedHashMap);
        System.out.println(treeMap);


        TreeMap<String, Integer> integerTreeMap = new TreeMap<>();
        integerTreeMap.put("001", 5);
        integerTreeMap.put("002", 8);
        integerTreeMap.put("003", 3);
        integerTreeMap.put("004", 1);


        System.out.println(integerTreeMap.firstKey());
        System.out.println(integerTreeMap.lastKey());
        System.out.println(integerTreeMap.firstEntry());
        System.out.println(integerTreeMap.lastEntry());
        System.out.println(integerTreeMap.floorKey("003")); // najwiekszy klucz <= podanego
        System.out.println(integerTreeMap.ceilingKey("003")); // najmniejszy klucz >= podanego
        System.out.println(integerTreeMap.lowerKey("003")); //  <  klucz od podanego
        System.out.println(integerTreeMap.higherKey("003")); // > klucz od podanego
        System.out.println(integerTreeMap.headMap("003")); // klucze mniejsze
        System.out.println(integerTreeMap.tailMap("003")); // od podanego w gore
        System.out.println(integerTreeMap.subMap("002", "004")); // od wlacznie do wylacznie
        System.out.println(integerTreeMap.descendingMap()); // odwrocona kolejnosc
        System.out.println(integerTreeMap.pollFirstEntry()); // zwraca i usuwa pierwszy wpis



        int x = integerTreeMap.get("002");
        int safe = integerTreeMap.getOrDefault("002", 0);
        integerTreeMap.containsKey("002");
        integerTreeMap.remove("003");
        integerTreeMap.size();

        System.out.println(x);


        integerTreeMap.putIfAbsent("002", 5);
        integerTreeMap.compute("002", (k, v) -> v * 2); // przelicz zawsze
        System.out.println(integerTreeMap);
        integerTreeMap.computeIfPresent("009", (k, v) -> v * 2); // przelicz tylko kiedy istnieje
        integerTreeMap.computeIfAbsent("009", k -> 0); // wstaw tylko gdy klucza nie ma
        System.out.println(integerTreeMap);

        integerTreeMap.merge("002", 3, Integer::sum); // 16 + 3
        System.out.println(integerTreeMap);

        integerTreeMap.replaceAll((k, v) -> v + 100); // modyfikacja wszystkich wartosci
        System.out.println(integerTreeMap);

        integerTreeMap.remove("009", 100); // klucz i wartosc
        System.out.println(integerTreeMap);

        var accounts = new ArrayList<BankAccount>();
        accounts.add(new SavingsAccount("PL01", BigDecimal.valueOf(3000), 0.3));
        accounts.add(new CheckingAccount("PL03", BigDecimal.valueOf(2000), 5.0));


        Map<AccountStatus, List<BankAccount>> byStatus = new HashMap<>();

        for (BankAccount bankAccount : accounts) {
            byStatus.computeIfAbsent(bankAccount.getStatus(), k -> new ArrayList<>()).add(bankAccount);
        }

        System.out.println(byStatus);


        for (Map.Entry<String, Integer> entry : integerTreeMap.entrySet()) {
            System.out.println("klucz: " + entry.getKey() + " wartosc: " + entry.getValue());
        }

        integerTreeMap.forEach((k, v) -> System.out.println("klucz: " + k + " wartosc: " + v));


        for (int value : integerTreeMap.values()) {
            System.out.println(value);
        }

        for (String key : integerTreeMap.keySet()) {
            System.out.println(key);
            // antywzorzec
            // System.out.println(integerTreeMap.get(key));
        }





        Queue<String> orders = new ArrayDeque<>();
        orders.offer("1");
        orders.offer("2");
        orders.offer("3");

        // orders.add() | orders.offer()
        // orders.remove() | orders.poll()
        // orders.element() | orders.peek()


        System.out.println(orders.peek()); // 1 , bez usuwania
        System.out.println(orders.poll()); // 1, usunie
        System.out.println(orders.poll()); // 2, usunie
        System.out.println(orders.poll()); // 3, usunie
        System.out.println(orders.size()); // 0
        System.out.println(orders.peek());


        Deque<String> deque = new ArrayDeque<>();


        // addFirst/offerFirst , addLast/offerLast
        // removeFirst/pollFirst, removeLast/pollLast
        // getFirst/peekFirst, getLast/peekLast

        deque.addFirst("B");
        deque.addLast("C");
        deque.addFirst("A");

        System.out.println(deque.peekFirst()); // A
        System.out.println(deque.peekLast()); // C
        System.out.println(deque.pollFirst()); // A, usunie
        System.out.println(deque.pollLast()); // C, usunie

        // STOS - LIFO za pomoca Deque
        Deque<String> history = new ArrayDeque<>();

        history.push("1"); // addFirst
        history.push("2");
        history.push("3");

        System.out.println(history.pop()); // 3, usunie -> removeFirst
        System.out.println(history.peek()); // 2 -> peekFirst


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(List.of(30, 10, 20, 5));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll() + " ");
        }

        PriorityQueue<String> texts = new PriorityQueue<>(Comparator.comparingInt(String::length));
        texts.addAll(List.of("32", "123", "twetw", "a"));

        while (!texts.isEmpty()) {
            System.out.println(texts.poll() + " ");
        }


        // Collections

        List<Integer> nums = new ArrayList<>(List.of(3, 1, 4, 5, 9, 2, 0));
        Collections.sort(nums);
        Collections.reverse(nums);
        Collections.shuffle(nums);
        Collections.min(nums);
        Collections.max(nums);
        Collections.frequency(nums, 1);
        Collections.swap(nums, 0, 1);
        List<String> empty = Collections.emptyList();
        List<String> copies = Collections.nCopies(5, "x");
        System.out.println(empty);
        System.out.println(copies);
        Collections.disjoint(Set.of("A", "B"), Set.of("C", "D")); // true

        List<String> view = Collections.unmodifiableList(skus);


        // wielowatkowosc

        Map<String, Integer> values = new ConcurrentHashMap<>();

        // Collections.synchronizedList() // blokada calej kolekcji przy kazdej operacji,
        List<String> values1 = new CopyOnWriteArrayList<>(); // kazdy zapis tworzy nowa kopie tablicy -> duzo odczytow, malo zapisow

    }
}
