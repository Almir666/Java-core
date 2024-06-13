package Classes.StringBuilder;

public class Main {
    public static void main(String[] args) {
        StringBuilder str1 = new StringBuilder("Test");
        StringBuilder str2 = new StringBuilder("Some");
        StringBuilder str3 = new StringBuilder("Text");

        // Методы:

        System.out.println(str1.charAt(2));

        System.out.println(str1.insert(1, "eee"));

        str1.setCharAt(2, 'S');
        System.out.println(str1);

        System.out.println(str1.append(str2.append(str3)));

        System.out.println(str1.replace(7, 15, "TextSome"));

        System.out.println(str1.delete(2, 13));

        System.out.println(str1.reverse());

        
    }
}
