package Algorithms.LeetCode.Two_pointers;

import java.util.Arrays;

//Find Indices With Index and Value Difference I

// Вам дан индексированный 0 целочисленный массив nums длины n, целое число indexDifference и целое число valueDifference.
// Ваша задача - найти два индекса i и j, оба в диапазоне [0, n - 1], которые удовлетворяют следующим условиям:
// abs(i - j) >= indexDifference, и
// abs(nums[i] - nums[j]) >= valueDifference
// Возвращает целочисленный массив answer, где answer = [i, j], если есть два таких индекса, и answer = [-1, -1] в противном случае. 
// Если существует несколько вариантов двух индексов, верните любой из них.

public class Task3 {
    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + indexDifference; j < nums.length; j++) {
                if(Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,4,1};
        System.out.println(Arrays.toString(findIndices(arr, 2, 4)));
    }
}
