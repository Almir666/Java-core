package Algorithms.Tasks;

//     Создайте программу, которая выводит числа от 1 до n.

// - Если число делится на 3, выведите 'Fizz';
// - если число делится на 5, выведите 'Buzz';
// - если число делится и на 3 и на 5, выведите 'FizzBuzz'.


public class FizzBuzz {
    public static void fBfunction(int num) {
        for(int i = 1; i < num; i++) {
            if (i % 15 == 0) {
                System.out.print("FizzBuzz ");
            }
            else if (i % 5 == 0) {
                System.out.print("Buzz ");
            }
            else if (i % 3 == 0) {
                System.out.print("Fizz ");
            }
            else {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        fBfunction(20);
    }
 
}
