package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapExample {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("qqq");
        list1.add("ww");
        list1.add("eeeeeeee");
        list1.add("rrrrrr");
        list1.add("a");
        list1.add("ssss");

        // Метод map() возвращает стрим а принимает Function 
        // здесь мы с его помощью преобразовали строки в числа, и с помощью метода collect() преобразовали полученный стрим в List
        // так же можно преобразовывать в другие коллекции
        // все методы stream() не меняют саму коллекцию или массив с которым мы работаем
        List<Integer> list2 = list1.stream().map(e -> e.length()).collect(Collectors.toList());
        System.out.println(list2);

        // Поработаем с массивом
        // Так же вызываем метод stream(), передаем в него массив, затем вызываем метод map() и полделываем в ней нужную нам операцию
        // Затем методом toArray() мы преобразовали поток в массив и переприсвоили нашему изначальному массиву
        int[] arr = {1, 2, 3, 4, 5};
        arr = Arrays.stream(arr).map(e -> {
            if(e % 2 == 0) {
                e = e * 2;
            } return e;
        }).toArray();
        // Изменения произошли, числа кратные 2 умножились на 2
        System.out.println(Arrays.toString(arr));
    }
}
