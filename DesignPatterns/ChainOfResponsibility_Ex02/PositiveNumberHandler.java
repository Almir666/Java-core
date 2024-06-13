package DesignPatterns.ChainOfResponsibility_Ex02;

public class PositiveNumberHandler extends Handler{
    public void handleRequest(int request) {
        if (request > 0) {
            System.out.println("Number is positive: " + request);
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
