package Enums;

public class EnumEx1 {
    public static void main(String[] args) {
        Today day = new Today(WeekDays.SUNDAY);
        day.dayInfo();

        // Если через переменную указать через точку внутреннюю ссылку enum(а) которая находится в классе
        // то метод toString() вернет то как выглядит данный enum в нашем случае - SUNDAY
        System.out.println(day.weekDay);
    }
}


enum WeekDays {
    MONDAY("настроение плохое"), 
    TUESDAY("настроение плохое"), 
    WEDNESDAY("настроение плохое"), 
    THURSDAY("настроение плохое"), 
    FRIDAY("настроение плохое"), 
    SATURDAY("настроение хорошее"), 
    SUNDAY("настроение хорошее");
    private String mood;
    // конструктор в enum может быть только private, даже если не указать модификатор доступа
    // он все равно будет private
    private WeekDays (String mood) {
        this.mood = mood;
    }
    // методы в enum можно делать public
    public String getMood() {
        return mood;
    }
}


class Today {
    WeekDays weekDay;
    public Today(WeekDays weekDay) {
        this.weekDay = weekDay;
    }
    void dayInfo() {
        switch (weekDay) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("На работу!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Полежать отдохнуть немножко...");
                break;
        }
        System.out.println("Какой сегодня mood: " + weekDay.getMood());
    }
}