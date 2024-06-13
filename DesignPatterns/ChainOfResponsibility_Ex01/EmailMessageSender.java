package DesignPatterns.ChainOfResponsibility_Ex01;

public class EmailMessageSender extends MessageSender {
    public EmailMessageSender(PriorityLevel priorityLevel) {
        super(priorityLevel);
    }

    @Override
    public void write(String message) {
        System.out.println("Sending email: " + message);
    }
}
