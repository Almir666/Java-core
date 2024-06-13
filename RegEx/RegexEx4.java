package RegEx;

import java.util.regex.Pattern;

public class RegexEx4 {
    void checkIp(String ip) {
        // 250 - 255 | 200 - 249 | 0 - 199   повторяем этот диапозон 3 раза с точкой на конце
        // и последний раз без точки
        String regex = "((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.)){3}(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)";
        System.out.println(ip + " - ip is match? " + Pattern.matches(regex, ip));
    }
    public static void main(String[] args) {
        // 0-255. 0-255. 0-255. 0-255
        String ip1 = "225.38.192.99";
        String ip2 = "182.297.91.05";

        RegexEx4 regex = new RegexEx4();
        regex.checkIp(ip1);
        regex.checkIp(ip2);
    }
}
