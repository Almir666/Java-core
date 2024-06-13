package Algorithms.Strings;

// Даны две строки ransomNote и magazine, верните true если ransomNote можно построить из magazine.
// Каждая буква из magazine может быть использована в ransomNote только один раз.

public class RansomNote {
    public static void main(String[] args) {
        
    }

public static boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);
            
            int matchingIndex = magazine.indexOf(r);

            if (matchingIndex == -1) {
                return false;
            }
            magazine = magazine.substring(0, matchingIndex) + magazine.substring(matchingIndex + 1);
        }
        return true;
    }
}


