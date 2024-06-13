package Enums;

import java.util.Arrays;

public class EnumsTest {
    public static void main(String[] args) {
        // метод values() возвращает массив констант которые пренадлежат данному enum
        Enums[] testEnum = Enums.values();
        // valueOf() позволяет нам создат enum из String 
        Enums testEnumOf = Enums.valueOf("THREE");

        System.out.println(Arrays.toString(testEnum));
        System.out.println(testEnumOf);
    }    
}

enum Enums {
    ONE, 
    TWO,
    THREE,
    FOUR,
    FIVE
}
