package Files_NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

// Интерфейс Path представляет собой путь к файлу или директории
// Files предоставляет множество методов для работы с файлами

public class PathsAndFilesEx1 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("TestForNIO666.txt");
        Path directory = Paths.get("C:\\Users\\dacot\\Desktop\\S");
        // getFileName() возыращает имя файла или директории
        System.out.println("----------------------------------------------------------");
        System.out.println("path.getFileName(): " + path.getFileName());
        System.out.println("directory.getFileName(): " + directory.getFileName());
        System.out.println("----------------------------------------------------------");
        System.out.println();

        // getParent() показывает родительскую дерикторию
        System.out.println("path.getParent(): " + path.toAbsolutePath().getParent());
        System.out.println("directory.getParent(): " + directory.getParent());
        System.out.println("----------------------------------------------------------");
        System.out.println();

        // getRoot() показывает корень откуда идет файл или директория
        System.out.println("path.getRoot(): " + path.toAbsolutePath().getRoot());
        System.out.println("directory.getRoot(): " + directory.getRoot());
        System.out.println("----------------------------------------------------------");
        System.out.println();

        // isAbsolute() проверяет работаем мы с абсолютным путем или нет
        System.out.println("path.isAbsolute(): " + path.isAbsolute());
        System.out.println("directory.isAbsolute(): " + directory.isAbsolute());
        System.out.println("----------------------------------------------------------");
        System.out.println();

        // toAbsolutePath() показывает абсолютный путь
        System.out.println("path.toAbsolutePath(): " + path.toAbsolutePath());
        System.out.println("directory.toAbsolutePath(): " + directory.toAbsolutePath());
        System.out.println("----------------------------------------------------------");
        System.out.println();

        // resolve() объединяет два пути
        System.out.println(directory.resolve(path));
        System.out.println("----------------------------------------------------------");
        System.out.println();

        // relativize() показывает относительный путь от одной директории к другой или файлу
        System.out.println(directory.relativize(path.toAbsolutePath()));
        System.out.println("----------------------------------------------------------");
        System.out.println();

        // exists() проверяет существует ли
        if(!Files.exists(path)) {
            // создает файл
            Files.createFile(path);
        };

        if(!Files.exists(directory)) {
            // создает директорию
            Files.createDirectory(directory);
        };

        // проверяют можно ли читать\записывать\запускать файл
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isExecutable(path));
        System.out.println("----------------------------------------------------------");
        System.out.println();

        Path path2 = Paths.get("C:\\Users\\dacot\\Desktop\\Test\\TestForNIO666.txt");

        // isSameFile() говорит ссылаются ли оба пути на один файл
        System.out.println(Files.isSameFile(path, path2));
        System.out.println("----------------------------------------------------------");
        System.out.println();

        // возвращает размер файла
        System.out.println(Files.size(path));
        System.out.println("----------------------------------------------------------");
        System.out.println();

        // getAttribute() возвращает аттрибуты файла, требуемый аттрибут указывается в параметрах
        // после пути, их бывает много разных, рассмотрим только некоторые
        System.out.println(Files.getAttribute(path, "creationTime"));
        System.out.println(Files.getAttribute(path, "size"));
        System.out.println("----------------------------------------------------------");
        System.out.println();

        // readAttributes() возвращает Map<String, Object> аттрибутов, через него 
        // можно получить все аттрибуты разом 
        // стрингом выступают названия аттрибутов в объекты отображают значения
        Map<String, Object> allAttribues = Files.readAttributes(path,"*");
        for (Map.Entry<String, Object> entry : allAttribues.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
