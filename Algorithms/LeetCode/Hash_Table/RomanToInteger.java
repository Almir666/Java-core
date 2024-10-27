package Algorithms.LeetCode.Hash_Table;

import java.util.HashMap;
import java.util.Map;

// Roman to Integer

// Задав римскую цифру, преобразуйте ее в целое число.

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('L', 50);
        map.put('X', 10);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        ans+= map.get(s.charAt(s.length()-1));
        
        for(int i = s.length() - 2; i >= 0; i--) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ans-= map.get(s.charAt(i));
            }
            else {
                ans+= map.get(s.charAt(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }
}