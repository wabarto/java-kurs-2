package org.example;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilesDemo {
    public static void main(String[] args) throws IOException {
        List<Product> products = new ArrayList<>(List.of(
                new Product("001", "Laptop", new BigDecimal("3999.00"), 0, "ELEKTRONIKA"),
                new Product("002", "Mysz", new BigDecimal("100.00"), 40, "INNE"),
                new Product("003", "Mysz", new BigDecimal("100.00"), 0, "INNE"),
                new Product("004", "Mysz", new BigDecimal("100.00"), 40, "INNE"),
                new Product("005", "Mysz", new BigDecimal("100.00"), 0, "INNE"),
                new Product("006", "Mysz", new BigDecimal("100.00"), 40, "INNE")
        ));

        Path file = Path.of("date", "raporty", "sprzedaz.csv");
        System.out.println(file);

        System.out.println(file.getFileName());
        System.out.println(file.getNameCount());
        System.out.println(file.getParent());
        System.out.println(file.toAbsolutePath());

        Path dir = Path.of("date");
        Path result = dir.resolve("output.json");
        System.out.println(result);

        Path from = Path.of("/home/user");
        Path to = Path.of("/home/user/date/file.txt");

        System.out.println(from.relativize(to));

        Files.createDirectories(Path.of("date"));
        Files.writeString(Path.of("date/produkty.txt"), "Laptop\nMysz\nKlawiatura\n");

        String whole = Files.readString(Path.of("date/produkty.txt"));
        System.out.println(whole.lines().count());

        List<String> lines = Files.readAllLines(Path.of("date/produkty.txt"));
        System.out.println(lines.get(0));


        try (Stream<String> stream = Files.lines(Path.of("date/produkty.txt"))) {
            long count = stream.
                    filter(l -> l.contains("Laptop"))
                    .count();
            System.out.println(count);
        }

        Files.writeString(Path.of("date/produkty.txt"), "test", StandardOpenOption.APPEND);

        List<String> rows = products.stream()
                .map(p -> p.sku() + ", " + p.name() + ", " + p.price())
                .toList();

        Files.write(Path.of("date/produkty.csv"), rows);

        Files.write(Path.of("date/stary.csv"), rows, Charset.forName("windows-1250"));

        String text = Files.readString(Path.of("date/stary.csv"), Charset.forName("windows-1250"));

        // domyslnie UTF-8


        System.out.println(Files.exists(Path.of("date/produkty.txt")));
        System.out.println(Files.isDirectory(Path.of("date")));
        System.out.println(Files.isRegularFile(Path.of("date/produkty.txt")));
        System.out.println(Files.size(Path.of("date/produkty.txt")));
//        Files.createDirectory(Path.of("date/archiwum")); // 1 poziom
//        Files.createDirectories(Path.of("date/1/11/111")); // wiele poziomow


//        Files.copy(Path.of("date/produkty.txt"), Path.of("date/archiwum/produkty.txt"), StandardCopyOption.REPLACE_EXISTING);
//
//        Files.move(Path.of("date/produkty.txt"), Path.of("date/1/produkty.txt"));

//        Files.delete(Path.of("date/archiwum/test.txt"));
        Files.deleteIfExists(Path.of("date/archiwum/test.txt"));


        try (Stream<Path> entries = Files.list(Path.of("date"))) {
            entries.filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .forEach(System.out::println);
        }

        try (Stream<Path> entries = Files.walk(Path.of("date"), 4)) {
            entries.filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .forEach(System.out::println);
        }


        try (BufferedReader reader = Files.newBufferedReader(Path.of("date/produkty.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        try (Stream<String> stream = Files.lines(Path.of("date/produkty.txt"))) {
            stream.forEach(System.out::println);
        }


        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("date/result.txt"))) {
            writer.write("123");
            writer.newLine();
        }


        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Path.of("date/tabela.txt")))) {
            pw.printf("%-20s %10s%n", "PRODUKT", "CENA");
            pw.println("-".repeat(31));

        }

        try (InputStream in = Files.newInputStream(Path.of("date/zdjecie.png"));
            OutputStream out = Files.newOutputStream(Path.of("date/snapshot.png"))) {
            byte[] bytes = new byte[8192];
            int read;
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        }



    }
}
