package Annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationsEx {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws ClassNotFoundException {
        Class xaomiClass = Class.forName("Annotations.Xiaomi");
        // Создаем объект смартфона через рефлексию, используем класс Annotation что бы получить доступ к нашей аннотации
        Annotation annotation1 = xaomiClass.getAnnotation(SmartPhone.class);
        // Кастуем в тип данных SmartPhone что бы можно был ополучить сведения об элементах аннотации
        SmartPhone sm1 = (SmartPhone) annotation1;
        System.out.println("----------------------");
        System.out.println("Xaomi annotation info: \n" + "OS: " + sm1.OS() + "\n" + "yearOfCompanyCreation: " + sm1.yearOfCompanyCreation());

        Class iphoneClass = Class.forName("Annotations.Iphone");
        Annotation annotation2 = iphoneClass.getAnnotation(SmartPhone.class);
        SmartPhone sm2 = (SmartPhone) annotation2;
        System.out.println("----------------------");
        System.out.println("Iphone annotation info: \n" + "OS: " + sm2.OS() + "\n" + "yearOfCompanyCreation: " + sm2.yearOfCompanyCreation());
        System.out.println("----------------------");
    }
}

// Создаем аннотацию:

// Target - показывает область кода к которой аннотация может быть применена (TYPE, FIELD, METHOD и т.д.)
@Target(ElementType.TYPE)
// Retention - жизненый цикл аннотации (SOURCE, CLASS, RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
// Создается аннотация через @interface AnnotationName {}
@interface SmartPhone {
    // Синтаксис создания элементов аннотации такой - Тип данных/Имя/();
    String OS() default "Android";
    // Типы данных для элементов аннотаций могту быть только примитивы, String исключение 
    // Можно указывать значение для элементов аннотации по умолчанию(default)
    int yearOfCompanyCreation() default 2010;
}
// В круглых скобках аннотации можно не указывать значения для элементов только если есть дефолтные
// в противном случае их нужно указывать обязательно
@SmartPhone()
class Xiaomi {
    String model;
    double price;
}

@SmartPhone(OS = "IOS", yearOfCompanyCreation = 1976)
class Iphone {
    String model;
    double price;
}