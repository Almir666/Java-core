package DesignPatterns.Decorator;

// Реализация интерфейса Shape

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.print("Треугольник");
    }
}
