package DesignPatterns.Factory.FactoryMethod;

public abstract class Bakery {
    private String name;

    public String getName() {
        return name;
    }
    public void makeSomeBaking() {
        rollOutTheDough();
        putTheFilling();
        baking();
    }

    public void rollOutTheDough() {      
        System.out.println("...раскатываем тесто...");  
    }

    public void putTheFilling() {     
        System.out.println("...кладем начинку...");    
    }

    public void baking() {      
        System.out.println("...запекаем...");   
    }
}
