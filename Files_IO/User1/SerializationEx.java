package Files_IO.User1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx {
    public static void main(String[] args) {
        List<String> boys = new ArrayList<>();
        boys.add("Luka");
        boys.add("Georgyi");
        boys.add("Alexandr");

        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("boys1.bin"))
        ){
            // для сериализации используем метод writeObject
            output.writeObject(boys);
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
