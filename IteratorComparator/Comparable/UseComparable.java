package IteratorComparator.Comparable;

import java.util.Set;
import java.util.TreeSet;



// Имплеиентируем интерфейс Comparable для класса и тогда мы можем его сортировать переорпеделив метод compareTo
class Person implements Comparable<Person>{
    int id;
    Person(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Person p) {
        return this.id - p.id;
    }
    @Override
    public String toString() {  
        return String.format("%d", id);
    }
}

public class UseComparable {
    public static void main(String[] args) {
        
        Set<Person> set = new TreeSet<>();
        set.add(new Person(20));
        set.add(new Person(16));
        set.add(new Person(35));
        set.add(new Person(4));

        for(Object o : set) {
            System.out.print(o + " ");
        }
    
    }    
}
