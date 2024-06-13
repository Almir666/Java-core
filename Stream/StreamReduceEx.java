package Stream;

import java.util.ArrayList;
import java.util.List;

public class StreamReduceEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(3);
        list.add(7);
        list.add(9);

        // Метод reduce() возвращает один элемент, в данном случае вернет произведение всех элементов
        // с ним удобно выполнять агрегированные функции
        // сам метот reduce() возвращает Optional, по этому для получения результата мы используем метот get()
        // первый элемент будет присвоен accumulator = 5
        // второй элемент будет присвоен element =     1
        // далее они умножатся, и accumulator, будет присвоен результат умножения 
        // за тем третий элемент будет примсвоен element = 3, и так же он умножится с accumulator
        // и так далее
        int mult = list.stream().reduce((accumulator, element) -> accumulator * element).get();

        // Здесь мы добавляем параметр identity он бдует присвоен accumulator вместо первого элемента
        // по этому тут не может быть null и мы не используем метод get() так как сразу получим инт а не опшанал
        int mult2 = list.stream().reduce(3, (accumulator, element) -> accumulator * element);


        System.out.println(mult2);
        System.out.println(mult);
    }
}
