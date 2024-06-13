package IteratorComparator.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Comparable<> используется дял сравнения объектов используя их естественный порядок

public class Em {
    public static void main(String[] args) {
        List<Emplployee> list = new ArrayList<>();
        Emplployee emp1 = new Emplployee(666, "Almir", "Shammasov", 5000);
        Emplployee emp2 = new Emplployee(777, "Luka", "Gwadzabia", 600000);
        Emplployee emp3 = new Emplployee(333, "Georgyi", "Gwadzabia", 150000);

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        System.out.println(list);
        System.out.println();

        Collections.sort(list, new IdComparator());
        System.out.println(list);
    }
}

class Emplployee implements Comparable<Emplployee>{
    int id;
    String name;
    String surname;
    int salary;

    public Emplployee(int id, String name, String surename, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surename;
        this.salary = salary;
    }

    @Override
    public int compareTo(Emplployee o) {
        // if (this.id == o.id) {
        //     return 0;
        // } 
        // else if(this.id < o.id) {
        //     return -1;
        // }
        // else return 1;

        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "Employee: " + id + " " + name + " " + surname + " " + salary;
    }
}
// Comparator интерфейс который работает так же как Comparable только принимает два аргумента в метод сравнения
class IdComparator implements Comparator<Emplployee> {
    @Override
    public int compare(Emplployee o1, Emplployee o2) {
        return o1.id - o2.id;
    }

    
}
