package DesignPatterns.Factory.SimplePizzaFactory;

public class Pizza {
    private String name;

    public String getName() {
        return name;
    }
    public void rollOutTheDough() {      
        System.out.println("...раскатываем тесто...");  
    }

    public void putTheFilling() {     
        System.out.println("...кладем начинку...");    
    }

    public void bakePizza() {      
        System.out.println("...запекаем...");   
    }
}
