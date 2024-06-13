package RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx6 {
    public static void main(String[] args) {
        String card = "32564627918273640326911";
        // попытаемся сделать понятный вывод - 03/26 3256 4627 9182 7364 (911)
        
        // Здесь мы в регулярном выражении разбиваем число на группы, группа создается скобками - ()
        // разбили на группы по 4 4 4 4 2 2 3 цифры
        Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
        Matcher matcher = pattern.matcher(card);

        // у Matcher как и у String есть метод replaceAll()
        // передаем в него наши группы с нужным нам расположением пробелов и дополнительными символами / и ()
        // группы начинают счет с 1 и далее, и обозначаются символом $ перед номером группы
        String format = matcher.replaceAll("$5/$6 $1 $2 $3 $4 ($7)");

        System.out.println("Было: " + card);
        System.out.println("Стало: " + format);

        while (matcher.find()) {
            // Если передать аргумент в параметр group() то вернется только переданная в аргумент группа 
            System.out.println(matcher.group(7));
        }
    }
}
