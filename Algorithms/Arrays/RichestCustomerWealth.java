package Algorithms.Arrays;

// Дан многомерный массив, где account[i][j] — это сумма денег, 
// которую имеет i​​​​​​​​​​-й​​​ клиент в j​​​​​​​ й банк. Найти самого богатого клиента.
// Богатство клиента это сумма чисел внутреннего массива

// Example 1:

// Input: accounts = [[1,2,3],[3,2,1]]
// Output: 6
// Explanation:
// 1st customer has wealth = 1 + 2 + 3 = 6
// 2nd customer has wealth = 3 + 2 + 1 = 6
// Both customers are considered the richest with a wealth of 6 each, so return 6.
// Example 2:

// Input: accounts = [[1,5],[7,3],[3,5]]
// Output: 10
// Explanation: 
// 1st customer has wealth = 6
// 2nd customer has wealth = 10 
// 3rd customer has wealth = 8
// The 2nd customer is the richest with a wealth of 10.

public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] bank1 = {{1, 2, 3}, {3, 2, 1}};
        int[][] bank2 = {{1,5}, {7,3}, {3,5}};
        int[][] bank3 = {{2,8,7}, {7,1,3}, {1,9,5}};
        int ex1 = maximumWealth(bank1);
        int ex2 = maximumWealth(bank2);
        int ex3 = maximumWealth(bank3);

        System.out.println(ex1);
        System.out.println(ex2);
        System.out.println(ex3);


    }

    public static int maximumWealth(int[][] arr) {
        int result = 0;
        for (int[] a : arr) {
            int current = 0;
            for(int i : a) {
                current += i;
            }
            if (result < current) {
                result = current;
            }
        }
        return result;
    }
}
