package DesignPatterns.ChainOfResponsibility_Ex01;

// Класс MessageSender по отправке сообщений, он будет абстрактный и будет содержать общую логику.
public abstract class MessageSender {
    private PriorityLevel priorityLevel;
    private MessageSender nextMessageSender;

    public MessageSender(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
    // Назначаем следующего отправителя
    public void setNextMessageSender(MessageSender nextMessageSender) {
        this.nextMessageSender = nextMessageSender;
    }
    // Данный метод будет принимать строку, которую мы будем передавать и приоритет ошибки. 
    // Как видно из кода, если уровень передаваемого приоритета больше или равен нашему приоритету, 
    // то мы отправляем сообщение и пока имеется следующий отправитель — мы снова вызываем данный метод у него.
    public void messgaeSenderManager(String message, PriorityLevel level) {
        if(level.ordinal() >= priorityLevel.ordinal()) {
            write(message);
        }
        if(nextMessageSender != null) {
            nextMessageSender.messgaeSenderManager(message, level);
        }
    }
    // Этот метод будем переопределять в классах наследниках
    public abstract void write(String message);
}
