package Files_NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathsAndFilesEx2 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("TestForNIO666.txt");
        Path directorySPath = Paths.get("C:\\Users\\dacot\\Desktop\\S");
        Path directoryQPath = Paths.get("C:\\Users\\dacot\\Desktop\\Q");
    
        // copy() копирует файл, в параметры указываем пу тьдо файла и путь куда копируем, 
        // так же нужно указывать название файла, но в нашем случае объединим два пути resolve()
        // что бы получить такое же название как у имеющегося файла 
        // третий параметр StandartCopyOption.REPLACE_EXISTING заменяет файл если он уже существует
        // можно и без третьего параметра
        Files.copy(filePath, directorySPath.resolve(filePath), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Copy is done");

        // скопировав таким способом папку мы копируем только папку, а ее содержимое нет
        Files.copy(directoryQPath, directorySPath.resolve("Q"));
        System.out.println("Copy is done");

        // метод move() переносит файл с одного места на другое
        Files.move(filePath,directorySPath.resolve("TestForNIO666.txt"));
        System.out.println("Move is done");

        // Так же мы можем переименовывать файлы с помощью метода move()
        // перемещаем файл в тоже место где он сейчас находится но задаем ему новое имя
        Files.move(Paths.get("TestForNIO3.txt"), Paths.get("TestForNIO5.txt"));

        // удаление
        // если директория не пуста мы не сможем удалить ее этим методом
        Files.delete(Paths.get("TestForNIO5.txt"));
    }
}
