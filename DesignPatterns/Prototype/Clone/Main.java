package DesignPatterns.Prototype.Clone;

public class Main {
    public static void main(String[] args) throws Exception{
        Point point = new Point();
        point.x = 1;
        point.y = 2;

        Point pointClone = point.clone();
        point.x = 3;

        System.out.println(point.x + " " + point.y);
        System.out.println(pointClone.x + " " + pointClone.y);
        
    }
}
