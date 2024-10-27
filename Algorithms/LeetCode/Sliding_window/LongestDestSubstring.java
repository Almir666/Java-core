package Algorithms.LeetCode.Sliding_window;

import java.util.HashSet;
import java.util.Set;

// Longest Substring Without Repeating Characters

// Дана строка s, найдите длину самой длинной подстроки без повторяющихся символов.

public class LongestDestSubstring {
    // Используем скользящее окно, длина окна в нашем случае изначально будет равно
    // 0,
    // и будет расширяться пока расширяется строка с уникальными символами
    // левая граница left стоит на месте, правая right будет бежать по длине
    // строки(цикла)
    // Так как строка состоит из уникальных символов то создадим Set для промежуточного хранения
    // Проверяем вхождение символа в строку, и заносим, накапливается количество уникалььных символов, сразу же заносим значение в результирующую переменную(если set больше) 
    // когда находится дублирующий символ, мы сдвигаем наше окно до этого символа, и удаляем все элементы, то ес тьстарая максимальная длина стирается и начинаем по новой
    // в резульитрующей переменной сохранится максимальная длина, возвращаем ее 

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                max = Math.max(max, right - left + 1);
            } else {
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }

                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(right));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbbvnbmgjhqwe";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
