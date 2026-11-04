package org.example;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // jak dlugo zyje adnotacja
@Target({ElementType.METHOD, ElementType.TYPE}) // gdzie wolno jej uzyc
public @interface Audited {
    String value() default "NORMAL";
    boolean logAmount() default false;
}
