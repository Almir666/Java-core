package Files_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Дл буферизиции так же суещствуют Buffered Output/InputStream

public class FileInputOutputStreamEx {
    public static void main(String[] args) {
        // FileInputStream и FileOutputStream классы для работы с бинарными файлами
        // в них все работает  так же как и в классах для текстовых файлов
        try (FileInputStream input = new FileInputStream
         // Для картинки нужно писать в конце имени (.jpg) маленькими буквами
         // другие варианты выдавали ошибку, программа не видила файл
        ("C:\\Users\\dacot\\Desktop\\Test\\FilesIO_NIO\\222.jpg");
        // Тут мы читаем файл картинку из директории данной темы
        // и записываем в новый файл без указания пути, просто в корень проэкта
            FileOutputStream output = new FileOutputStream
            ("222.jpg");) {
            int i;
            while ((i = input.read()) != -1) {
                output.write(i);
            }
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
