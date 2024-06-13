package Stream;

import java.util.ArrayList;
import java.util.List;

public class FlatMapEx {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Бойчик", 125.5, 15.3);
        Cat cat2 = new Cat("Джоинт", 155.1, 18.1);
        Cat cat3 = new Cat("Том", 80.7, 11.4);
        Cat cat4 = new Cat("Джерри", 100.5, 12.5);
        Cat cat5 = new Cat("Георгий", 170.9, 20.3);

        Groups gr1 = new Groups("Street cats");
        Groups gr2 = new Groups("Home cats");
        gr1.addCatToGroup(cat1);
        gr1.addCatToGroup(cat2);
        gr1.addCatToGroup(cat3);
        gr2.addCatToGroup(cat4);
        gr2.addCatToGroup(cat5);
        
        List<Groups> catGroupList = new ArrayList<>();
        catGroupList.add(gr1);
        catGroupList.add(gr2);
        // Метод flatMap() мы используем тогда когда хотим поработать с элементами элементов нашей коллекции
        // он intermediate
        catGroupList.stream().flatMap(group -> group.getCatGroup().stream()).forEach(c -> System.out.println(c.getName()));
    }
}

class Groups {
    String name;
    List<Cat> catGroup;

    public Groups(String name) {
        this.name = name;
        catGroup = new ArrayList<>();
    }

    public List<Cat> getCatGroup() {
        return catGroup;
    }

    public void addCatToGroup(Cat cat) {
       catGroup.add(cat); 
    }
}