package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] array = new int[26];

    for (int i = 0; i < s.length(); i++) {
      array[s.charAt(i) - 'a']++;
      array[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (array[i] != 0)
        return false;
    }
    return true;
  }

  public static String getScore(String s) {
    int[] arr = new int[26];
    for (int i = 0; i < s.length(); i++) {
      arr[s.charAt(i) - 'a']++;
    }
    StringBuilder score = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      score.append(arr[i]);
      score.append(",");
    }
    return score.toString();
  }

  public static String toOneString(String s) {
    char[] temp = s.toCharArray();
    Arrays.sort(temp);
    return new String(temp);
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      String key = toOneString(strs[i]);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
        map.get(key).add(strs[i]);
      } else {
        map.get(key).add(strs[i]);
      }
    }
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      ans.add(entry.getValue());
    }
    return ans;
  }

  // public static int missingNumber(int[] nums) {
  // Arrays.sort(nums);
  // for (int i = 0; i < nums.length; i++) {
  // if (i > nums[i]) {
  // return nums[i] + 1;
  // } else if (i < nums[i]) {
  // return nums[i] - 1;
  // }
  // }
  // return nums[nums.length - 1] + 1;
  // }

  // public static int missingNumber(int[] nums) {
  // if(nums.length == 2 && nums[0] != 0 && nums[1] != 0) {
  // return 0;
  // }
  // else if(nums.length == 2 && nums[0] != 1 && nums[1] != 1) {
  // return 1;
  // }
  // else if(nums.length == 2 && nums[0] != 2 && nums[1] != 2) {
  // return 2;
  // }
  // int ans = (nums.length) * ((nums.length / 2) + 1);
  // for(int i = 0; i < nums.length; i++) {
  // ans-=nums[i];

  // }
  // return ans;
  // }

  // public static int missingNumber(int[] nums) {
  // Map<Integer, Integer> map = new HashMap<>();
  // int ans = 0;

  public static List<Integer> getSums(int[] array, ArrayList<ArrayList<Integer>> queryes) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < queryes.size(); i++) {
      int temp = 0;
      for (int j = queryes.get(i).get(0); j < queryes.get(i).get(1); j++) {
        temp += array[j];
      }
      ans.add(temp);
    }
    return ans;
  }

  public static List<Integer> getSums1(int[] array, ArrayList<ArrayList<Integer>> queryes) {
    List<Integer> ans = new ArrayList<>();
    int[] prefixSum = new int[array.length];
    prefixSum[0] = array[0];
    for (int i = 1; i < array.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + array[i];
    }
    for (int i = 0; i < queryes.size(); i++) {
      int temp = 0;
      if (queryes.get(i).get(0) > 0) {
        temp = prefixSum[queryes.get(i).get(1)] - prefixSum[queryes.get(i).get(0) - 1];
      } else {
        temp = prefixSum[queryes.get(i).get(1)];
      }
      ans.add(temp);
    }

    // [4, 5, 11, 2] - array
    // [4, 9, 20, 22] - prefixArray

    // l = 0 r = 2
    // prefixArray[r] -> 20

    // l = 1 r = 3
    // prefixSum[r] - prefixSum[l - 1] = 22 - 4 = 18

    // [12, 5, 2, 7, 10, 23]
    // [12, 17, 19, 26, 36, 59]
    // 36 - 17 = 19

    // l = 2, r = 4

    return ans;
  }

  // 724. Find Pivot Index - домашняя работа
  // public static int pivotIndex1(int[] nums) {
  // int[] prefixSum1 = new int[nums.length];
  // prefixSum1[0] = nums[0];
  // for (int i = 1; i < nums.length; i++) {
  // prefixSum1[i] = prefixSum1[i - 1] + nums[i];
  // }
  // int[] prefixSum2 = new int[nums.length];
  // prefixSum2[nums.length - 1] = nums[nums.length - 1];
  // for (int i = nums.length - 2; i >= 0; i--) {
  // prefixSum2[i] = prefixSum2[i + 1] + nums[i];
  // }
  // for (int i = 0; i < nums.length; i++) {
  // if (prefixSum1[i] == prefixSum2[i]) {
  // return i;
  // }
  // }
  // return -1;
  // }

  // public static int pivotIndex(int[] nums) {
  // int left = 0;
  // int right = 0;
  // for (int i = 1; i < nums.length; i++) {
  // right += nums[i];
  // }
  // for (int i = 0; i < nums.length - 1; i++) {
  // if (left == right) {
  // return i;
  // }
  // left += nums[i];
  // right -= nums[i + 1];
  // }
  // if (left == right) {
  // return nums.length - 1;
  // }
  // return -1;
  // }

  // public static int pivotInteger(int n) {
  // int left = 0;
  // int right = (int) (((double) (1 + n)) / 2 * n) - 1;
  // for (int i = 1; i <= n; i++) {
  // if (left == right) {
  // return i;
  // }
  // left += i;
  // right -= i + 1;
  // }
  // return -1;
  // }

  // // ДЗ ---------------------------------------------------

  public static int sumOddLengthSubarrays(int[] arr) {
    int ans = 0;
    int[] prefixSum = new int[arr.length];
    prefixSum[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i];
    }
    ans += prefixSum[arr.length - 1];
    if (arr.length % 2 != 0 && arr.length != 1)
      ans += prefixSum[arr.length - 1];

    for (int size = 3; size < arr.length; size += 2) {
      for (int r = size - 1; r < arr.length; r++) {
        int l = r - size + 1;
        if (l == 0) {
          ans += prefixSum[r];
        } else {
          ans += prefixSum[r] - prefixSum[l - 1];
        }
      }
    }
    return ans;
  }

  public static int minSubArrayLen(int target, int[] nums) {
    int ans = nums.length;
    int[] prefixSum = new int[nums.length];
    prefixSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i];
    }
    int l = 0;
    int r = 0;
    while (r < nums.length) {
      int sum = 0;
      if (l == 0) {
        sum = prefixSum[r];
      } else {
        sum = prefixSum[r] - prefixSum[l - 1];
      }
      if (sum >= target && l <= r) {
        ans = Math.min(r - l + 1, ans);
        l++;
      } else {
        r++;
      }
    }
    return ans;

  }

  public static int maxArea(int[] height) {
    int max = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
      if (height[left] >= height[right])
        right--;
      else
        left++;
    }
    return max;
  }

  // Берем промежуток между двумя указателями, двигаем его до конца.
  // каждый раз считаем сумму левого и правого подмассивов, скалываем эти суммы и
  // записываем в максимум

  public static int maxScore(String s) {
    int ans = 0;
    int[] arr = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      arr[i] = Character.getNumericValue(s.charAt(i));
    }
    int[] prefixSum = new int[arr.length];
    prefixSum[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i];
    }
    int point2 = 1;
    for (int point1 = 1; point1 < arr.length; point1++) {
      int sum1 = 0;
      int i = 0;
      while (i < point1) {
        if (arr[i] == 0) {
          sum1++;
        }
        i++;
      }
      int sum2 = prefixSum[arr.length - 1];
      if (point1 > 0) {
        sum2 -= prefixSum[point2 - 1];
      }
      ans = Math.max(ans, sum2 + sum1);
      point2++;
    }
    return ans;
  }

  public static boolean isCovered(int[][] ranges, int left, int right) {
    boolean ans = false;
    for (int i = left; i <= right; i++) {
      for (int[] sub : ranges) {
        if (i >= sub[0] && i <= sub[1]) {
          ans = true;
          break;
        }
      }
      if (!ans) {
        return false;
      }
      ans = false;
    }
    return true;
  }

  public static int returnToBoundaryCount(int[] nums) {
    int ans = 0;
    int[] prefixSum = new int[nums.length];
    prefixSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i];
      if (prefixSum[i] == 0) {
        ans++;
      }
    }
    return ans;
  }

  public static int minOperations(int[] nums, int x) {
    if (nums[0] > x && nums[nums.length - 1] > x) {
      return -1;
    }
    int target = x;
    int ans = 0;
    int left = 0;
    int right = nums.length - 1;
    int[] prefixSumR = new int[nums.length];
    prefixSumR[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      prefixSumR[i] = prefixSumR[i - 1] + nums[i];
    }
    int[] prefixSumL = new int[nums.length];
    prefixSumL[nums.length - 1] = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; i--) {
      prefixSumL[i] = prefixSumL[i + 1] + nums[i];
    }
    System.out.println(Arrays.toString(prefixSumL));
    System.out.println(Arrays.toString(prefixSumR));
    while (left < right) {
      if (nums[left] >= nums[right] && (x - nums[left + 1]) >= 0) {
        x -= nums[left];
        left++;
        ans++;
      } else if ((x - nums[right - 1]) >= 0) {
        x -= nums[right];
        right--;
        ans++;
      }
      if (x == 0) {
        return ans;
      }
    }
    return -1;
  }

  private static boolean isDigitOrLetter(char c) {
    return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
  }

  public static boolean isPalindrome(String s) {
    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      char cL = Character.toLowerCase(s.charAt(l));
      char cR = Character.toLowerCase(s.charAt(r));
      while (!isDigitOrLetter(cL) && l < r) {
        cL = Character.toLowerCase(s.charAt(++l));
      }
      while (!isDigitOrLetter(cR) && r > l) {
        cR = Character.toLowerCase(s.charAt(--r));
      }
      if (cL != cR) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }
  // Нужно идти от указателя в стороны, лево и право и проверять на полиндромность

  public static String longestPalindrome(String s) {
    if (s.length() <= 1) {
      return s;
    }
    if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
      return s;
    }
    String ans = "";
    for (int i = 1; i < s.length(); i++) {
      int left = i;
      int right = i;
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      }
      if (s.substring(left + 1, right).length() > ans.length()) {
        ans = s.substring(left + 1, right);
      }
      left = i - 1;
      right = i;
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      }
      if (s.substring(left + 1, right).length() > ans.length()) {
        ans = s.substring(left + 1, right);
      }
    }
    return ans;
  }

  public static boolean isSubsequence(String s, String t) {
    int j = 0;
    int i = 0;
    while (j < s.length() && i < t.length()) {
      if (s.charAt(j) == t.charAt(i)) {
        j++;
      }
      i++;
    }
    if (j == s.length()) {
      return true;
    }
    return false;
  }

  public static int maxScoreCards(int[] cardPoints, int k) {
    int score = 0;
    int[] lPrefix = new int[cardPoints.length];
    lPrefix[0] = cardPoints[0];
    int[] rPrefix = new int[cardPoints.length];
    rPrefix[cardPoints.length - 1] = cardPoints[cardPoints.length - 1];
    for (int i = 1; i < cardPoints.length; i++) {
      lPrefix[i] = lPrefix[i - 1] + cardPoints[i];
    }
    for (int i = cardPoints.length - 2; i >= 0; i--) {
      rPrefix[i] = rPrefix[i + 1] + cardPoints[i];
    }
    if (lPrefix[k - 1] > score) {
      score = lPrefix[k - 1];
    }
    if (rPrefix[cardPoints.length - k] > score) {
      score = rPrefix[cardPoints.length - k];
    }
    int right = cardPoints.length - 1;
    int k2 = k;
    for (int i = 0; i < k - 1; i++) {
      if (lPrefix[i] + rPrefix[right - k2 + 2] > score) {
        score = lPrefix[i] + rPrefix[right - k2 + 2];
      }
      k2--;
    }
    return score;
  }

  // public static int maxScoreCards(int[] cardPoints, int k) {
  // int total = 0;
  // int[] prefix = new int[cardPoints.length];
  // prefix[0] = cardPoints[0];
  // for (int i = 1; i < cardPoints.length; i++) {
  // prefix[i] = prefix[i - 1] + cardPoints[i];
  // }
  // if(k == cardPoints.length) {
  // return prefix[cardPoints.length - 1];
  // }
  // int maxSum = prefix[cardPoints.length - 1];
  // int r = cardPoints.length - k - 1;
  // int l = 0;
  // while (r <= cardPoints.length - 1) {
  // int sumWindow = prefix[r];
  // if(l > 0) {
  // sumWindow -= prefix[l - 1];
  // }
  // if((maxSum - sumWindow) > total) {
  // total = maxSum - sumWindow;
  // }
  // l++;
  // r++;
  // }
  // return total;
  // }

  public static int myAtoi1(String s) {
    int n = 0;
    int count = 0;
    int countP = 0;
    boolean isBegin = true;
    boolean isNegative = false;
    for (int i = 0; i < s.length(); i++) {
      if (countP == 2) {
        return 0;
      }
      if (!isBegin) {
        count++;
      }
      if (isNegative && count >= 10) {
        return -2147483648;
      }
      if (count >= 10) {
        return 2147483647;
      }
      char t = s.charAt(i);
      if (t == '+') {
        countP++;
      }
      if (isBegin && t == '0') {
        count--;
        continue;
      }
      if (t == ' ' || t == '+' && isBegin) {
        continue;
      } else if (t == '-' && isBegin) {
        isBegin = false;
        isNegative = true;
        countP++;
      }

      else if (t >= '0' && t <= '9') {
        isBegin = false;
        int number = t - '0';
        n *= 10;
        n = isNegative ? n - number : n + number;
      } else {
        return n;
      }
    }
    return n;
  }

  public static int myAtoi(String s) {
    int n = 0;
    boolean isBegin = false;
    boolean isNegative = false;
    boolean sign = false;
    for (int i = 0; i < s.length(); i++) {
      char t = s.charAt(i);
      if ((t == ' ') && !isBegin && !sign) {
        continue;
      } else if(t == '+' && !sign && !isBegin){
        sign = true;
      }
      else if (t == '-' && !isBegin && !sign) {
        sign = true;
        isBegin = true;
        isNegative = true;
      } else if (n == 214748364 && (t == '8' || t == '9')) {
        return 2147483647;
      } else if (n > 214748364 && (t >= '0' && t <= '9')) {
        return 2147483647;
      } else if (n == -214748364 && (t == '9')) {
        return -2147483648;
      } else if (n < -214748364 && (t >= '0' && t <= '9')) {
        return -2147483648;
      } else if (t >= '0' && t <= '9') {
        isBegin = true;
        int number = t - '0';
        n *= 10;
        n = isNegative ? n - number : n + number;
      } else {
        return n;
      }
    }
    return n;
  }

  public static int reverse(int x) {
    int ans = 0;
    while(x != 0) {
      int t = x % 10;
      ans = ans * 10 + t;
      x = x / 10;
      if(ans == 214748364 && (t == 8 || t == 9)) {
        return 0;
      } else if (ans > 214748364 && (x > 0 && x <= 9)) {
        return 0;
      }
      else if (ans == -214748364 && (x == 9)) {
        return 0;
      } else if (ans < -214748364 && (x < 0)) {
        return 0;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int x = -1563847412;
    System.out.println(reverse(x));
    List
  }
}