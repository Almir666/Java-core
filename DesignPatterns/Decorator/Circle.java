package DesignPatterns.Decorator;

// Реализация интерфейса Shape

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.print("Круг");
    }
}
