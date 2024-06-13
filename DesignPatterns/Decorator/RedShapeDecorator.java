package DesignPatterns.Decorator;

// RedShapeDecorator раскаршивает наши объекты

public class RedShapeDecorator extends ShapeDecorator{
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    // Теперь вместо обычных фигур, будут фигуры с красными границами
    public void setRedBorder(Shape decoratedShape) {
        System.out.println(" с красным цветом границ");
    }
}
