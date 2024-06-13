package Classes.Scaner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// В сканнер так же можно передавать и файл с которого он будет считывать строки

public class ScanerEx2 {
    public static void main(String[] args) {
        Scanner scanner = null;
        Set<String> set = new TreeSet<>();
        try {
            // Передали в сканер FileReader в котором указан путь к текстовому файлу
            scanner = new Scanner(new FileReader(new File
            ("C:\\Users\\dacot\\Desktop\\X\\Y\\File1.txt.txt")));
            // проверем, пока в сканере есть слова
            while (scanner.hasNext()) {
                // присваеваем слово переменной
                String word = scanner.next();
                // добавляем слово в наш сет
                set.add(word);
            }    
            // распечатываем сет
            // он должен получиться отсортированным и не иметь повторяющихся элементов
                for (String s: set) {
                    System.out.println(s);
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
