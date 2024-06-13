package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import ReflectionPackage.Employee;

@SuppressWarnings("unused")
public class ReflectionEx1 {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException,
                                            NoSuchMethodException {
        // Вот три способа для создания класса при помощи Reflection, тип данных писпользуем Class
        // 1) через forName() передаем имя класса и пакет в котором он находится
        Class employeeClass1 = Class.forName("ReflectionPackage.Employee");

        // 2) Вызываем через точку у нашего класса который хотим создать class; 
        // Class employeeClass2 = Employee.class;

        // // 3) создаем сначала новый экземпляр класса 
        // // за тем при создании объекта Class присваиваем ссылку на наш класс и вызываем getClass()
        // Employee emp = new Employee();
        // Class employeeClass3 = emp.getClass();

        // getField() возвращает объект типа Field, в параметры передаем точное имя поля
        Field idField = employeeClass1.getField("id");
        System.out.println("Name: " + idField.getName() + "\n" + "Type: " + idField.getType());
        System.out.println("------------------------------------------------");

        // getFields() возвращает массив полей класса в виде объектов Field
        // он не возвращает private поля
        Field [] fields = employeeClass1.getFields();
        for(Field f: fields) {
            System.out.print("Field name:" + f.getName() + ". Type:" + f.getType() + "." + " ");
        }
        System.out.println();
        System.out.println("------------------------------------------------");

        // getDeclaredFields() возвращает массив полей класса в виде объектов Field в том числе private
        Field [] allFields = employeeClass1.getDeclaredFields();
        for(Field f: allFields) {
            System.out.print("Field name:" + f.getName() + ". Type:" + f.getType() + "." + " ");
        }
        System.out.println();
        System.out.println("------------------------------------------------");

        // У методов так же есть класс Method его метод getMethod() возвращает нам метод
        // в виде объекта типа Method
        // так же проме "имени" getMethod("имя") принимает в параметры тип/типы параметров или параметра если 
        // он один, так как таких перегруженных методов может быть несколько
        // именно по типам параметров Java будет понимать к какому конкретно методы мы обращаемся
        // передавая тип параметра в параметр  getMethod("имя", double.class)
        // нужно после типа указывать .class
        Method method = employeeClass1.getMethod("increaseSalary");
        System.out.println("Name of method: " + method.getName() + "\n" +
                            "Return type of method: " + method.getReturnType() + "\n" +
                            "Parametr type: " + Arrays.toString(method.getParameterTypes()));
        System.out.println("------------------------------------------------");

        // Тут пример определения метода с параметром
        Method method2 = employeeClass1.getMethod("setSalary", double.class);
        System.out.println("Name of method: " + method2.getName() + "\n" +
                            "Return type of method: " + method2.getReturnType() + "\n" +
                            "Parametr type: " + Arrays.toString(method2.getParameterTypes()));
        System.out.println("------------------------------------------------");

        // Так же как и у Field вернулся массив типа Methods с методами
        // но без private методов
        Method [] method3 = employeeClass1.getMethods();
        for(Method m: method3) {
            System.out.println("Method name:" + m.getName() + "()");
        }
        System.out.println("------------------------------------------------");

        // getDeclaredMethods() вернет массив типа Method состоящий из методов которые прописаны только 
        // в нашем классе в том числе и private, в данном примере Employee, методы унаследованныые 
        // от других классов на подобие equals() или hashCode() не будут возвращены
        Method [] method4 = employeeClass1.getDeclaredMethods();
        for(Method m: method4) {
            System.out.println("Method name:" + m.getName() + "()");
        }
        System.out.println("------------------------------------------------");

        // В этом примере получим все методы с доступом public
        Method [] method5 = employeeClass1.getDeclaredMethods();
        for(Method m: method5) {
            // Modifier.isPublic проверяет является ли метод public
            // getModifiers() возвращает нам модификатор доступа
            if(Modifier.isPublic(m.getModifiers())) {
                System.out.println("Method name:" + m.getName() + "()");
            }
        }
        System.out.println("------------------------------------------------");

        // С конструкторами все тоже самое как с полями и методами
        // в параметры getConstructor() можно передавать параметры для определения конкретного конмтруктора
        Constructor constructor = employeeClass1.getConstructor();
        System.out.println("Constructor has " + constructor.getParameterCount() + " parameters" + "\n" +
                            "Parameter types: " + Arrays.toString(constructor.getParameterTypes()));
        System.out.println("------------------------------------------------");

        // В этом примере рассмотрим конструктор который принимает id/name/department
        // передаем в параметры getConstructor() int, String, String
        // не забываем ставить .class
        Constructor constructor2 = employeeClass1.getConstructor
                                    (int.class, String.class, String.class);
        System.out.println("Constructor has " + constructor2.getParameterCount() + " parameters" + "\n" +
                            "Parameter types: " + Arrays.toString(constructor2.getParameterTypes()));
        System.out.println("------------------------------------------------");

        // Так же как с полями и методами мы можем вернуть массив конструкторов
        Constructor [] constructors = employeeClass1.getConstructors();
        for(Constructor c: constructors) {
            System.out.println("Constructor name:" + c.getName() + "\n" +
                                "Parameter types: " + Arrays.toString(c.getParameterTypes()));
        }
        System.out.println("------------------------------------------------");

        Constructor [] constructors2 = employeeClass1.getDeclaredConstructors();
        for(Constructor c: constructors2) {
            System.out.println("Constructor name:" + c.getName() + "\n" +
                                "Parameter types: " + Arrays.toString(c.getParameterTypes()));
        }
    }
}
