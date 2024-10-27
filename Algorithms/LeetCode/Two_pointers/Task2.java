package Algorithms.LeetCode.Two_pointers;

//Count the Number of Incremovable Subarrays I

// Вам дан массив целых положительных чисел nums с индексом 0.
// Подмассив nums называется инкрементным, если при удалении подмассива nums становится строго возрастающим. Например, 
// подмассив [3, 4] является инкрементным подмассивом  массива [5, 3, 4, 6, 7], так как при удалении этого подмассива массив [5, 3, 4, 6, 7] 
// меняется на [5, 6, 7], который является строго возрастающим.
// Верните общее количество увеличивающихся подмассивов массива nums.
// Обратите внимание, что пустой массив считается строго возрастающим.
// Подмассив - это непрерывная непустая последовательность элементов внутри массива.

public class Task2 {
    public static int incremovableSubarrayCount(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (task(nums, i, j))
                    ans++;
            }
        }
        return ans;
    }

    static boolean task(int[] nums, int start, int end) {
        for (int i = 0; i < start - 1; i++) {
            if (nums[i] >= nums[i + 1])
                return false;
        }
        if (start > 0 && end < nums.length - 1 && nums[start - 1] >= nums[end + 1])
            return false;

        for (int i = end + 1; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int nums[] = {8,7,6,6};
        System.out.println(incremovableSubarrayCount(nums));
    }
}
