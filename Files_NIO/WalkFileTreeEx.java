package Files_NIO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

// Files.walkFileTree() метод для обхода дерикторий и файлов
// он принимает в себя путь и объект типа FileVisitor
// в FileVisitor заключается логика обхода нашего дерева

public class WalkFileTreeEx {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Users\\dacot\\Desktop\\X");

        Files.walkFileTree(path, new MyFileVisitor());
    }
}

// Создаем объект FileVisitor<>
// он параметризирован, передаем в дженерик Path
class MyFileVisitor implements FileVisitor<Path> {

    // преопределяем 4 метода
    // они возвращают объект типа FileVisitResult, этот объект содержит в себе enum 
    // если мы не хотим переопределять все 4 метода то есть класс SimpleFileVisitor
    // в нем методы уже переопределены

    // preVisitDirectory() срабатывает перед обращением к элементам папки
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

        System.out.println("Enter to directory: " + dir);
        return FileVisitResult.CONTINUE;
    }

    // visitFile() срабатывает при обращении к файлу
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        System.out.println("File name: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    // visitFileFailed() срабатывает если по какой то причине файл не доступен
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {

        System.out.println("Error while visiting file: " + file.getFileName());
        return FileVisitResult.TERMINATE;
    }

    // postVisitDirectory() срабатывает после обращения ко всем элемментам папки
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

        System.out.println("Exit from directory: " + dir);
        return FileVisitResult.CONTINUE;
    }
    
}