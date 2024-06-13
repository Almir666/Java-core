package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String s = "1990";
        Pattern pt = Pattern.compile("\\d+");
        Matcher mt = pt.matcher(s);
        System.out.println(mt.matches());
    }
}
