package Files_IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Data Input/OutputStream позволяют читать.записывать в файл примитивные типы данных

public class DataStreamEx {
    public static void main(String[] args) {
        try(DataOutputStream output = new DataOutputStream(new FileOutputStream("test.bin"));
            DataInputStream input = new DataInputStream(new FileInputStream("test.bin"));
        ){
            output.writeByte(5);
            output.writeShort(120);
            output.writeBoolean(true);
            output.writeInt(500);
            output.writeLong(1_000_000L);
            output.writeFloat(3.14F);

            System.out.println(input.readByte());
            System.out.println(input.readShort());
            System.out.println(input.readBoolean());
            System.out.println(input.readInt());
            System.out.println(input.readLong());
            System.out.println(input.readFloat());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
