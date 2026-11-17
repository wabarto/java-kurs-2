package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    }
}
