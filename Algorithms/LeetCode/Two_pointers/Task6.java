package Algorithms.LeetCode.Two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 3Sum

// Задав целочисленный массив nums, верните все тройки [nums[i], nums[j], nums[k]] такие, что i != j, i != k, j != k, и nums[i] + nums[j] + nums[k] == 0.
// Обратите внимание, что множество решений не должно содержать дублирующихся триплетов.

public class Task6 {
    // Итерируемся по всему массиву, следующий элемент после i и последний будут указателями
    // проверяем i на дубликат со следующим элементом
    // проверяем сумму триплета, если она меньше 0 то сдвигаем левый указатель, если больше 0 то правый(массив отсортирован заранее)
    // если же сумма 0 то заносим триплет в результирующий список, и сдвигаем дубликаты
    // проверяем указатели на дубликаты, сдвигаем если следующий элемент дубликат
     public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums [i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0) {
                    left++;
                } 
                else if (sum > 0) {
                    right--;
                } 
                else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[left], nums[right]);
                    ans.add(temp);
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) left++; 
                    while (left < right && nums[right] == nums[right + 1]) right--;     
                    
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
}
