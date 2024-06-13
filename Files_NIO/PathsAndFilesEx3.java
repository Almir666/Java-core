package Files_NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathsAndFilesEx3 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("Test10.txt");
        // Создаем файл
        // Files.createFile(filePath);

        // создаем строку для записи в файл
        // String text = "-Fuck youuuu!\n-No no no no no, fuck youuuu!";
        // метод write() записывает в файл массив байт
        // Files.write(filePath, text.getBytes());

        // readAlllLines() возвращает лист стрингов 
        List<String> list = Files.readAllLines(filePath);
        // выводим в консоль
        for (String line : list) {
            System.out.println(line);
        }
    }
}
