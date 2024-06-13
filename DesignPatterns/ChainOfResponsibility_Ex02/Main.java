package DesignPatterns.ChainOfResponsibility_Ex02;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Создаем три типа обработчика 
        Handler negativeNumberHandler = new NegativeNumberHandler();
        Handler zeroNumberhandler = new ZeroNumberHandler();
        Handler positiveNumberHandler = new PositiveNumberHandler();

        // Назначаем цепочку последовательности
        negativeNumberHandler.setNext(zeroNumberhandler);
        zeroNumberhandler.setNext(positiveNumberHandler);

        int[] request = {-3, 4, 10, 0, -4, 5};
        
        // Каждое число прохрдит обработку доходя до соответствующего обработчика
        Arrays.stream(request).forEach(negativeNumberHandler::handleRequest);
    }
}
