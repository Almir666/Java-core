package Files_IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

// Класс RandomAccessFile позволяет читать информацию из любого места файла,
// и записывать информацию в любое место файла

public class RandomAccessFileEx {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("Test2.txt", "rw")){
            
            // read() читает по одному байте и переносит курсор
            int a = file.read();
            System.out.println((char)a);
            // так он выведет уже второй символ
            a = file.read();
            System.out.println((char)a);
            // можно прочитать всю строку
            String s1 = file.readLine();
            System.out.println(s1);
            // seek() принимает в параметр позицию на которую нужно доставить курсор и переводит его туда
            file.seek(30);
            String s2 = file.readLine();
            System.out.println(s2);
            // getFilePointer показывает текущую позицию курсора
            long position = file.getFilePointer();
            System.out.println(position);

            // file.seek(0);
            // если записывать строки в начало файла то они прост озаменят те что были изначально
            // file.writeBytes("qqq");
            file.seek(file.length() - 1);
            file.writeBytes("\nFuck you");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
