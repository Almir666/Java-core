package DesignPatterns.ChainOfResponsibility_Ex02;

public class NegativeNumberHandler extends Handler{
    // Определяем если число подходит под условие(отрицательное) то обрабатываем запрос,
    // если нет, то передаем следующему обработчику
    @Override
    public void handleRequest(int request) {
        if(request < 0) {
            System.out.println("Number is negative: " + request);
        }
        else if(next != null) {
            next.handleRequest(request);
        }
    }
}
