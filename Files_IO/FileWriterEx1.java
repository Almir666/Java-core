package Files_IO;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx1 {
    public static void main(String[] args) throws IOException {
        // String text = "Test text, first line \n" +
        //             "test text, second line \n";
        // Инициализируем FileWriter вне блока трай что бы он был виден в блоке файнали
        FileWriter writer = null;
        try {
            // Указав в параметры FileWriter просто имя файла он создасться в корне проэкта
            // либо можно передать путь до файла в который нужно записать данные (\\) должен быть двойной
            // флаг true во втором параметре активирует состояние append для дозаписи данных
            // без него данные будет перезаписываться заново
            // так же FileWriter может принимать не строку а объект файл
            writer = new FileWriter("C:\\Users\\dacot\\Desktop\\Test\\FilesIO_NIO\\Text.txt", true);
            // for (int i = 0; i < text.length(); i++) {
                // charAt() возвращает символ по указаному индексу
                // то есть в файл будут записываться все символы строки по порядку
                // writer.write(text.charAt(i));
            // }
            writer.write("append data");
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            writer.close();
        }
    }
}
