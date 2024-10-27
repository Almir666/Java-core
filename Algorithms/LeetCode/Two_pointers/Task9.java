package Algorithms.LeetCode.Two_pointers;

// Find the Index of the First Occurrence in a String

// Даны две строки needle и haystack, верните индекс первого вхождения needle в haystack или -1, 
// если needle не является частью haystack.

public class Task9 {
    public static int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) {
            return -1;
        }
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if(j == needle.length()) {
                return i;
            }
        }
        return -1;   
    }
    
    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        System.out.println(strStr(haystack, needle));
    }
}
