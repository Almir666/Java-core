package Files_IO.User2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        List<String> boysInput = new ArrayList<>();
        try(ObjectInputStream input = new ObjectInputStream
        (new FileInputStream("C:\\Users\\dacot\\Desktop\\Test\\boys1.bin"))
        ){
            // читаем объект с помощью метода readObject() так как сразу пресваеваем его аррей листу 
            // нужно кастовать его в требуемый тип данных
            boysInput = (ArrayList)input.readObject();
            System.out.println(boysInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
