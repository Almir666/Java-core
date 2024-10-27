package Algorithms.LeetCode.Two_pointers;

// Longest Palindromic Substring
// Верните самую длинную палиндромную подстроку в s.

public class Task4 {

    public static String longestPalindrome(String s) {
        if(s.length() <= 1) {
            return s;
        }
        String ans = "";
        for(int i = 1; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            String poli = s.substring(left + 1, right);
            if(ans.length() < poli.length()) {
                ans = poli;
            }
            left = i - 1;
            right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            poli = s.substring(left + 1, right);
            if(ans.length() < poli.length()) {
                ans = poli;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("gsgfhtuio"));
    }







    // private static boolean isDigitOrLetter(char c){
    //     return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    //   }
      
    //   public static boolean isPalindrome(String s) {
    //     int l = 0;
    //     int r = s.length() - 1;
    //     while(l < r) {
    //       char cL = Character.toLowerCase(s.charAt(l));
    //       char cR = Character.toLowerCase(s.charAt(r));
    //       while (!isDigitOrLetter(cL) && l < r) {
    //         cL = Character.toLowerCase(s.charAt(++l));
    //       }
    //       while (!isDigitOrLetter(cR) && r > l) {
    //         cR = Character.toLowerCase(s.charAt(--r));
    //       }
    //       if(cL != cR) {
    //         return false;
    //       }
    //       l++;
    //       r--;
    //     }
    //     return true;
    //   }
      
    //   public static String longestPalindrome(String s) {
    //     if(s.length() == 1){
    //       return s;
    //     }
    //     if(isPalindrome(s)) {
    //       return s;
    //     }
    //     String ans = "";
    //     int l = 0;
    //     int r = 1;
    //     while(l < s.length() - 1){
    //       String sub = s.substring(l, r);
    //       if(isPalindrome(sub) && sub.length() > ans.length()) {
    //         ans = sub;
    //       }
    //       if(r < s.length() - 1) {
    //       r++;
    //       }
    //       if(r == s.length() - 1 ){
    //         l++;
    //       }
    //     }
    //     return ans;
    //   }
}


