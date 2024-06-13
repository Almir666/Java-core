package Files_IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferReadWriteEx {
    public static void main(String[] args) throws IOException {
        // Использование буферизиции позволяет достичь большей эффективности при чтении и записи файлов
        // В FileReader и FileWriter операция записи будет производиться так: читается кажджый символ по 
        // отдельности за тем записывается 
        // В буфере же будет создаваться буфер определеннрого размера и программа будет заполнять 
        // этот буфер данными и затем работая с ними тем самым сокращая обращение к ресурсу
        try (BufferedReader reader = new BufferedReader
        (new FileReader("C:\\Users\\dacot\\Desktop\\Test\\FilesIO_NIO\\Text.txt"));
        BufferedWriter writer = new BufferedWriter
        (new FileWriter("C:\\Users\\dacot\\Desktop\\Test\\FilesIO_NIO\\Copy.txt", true));) {
            String line;
            while ((line = reader.readLine())!= null) {
                writer.write(line);
                writer.write("\n");
            }
        }
        System.out.println("Done");
    }
}
