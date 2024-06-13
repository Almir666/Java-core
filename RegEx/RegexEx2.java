package RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// что бы специальный символ утратил свою силу перед ним нужно поставиить "\\"

// \b граница слова или числа   \\b(Regex)\\b
// \s пробельный символ
// \S НЕ пробельный символ

public class RegexEx2 {
    public static void main(String[] args) {
        String s = "Gwadzabia Luka, Russia, Moscow, Kirovogradskaya street, 15, Flat 47," +
        " email: BoyNextDoor@mail.ru, Postcode: 1423453, Phone number: 1984834543" +
        "Gwadzabia Geyorgiy, Russia, Moscow, Kirovogradskaya street, 69, Flat 12," +
        " email: Zaichenok1488@mail.ru, Postcode: 23423453, Phone number: 234833443" +
        "Chuck Noris, USA, Hollywood, All Stars street, 87, Flat 21," +
        "email: chuck@yandex.ru";

        // Pattern pattern = Pattern.compile("\\w+@\\w+\\.(ru|com)"); 
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.(ru|com)");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
