package Algorithms.Strings;

// Valid Palindrome

// Задана строка s, верните true, если она является палиндромом, или false в противном случае.

public class IsPolindrome {
    public static boolean isPalindrome(String s) {
        return s.replaceAll("\\W", "").replaceAll("_", "").equalsIgnoreCase(new StringBuilder(s.replaceAll("\\W", "").replaceAll("_", "")).reverse().toString());
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
