package Files_IO;

import java.io.FileReader;
import java.io.IOException;


public class TryWithResourcesEx {
    public static void main(String[] args) throws IOException {
        // В блоке tryWithResources не обязательно писать блоки catch или finally 
        // ресурс закроется сам автоматически
        // ресурсы которые мы используем в tryWithResources должны имплеменитровать AutoClosable
        try(FileReader fileReader = new FileReader("C:\\Users\\dacot\\Desktop\\Test\\FilesIO_NIO\\Text.txt")) {
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char)character);
            }
            System.out.println();
            System.out.println();
            System.out.println("Done");
        }
    }
}
