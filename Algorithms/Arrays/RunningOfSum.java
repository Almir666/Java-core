package Algorithms.Arrays;


// Дан массив чисел. Мы определяем текущую сумму массива как runningSum[i] = sum(nums[0]…nums[i])
// Вернуть текущую сумму чисел

// Example 1:
// Input: nums = [1,2,3,4]
// Output: [1,3,6,10]
// Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4]

// Example 2:
// Input: nums = [1,1,1,1,1]
// Output: [1,2,3,4,5]
// Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1]

public class RunningOfSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] check = runningSum(nums);
        for(int n: check) {
            System.out.print(n +" ");
        }
    }

    public static int[] runningSum(int[] arr) {
        int[] result = new int[arr.length];
        result[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            result[i] = arr[i] + result[i - 1];
        }
        return result;
    }
}
