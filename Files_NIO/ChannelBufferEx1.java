package Files_NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// Buffer это блок памяти в котором мы можем хранить информацию или записывать информацию в него
// Channel в отличие от стримов может как читать из файла так и записывать в него

public class ChannelBufferEx1 {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("TestForNIO.txt", "rw");
        // Создаем Channel, он тоже ресурс так ч тозаписваем его в блок try with recources
        FileChannel channel = file.getChannel();
        ){
            // Создаем БайтБуффер и указываем а нем размерность в нашем случае 25 байт
            ByteBuffer buffer = ByteBuffer.allocate(25);

            // Создаем переменную для хранения текста который будем считывать с файла
            StringBuilder text = new StringBuilder();

            // Сздаем переменную в которой будем хранить ту порцию из 25 байт что считали
            // метод read() записывает байты в буфер
            int bytePart = channel.read(buffer);

            // пока в нашей порции байт есть что то
            while (bytePart > 0) {
                System.out.println("Read: " + bytePart + " bytes");
                // метож flip() возвращает позицию на 1 место 
                // для того что бы можно было считывать информацию с самого начала
                buffer.flip();

                // пока в буффере есть что читать
                while (buffer.hasRemaining()) {
                    // добавляем в нашу переменную байты из буффера кастую сразу их в символы
                    text.append((char)buffer.get());
                }

                // когда буффер дошел до последней позиции вызываем метод clear()
                // он переводит позицию снова на начало для возможности записывать новую порцию байт
                buffer.clear();

                // продолжаем записывать байты
                bytePart = channel.read(buffer);
            }
            // Теперь записываем информацию в файл
            // варинат 1 ----------------------------------------------------
            String text2 =  "\n\nNjknsgkng ngkfsngl hgfh okl kkp[lkhd ,l,,ml\n" +
                            "gfgk opkopk ppklp ookok ppp[kl[k pkjiuihui ]]\n" +
                            "gsgji jij huih ijoij";

            // Создаем отдельный буффер для записи, передаем в 
            // размерность длину текста в байтах getBytes().length()
            // ByteBuffer buffer2 = ByteBuffer.allocate(text2.getBytes().length);

            // // передали строку в виде байтов
            // buffer2.put(text2.getBytes());
            // // вернули позицию на начало
            // buffer2.flip();
            // // с помощью метода write() записали информацию из буффера в файл
            // channel.write(buffer2);
            // ----------------------------------------------------------------

            // вариант 2
            // Метод wrap() сам создает нужную размерность буффера, сам делает флип
            // он удобнее, можно писать меньше кода
            ByteBuffer buffer2 = ByteBuffer.wrap(text2.getBytes());
            channel.write(buffer2);

            System.out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
