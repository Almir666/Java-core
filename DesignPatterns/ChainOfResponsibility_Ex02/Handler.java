package DesignPatterns.ChainOfResponsibility_Ex02;

// Создаем абстрактный класс "обработчик"
public abstract class Handler {
    // Создаем экзкмпляр этогго же класса для определения следующего обработчика
    protected Handler next;
    // Назначаем следующего обработчика
    public void setNext(Handler next) {
        this.next = next;
    }
    
    public abstract void handleRequest(int request);
}
