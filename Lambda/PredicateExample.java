package Lambda;

import java.util.ArrayList;

public class PredicateExample {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("qqq");
        al.add("wwww");
        al.add("eeeee");
        al.add("rrrrrr");

        // Метод коллекции ArrayList removeIf(Predicate p); принимает предикат, 
        // в нашем случае мы удалили из коллекции элементы которые длинее 5 символов
        // В общем и целом Predicate проверяет на условие, проходит эелемент проверку на true или нет
        // Его основной метод: boolean test(T t)
        // Предикат содержит логические методы:
        // and() "p1.and(p2)" - логическое и
        // or() - логическое или
        // negate() - отрицание
        al.removeIf(e -> e.length() > 5);

        System.out.println(al);
    }
}
