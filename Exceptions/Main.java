package Exceptions;

// Создаем свое исключение, оно будет checked наследуем его от Exception
class FactorialException extends Exception {
    // Число которое будет отображать наша ошибка
    private int number;
    public int getNumber() {
        return number;
    }
    // Констуктор который будет принмать сообщение и показыать его, и число
    public FactorialException(String message, int num) {
        super(message);
        number = num;
    }
}

class Factorial {
    public static int getFactorial (int num) throws FactorialException {
        int result = 1;
        if(num < 0) throw new FactorialException("Число меньше 0", num);
        for(int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            int fact = Factorial.getFactorial(-1);
            System.out.println(fact);
        }
        catch(FactorialException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Такое число не подходит: " + "\"" + e.getNumber() + "\"");
        }
    }
}
