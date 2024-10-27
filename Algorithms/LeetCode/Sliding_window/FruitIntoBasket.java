package Algorithms.LeetCode.Sliding_window;

import java.util.HashMap;
import java.util.Map;

// Fruit Into Baskets

// Вы посещаете ферму, где в один ряд слева направо высажены фруктовые деревья. Деревья представлены целочисленным массивом fruits, где fruits[i] - это тип фрукта, который производит i-е дерево.
// Вы хотите собрать как можно больше фруктов. Однако у хозяина есть строгие правила, которым вы должны следовать:
// У вас есть только две корзины, и каждая корзина может содержать только один вид фруктов. Количество фруктов в каждой корзине не ограничено.
// Начиная с любого дерева по вашему выбору, вы должны собрать ровно по одному фрукту с каждого дерева (включая стартовое), двигаясь при этом вправо. Собранные фрукты должны поместиться в одну из ваших корзин.
// Как только вы достигнете дерева с фруктами, которые не могут поместиться в ваши корзины, вы должны остановиться.
// Учитывая целочисленный массив fruits, верните максимальное количество фруктов, которое вы можете собрать.


// Так как у нас две корзины, в качестве корзин используем HashMap
// Заносим каждый фрукт в корзину, сам фрукт ключ, значение текущий индекс
// если фрукт уже присутствует то ключ с самим фрутком обновляем и в значение попадает новый индекс 
// заносим новые фрукты по ка их не более двух видов 
// если попадается третий вид то вычисляем по значению(индексу) и удаляем его, сдвигаем указатель на следующий индекс после удаленного фрукта а новый заносим в корзину
// вконце кажой итерации подсчитываем колличество фруктов(расстояние между указателями + 1)

public class FruitIntoBasket {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        int lenght = fruits.length;
        int right = 0;
        int left = 0;
        for(; right < lenght; right++) {
            if(map.containsKey(fruits[right])) {
                map.put(fruits[right], right);
            }
            else if(map.size() < 2) {
                map.put(fruits[right], right);
            }
            else {
                int min = lenght + 1;
                int minFruit = lenght + 1;
                for(int value : map.keySet()) {
                    if(min > map.get(value)) {
                        min = map.get(value);
                        minFruit = value;
                    }
                }
                left = min + 1;
                map.remove(minFruit);
                map.put(fruits[right], right);
            }
            total = Math.max(total, right - left + 1);
        } 
        return total;
    }

    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        System.out.println(totalFruit(fruits));
    }
}
