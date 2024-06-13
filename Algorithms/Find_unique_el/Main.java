package Algorithms.Find_unique_el;

// Дан массив int, все эелменты кроме одного повторяются, нужно найти этот уникальынй элемент
// Input nums = [2,2,1]
// Output = 1
// Input nums = [4,1,2,1,2]
// Output = 1
// Input nums = [1]
// Output = 1

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {2, 2, 1};
        int[] arr2 = {4, 1, 2, 1, 2};

        System.out.println(SingleNumber(arr1));
        System.out.println(SingleNumber(arr2));

    }

// Для решения применяем побитовый оператор XOR(исключающее или)
    public static int SingleNumber(int[] nums) {
        int singleNumber = 0;
        for (int num : nums) {
            singleNumber ^= num;
        }
        return singleNumber;
    }
}