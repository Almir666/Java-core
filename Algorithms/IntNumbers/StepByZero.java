package Algorithms.IntNumbers;

// Дается целове число, верните количество шагов которое требуется, чтобы уменьшить его до нуля.
// За один шаг, если текущее число четное, вам нужно разделить его на 2,
// в противном случае вам придется вычесть из него 1.

// Example 1:
// Input: num = 14
// Output: 6
// Explanation: 
// Step 1) 14 is even; divide by 2 and obtain 7. 
// Step 2) 7 is odd; subtract 1 and obtain 6.
// Step 3) 6 is even; divide by 2 and obtain 3. 
// Step 4) 3 is odd; subtract 1 and obtain 2. 
// Step 5) 2 is even; divide by 2 and obtain 1. 
// Step 6) 1 is odd; subtract 1 and obtain 0.

// Example 2:
// Input: num = 8
// Output: 4
// Explanation: 
// Step 1) 8 is even; divide by 2 and obtain 4. 
// Step 2) 4 is even; divide by 2 and obtain 2. 
// Step 3) 2 is even; divide by 2 and obtain 1. 
// Step 4) 1 is odd; subtract 1 and obtain 0.

public class StepByZero {
    public static void main(String[] args) {
        int num = 14;
        System.out.println(numberOfSteps(num));
    }

public static int numberOfSteps(int num) {
    int result = 0;
    while(num > 0) {
        if (num % 2 == 0) {
            num /=2;
            result++;
        }
        else {
            num -= 1;
            result++;
        }
    }
    return result;
}
}
