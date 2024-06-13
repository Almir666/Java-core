package DesignPatterns.ChainOfResponsibility_Ex01;

public class Main {
    public static void main(String[] args) {
        // Создадим три объекта MessageSender reportMessageSender, 
        // emailMessageSender и smsMessageSender из соответствующих классов и устанавливаем им свои уровни ошибки.
        MessageSender reportMessageSender = new LogReportMessageSender(PriorityLevel.LOW);
        MessageSender emailMessageSender = new EmailMessageSender(PriorityLevel.MIDDLE);
        MessageSender smsMessageSender = new SMSMessageSender(PriorityLevel.HIGH);
        
        // строим «цепочку ответственности» и назначаем объекту reportMessageSender следующего отправителя — объект emailMessageSender, 
        // а объекту emailMessageSender следующего отправителя — smsMessageSender.
        reportMessageSender.setNextMessageSender(emailMessageSender);
        emailMessageSender.setNextMessageSender(smsMessageSender);

        // Мы видим, что наше сообщение идет по цепочке и выполняется разными обработчиками до того момента, 
        // пока уровень ошибки меньше или равен заданному.
        System.out.println();
        reportMessageSender.messgaeSenderManager("Something is happening!", PriorityLevel.LOW);
        System.out.println("---------------------------------------------------------------------");
        reportMessageSender.messgaeSenderManager("Something went wrong!", PriorityLevel.MIDDLE);
        System.out.println("---------------------------------------------------------------------");
        reportMessageSender.messgaeSenderManager("We had a problem!", PriorityLevel.HIGH);
        System.out.println();
    }
}
