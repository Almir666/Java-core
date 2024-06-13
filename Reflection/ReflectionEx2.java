package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ReflectionPackage.Employee;

public class ReflectionEx2 {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, 
                                            InstantiationException, NoSuchMethodException, SecurityException, 
                                            IllegalArgumentException, InvocationTargetException {
        Class employeeClass1 = Class.forName("ReflectionPackage.Employee");

        // создавать таким образом объект не рекомендуется так как newInstance() устаревший метод
        // Object o = employeeClass1.newInstance();
        // System.out.println(o);

        // Метод newInstance() мы можем использовать если создадим конструктор класса
        // Сonstructor может использовать дженерики по этому мы можем в дженериках сразу 
        // передать нуджный нам тип данных
        Constructor<Employee> constructor1 = employeeClass1.getConstructor();
        // newInstance() возвращает Object но указав в дженериках Constructor нужный нам тип данных
        // нам не придется кастовать Object в нужный нам класс
        // можно сразу прописат ьего в сигнатуре переменной как мы сделали ниже
        Employee emp1 = constructor1.newInstance();
        System.out.println(emp1);

        Constructor<Employee> constructor2 = employeeClass1.getConstructor
                                            (int.class, String.class, String.class);
        // испльзуя newInstance() мы непосредственно создаем наш объект, по этому
        // в параметры newInstance() мы передаем параметры нашего класса
        Employee emp2 = constructor2.newInstance(666, "Boy Next Door", "Gym");   
        // public метод вызывается без проблем но private не вызвать
        emp2.setSalary(300);     
        System.out.println(emp2);     
        
        Method changeDepMethod = employeeClass1.getDeclaredMethod("changeDepartament", String.class);
        // что бы получить доступ к private методу мы используем метод setAccessible() с флагом true
        changeDepMethod.setAccessible(true);
        // Метод invoke() исполняет метод, он принимает в свои параметры объект с которым нужно выполнить этот метод
        // и параметры которые нужно передать, в нашем случае departmetn должен поменяться с Gym на Dungeon
        changeDepMethod.invoke(emp2, "Dungeon");
        System.out.println(emp2);
    }
}
