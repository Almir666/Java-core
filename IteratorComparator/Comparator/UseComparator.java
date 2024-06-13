package IteratorComparator.Comparator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

// Например у нас нет доступа к классу Person
class Person {
    private int age;

    Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {  
        return String.format("%d", age);
    }
}

// Тогда мы создаем класс имплементирующий интерфейс Comparator, и параметризируем его нужным нам классом(тут Person)
// переопределяем в нем метод compare()
class ComparePerson implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }

}

public class UseComparator {
    public static void main(String[] args) {
        // Создаем объект нашего компаратора
        ComparePerson comparePerson = new ComparePerson();
        // передаем его в коллекцию
        Set<Person> set = new TreeSet<>(comparePerson);
        set.add(new Person(12));
        set.add(new Person(1));
        set.add(new Person(99));
        set.add(new Person(20));
        set.add(new Person(16));
        set.add(new Person(0));

                for(Object o : set) {
            System.out.println(o);
        }

    }
}
