package Algorithms.LeetCode.Two_pointers;

import java.util.Arrays;

// Minimum Average of Smallest and Largest Elements

// У вас есть массив чисел с плавающей точкой averages, который изначально пуст. Вам дан массив nums из n целых чисел, где n - четное.
// Вы повторяете следующую процедуру n / 2 раз:
// Удалите из nums наименьший элемент minElement и наибольший элемент maxElement.
// Добавьте (minElement + maxElement) / 2 к средним значениям.
// Верните минимальный элемент в усредненных значениях.

public class Task1 {

    // Медленное решение
    public static double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int min = 0;
        int max = nums.length - 1;
        double[] res = new double[nums.length / 2];
        while (min < nums.length / 2) {
            res[min] = (double)(nums[min] + nums[max]) / 2;
            min++;
            max--;
        }
        return Arrays.stream(res).min().getAsDouble();
    }

    // Решение побыстрее
    public static double minAverage(int[] nums) {
        // Так же сортируем массив, и бежим с начала и от конца, в результирующую переменную записываем каждую промежуточную сумму, 
        // если новая сумма меньше чем предыдущая то перезаписываем результат
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        double min = nums[j];
        while(i < nums.length / 2) {
            double sum = (nums[i] + nums[j]) / 2.0;
            if(min > sum) {
                min = sum;
            }
            i++;
            j--;
        }
        return min;
    }
    public static void main(String[] args) {
        int nums[] = {7,8,3,4,15,13,4,1};

        System.out.println(minAverage(nums));
    }
}
