package Reflection;

import java.lang.reflect.Field;

import ReflectionPackage.Employee;

public class ReflectionEx3 {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Employee boy = new Employee(666, "Boy Next Door", "Dungeon");

        // Попробуем получить доступ к private полю
        Class cllASS = boy.getClass();
        // getDeclaredField() вернет любое поле даже private
        Field privateField = cllASS.getDeclaredField("power");
        // даем достпу с помощью setAccessible()
        privateField.setAccessible(true);
        // запишем значение поля в переменную
        // так как privateField у нас объект типа Field кастуем значение в int
        int boyPower = (int) privateField.get(boy);
        System.out.println("Boy Next Door has power: " + boyPower);

        // мы можем менять значение private поля даже если у него нет сеттера
        // у класса Field есть метод set()
        // он принимает в себя объект с которым мы будем работать и значение на которое будет произведена замена 
        privateField.set(boy, 666);
        boyPower = (int) privateField.get(boy);
        System.out.println("Boy Next Door has power: " + boyPower);
    }
}
