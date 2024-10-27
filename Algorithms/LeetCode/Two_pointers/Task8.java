package Algorithms.LeetCode.Two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 4Sum

// Если задан массив nums из n целых чисел, верните массив всех уникальных квадруплетов [nums[a], nums[b], nums[c], nums[d]] таких, что:
// 0 <= a, b, c, d < n
// a, b, c и d различны.
// nums[a] + nums[b] + nums[c] + nums[d] == tarhet
// Вы можете вернуть ответ в любом порядке.


public class Task8 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            for(int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int rigth = nums.length - 1;
                while (left < rigth) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[rigth];
                    if(sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[rigth]));
                        left++;
                        rigth--;
                    }
                    else if(sum < target) {
                        left++;
                    }
                    else {
                        rigth--;
                    }
                }
            }
        }
        return new ArrayList<>(ans); 
    }

    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(arr, target));
    }
}
