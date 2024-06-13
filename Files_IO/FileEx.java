package Files_IO;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileEx {
    public static void main(String[] args) throws IOException {
        File file = new File("Text.txt");
        File folder = new File("C:\\Users\\dacot\\Desktop\\Q");
        File file2 = new File("C:\\Users\\dacot\\Desktop\\Q\\666\\TestFile.txt");
        File folder2 = new File("C:\\Users\\dacot\\Desktop\\Q\\666");
        // Нахождение абсолютного пути
        System.out.println(file.getAbsolutePath());
        System.out.println(folder.getAbsolutePath());
        System.out.println("-------------------------------------------------------");

        // проверяет является ли путь абсолютным возвращает булеан
        System.out.println(file.isAbsolute());
        System.out.println(folder.isAbsolute());
        System.out.println("-------------------------------------------------------");

        // проверяет является ли файл дерикторией
        System.out.println(file.isDirectory());
        System.out.println(folder.isDirectory());
        System.out.println("-------------------------------------------------------");

        // проверяет существует ли файл или дериктория возвращает булеан
        System.out.println(file.exists());
        System.out.println(folder.exists());
        System.out.println(file2.exists());
        System.out.println(folder2.exists());
        System.out.println("-------------------------------------------------------");

        // createNewFile() создает новый файл, mkdir() создает папку, возвращают булеан
        System.out.println(folder2.mkdir());
        System.out.println(file2.createNewFile());
        System.out.println("-------------------------------------------------------");

        // length() отображает размер папки или файла
        System.out.println(folder2.length());
        System.out.println(file2.length());
        System.out.println("-------------------------------------------------------");

        // delete() удалаяет
        // System.out.println(file2.delete());
        // System.out.println(folder2.delete());
        // System.out.println("-------------------------------------------------------");

        // listFiles() возвращает список объектов в директории
        File[] files = folder2.listFiles();
        System.out.println(Arrays.toString(files));

        // isHidden() проверяет скрыт ли файл или директория
        // остальные методы так же по названию
        System.out.println(file2.isHidden());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.canExecute());
    }
}
