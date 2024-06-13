package Files_NIO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

// Будем копировать все файлы и директории
// программа будет обходить все папки и все файлы и копировать их по указанному пути

public class WalkFileTreeEx2 {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("C:\\Users\\dacot\\Desktop\\X");
        Path destination = Paths.get("C:\\Users\\dacot\\Desktop\\CopyHere");
        Files.walkFileTree(source, new FileVisitorForCopy(source, destination));
        System.out.println("Done");
    }
}

class FileVisitorForCopy extends SimpleFileVisitor<Path> {
    // Создаем переменную для пути откуда будем копировать
    Path source;
    // переменная для пути куда копируем
    Path destination;
    public FileVisitorForCopy(Path source, Path destination) {
        this.source = source;
        this.destination = destination;
    }

    // метод для копирования дериктории
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        // создаем путь для копирования
        // применяем такую формулу
        Path newDestination = destination.resolve(source.relativize(dir));
        Files.copy(dir, newDestination, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // то же самое для копирования файлов
        Path newDestination = destination.resolve(source.relativize(file));
        Files.copy(file, newDestination, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }
}

