package Algorithms.LeetCode.Two_pointers;

import java.util.Arrays;

// 3Sum Closest

// Учитывая целочисленный массив nums длины n и целое число target, найдите три целых числа в nums, сумма которых наиболее близка к target.
// Верните сумму трех целых чисел.
// Вы можете предположить, что каждый вход будет иметь ровно одно решение.

public class Task7 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int resultSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < Math.abs(target - resultSum)) {
                    resultSum = sum;
                }
                if(sum < target) left++;
                else right--;
            }
        }
        return resultSum;
    }

    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(arr, target));
    }
}
