package Serialazation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws Exception{
        TestObject testObject = new TestObject();

        testObject.level = 20;
        testObject.name = "DefaultPerson";

        FileOutputStream fileOutputStream = new FileOutputStream("someData");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(testObject);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("someData");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TestObject secomdObject = (TestObject) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(secomdObject.level);
    }
}
