package Files_IO;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        try {
        fileReader = new FileReader("C:\\Users\\dacot\\Desktop\\Test\\FilesIO_NIO\\Text.txt");
        int character;
        // В цикле мы присваиваем интовой переменной индекс который приходит из метода read()(он возвращает инт)
        // когда символы закончатся он вернет -1
        // затем выводим на экран каждый символ предварительно кастуя его из int в char
            while ((character = fileReader.read()) != -1) {
                System.out.print((char)character);
            }
            System.out.println();
            System.out.println();
            System.out.println("Done");
        } catch (Exception e) {
        } finally {
            fileReader.close();
        }
    }
}
