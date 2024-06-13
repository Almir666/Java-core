package Files_NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx2 {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("TestForNIO2.txt", "r");
            FileChannel channel = file.getChannel();
        ){
            // Рассматриваем методы
            ByteBuffer buffer = ByteBuffer.allocate(5);
            channel.read(buffer);
            buffer.flip();
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());
            // rewind() переводит позицию на начало, в отличие от clear() мы читаем байты заново
            buffer.rewind();
            System.out.println((char) buffer.get());
            System.out.println("------------------------------------");

            // метод compact() переводит все непрочитанные байты в буфере к началу, 
            // а уже прочитанные затираются, освободившиеся байты можем заполнять информацией  
            buffer.compact();
            // снова читаем из файла в буффер и дозаписываем свободные байты
            channel.read(buffer);
            // position
            buffer.flip();
            // посмотрим теперь на содержимое буфера, выведем все
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            System.out.println("---------------------------------------");

            // вернули позишн на 0, будем перезаписыват ь новые байты поверх старых
            buffer.clear();
            // считали
            channel.read(buffer);
            // вернули позишн на начало
            buffer.flip();
            System.out.println((char) buffer.get());
            // mark() поставили отметку на той позиции на которой сейчас находимся и мы 
            // сможем вернуться на нее
            buffer.mark();
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());
            System.out.println("---------------------------------------");
            // вернули позицию на метку
            buffer.reset();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
