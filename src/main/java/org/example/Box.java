package org.example;

// T -type typ ogolny - Box<T>, Optional<T>
// E - element kolekcji List<E>, Set<E>
// K, V Key, Value - klucz i wartosc Map<K, V>
// R Result - typ wyniku, Function<T, R>
// ID identyfikator - Repository<T, ID>

public class Box<T> { // <T> parametr typu
    private final T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}
