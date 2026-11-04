package org.example;

import java.lang.reflect.Method;

public class AuditScanner {
    public static void scan(Class<?> clazz) {

        // 1. Adnotacja na klasie
        if (clazz.isAnnotationPresent(Audited.class)) {
            Audited ann = clazz.getAnnotation(Audited.class);
            System.out.println("Klasa " + clazz.getSimpleName() + " - " + ann.value());
        }

        // 2. Adnotacje na metodach
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Audited.class)) {
                Audited ann = method.getAnnotation(Audited.class);
                System.out.println(method.getName() + " - " + ann.value() + " - " + ann.logAmount());
            }

        }
    }

    public static void main(String[] args) {
        scan(SavingsAccount.class);
        scan(BankAccount.class);

        // spring
        // isAnnotationPresent(Component.class)
    }
}
