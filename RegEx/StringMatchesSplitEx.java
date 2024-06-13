package RegEx;

import java.util.Arrays;

public class StringMatchesSplitEx {
    public static void main(String[] args) {
        String s = "Gwadzabia Luka, Russia, Moscow, Kirovogradskaya street, 15, Flat 47," +
        " email: BoyNextDoor@mail.ru, Postcode: 1423453, Phone number: 1984834543" +
        "Gwadzabia Geyorgiy, Russia, Moscow, Kirovogradskaya street, 69, Flat 12," +
        " email: Zaichenok1488@mail.ru, Postcode: 23423453, Phone number: 234833443" +
        "Chuck Noris, USA, Hollywood, All Stars street, 87, Flat 21," +
        "email: chuck@yandex.ru";

        String s2 = "BoyNextDoor@mail.ru";
        // String.matches() принимает в себя Regex и возвращает true если найдет совпадение
        // его использую тогда когда нужно найти одно соответствие регулярному выражению
        boolean result = s2.matches("\\w+@\\w+\\.(ru|com)");
        System.out.println("result: " + result);

        String [] arr1 = s.split(" ");
        System.out.println(Arrays.toString(arr1));
    }
}

