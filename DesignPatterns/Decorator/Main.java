package DesignPatterns.Decorator;

// — Создадим интерфейс (Shape)
// — Создадим конкретные реализации этого интерфейса
// — Создадим абстрактный декоратор, реализующий этот интерфейс
// — Создадим конкретный декоратор, наследующийся от абстрактного декоратора
// — Используем конкретный декоратор для "декорирования" конкретных реализаций интерфейса

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redTriangle = new RedShapeDecorator(new Triangle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        circle.draw();
        System.out.println();
        redCircle.draw();
        redTriangle.draw();
        redRectangle.draw();


    }
}
