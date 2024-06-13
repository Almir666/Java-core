package DesignPatterns.ChainOfResponsibility_Ex01;

public class SMSMessageSender extends MessageSender {
    public SMSMessageSender(PriorityLevel priorityLevel) {
        super(priorityLevel);
    }

    @Override
    public void write(String message) {
        System.out.println("Sending SMS to manager: " + message);
    }
}
