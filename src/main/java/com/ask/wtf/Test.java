package com.ask.wtf;

import java.time.LocalDateTime;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        Function<LocalDateTime, String> function ;

        System.out.println();
    }

    public String setTime (LocalDateTime localDateTime) {
        return localDateTime.toString();
    }
}
