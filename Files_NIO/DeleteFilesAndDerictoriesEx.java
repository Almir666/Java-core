package Files_NIO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteFilesAndDerictoriesEx {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\dacot\\Desktop\\CopyHere");

        // вызываем walkFileTree() для обхода всех папок и файлов
        Files.walkFileTree(path, new DeleteFileVisitor());
    }
}

class DeleteFileVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // Тут все просто, удаляем файл
        Files.delete(file);
        System.out.println("Delete file: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        // с директориями так же
        Files.delete(dir);
        System.out.println("Delete directory: " + dir.getFileName());
        return FileVisitResult.CONTINUE;
    }
}