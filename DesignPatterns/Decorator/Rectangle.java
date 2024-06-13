package DesignPatterns.Decorator;

// Реализация интерфейса Shape

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.print("Прямоугольник");
    }
}