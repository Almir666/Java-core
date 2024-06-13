package DesignPatterns.Prototype.Clone;

public class Point implements Cloneable{
    int x;
    int y;
    @Override
    protected Point clone() throws CloneNotSupportedException {
        return (Point) super.clone();
    }
}
