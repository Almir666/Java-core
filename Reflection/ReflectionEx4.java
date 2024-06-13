package Reflection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectionEx4 {
    @SuppressWarnings({ "rawtypes" })
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        // Мы создали экземпляр нашего кастомного класса Calculator из этого же файла
        // все его методы без модификаторов, то есть по умолчанию
        // Calculator calc1 = new Calculator();
        // // просто взятьи вызвать их через экземпляр класса мы не можем
        // calc1.sum(1, 2);

        // Для решения задачи воспользуемся рефлексией
        // Так же добавим такую задачу, будем читать информацию из файла и на ее основе производить нужные нам вычисления
        // в файле будет храниться название нужного метода и аргументы для него
        try(BufferedReader reader = new BufferedReader(new FileReader("FileForReflection.txt"))) {
            // считваем первую строку в которой записан метод и сохранаем в переменную
            String methodName = reader.readLine();
            //считываем аругмент1
            String firstArg = reader.readLine();
            //считываем аругмент2
            String secondArg = reader.readLine();

            // Создадим наш объект через рефлексию
            Calculator calculator = new Calculator();
            Class cl = calculator.getClass();

            // временная переменная для метода
            Method method = null;
            // вызовем все методы описанные в классе
            // выберем DeclaredMethods() что бы вернуть только нужные нам описанные методы
            Method [] methods = cl.getDeclaredMethods();
            for(Method m: methods) {
                // сравниваем имя каждого метода с именем из текстового файла
                if (m.getName().equals(methodName)) {
                    // присваиваем совпавший метод нашей временной переменной
                    method = m;
                }
            }
            // мы получили наш метод и можно вызвать его, аргументы так же считаны и можно их передать
            method.invoke(calculator, Integer.parseInt(firstArg), Integer.parseInt(secondArg));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Calculator {
    void sum(int a, int b) {
        int result = a + b;
        System.out.println("Сумма чисел " + a + " и " + b + " равна: " + result);
    }
    void sub(int a, int b) {
        int result = a - b;
        System.out.println("Разница чисел " + a + " и " + b + " равна: " + result);
    }
    void mult(int a, int b) {
        int result = a * b;
        System.out.println("Произведение чисел " + a + " и " + b + " равно: " + result);
    }
    void div(int a, int b) {
        int result = a / b;
        System.out.println("Результат деления чисел " + a + " и " + b + " равен: " + result);
    }
}