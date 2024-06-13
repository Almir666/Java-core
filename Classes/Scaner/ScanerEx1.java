package Classes.Scaner;

import java.util.Scanner;

public class ScanerEx1 {
    public static void main(String[] args) {
        // Так мы создаем input
        // передавая в параметр System.in создаем инпут который примет данные с консоли
        // Scanner scaner = new Scanner(System.in);
        // System.out.println("Введите число:");
        // для разных типов данных есть методы nextInt/Double/Short()
        // Для строки используем nextLine()
        // просто метод next() вернет первую последовательность символов в строе до пробела
        // int num = scaner.nextInt();
        // System.out.println("Введенное число: " + num);
        // scaner.close();

        // Если же передать строку в параметры, то метод nextLine() будет выводить эти строки построчно
        Scanner scaner = new Scanner("First line 666\nSecond line 666");

        // hasNext() так же существует в разных вариациях для разных типов данных
        while (scaner.hasNextLine()) {
            System.out.println(scaner.nextLine());
        }
        scaner.close();
    }
}
