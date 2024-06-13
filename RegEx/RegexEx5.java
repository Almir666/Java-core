package RegEx;

public class RegexEx5 {
    public static void main(String[] args) {
        String s1 = "Random     text,   for          Regex.";
        System.out.println(s1);
        s1 = s1.replaceAll(" {2,}", " ");
        s1 = s1.replaceFirst("R\\w+", "Fuck you!!!");

        System.out.println(s1);
    }
}
