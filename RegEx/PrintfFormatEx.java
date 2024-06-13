package RegEx;

public class PrintfFormatEx {
    static void employeeInfo(Employee employee) {
        // System.out.printf() в первом параметре принимает конфигурацию строки, 
        // в последующих все объекты которые будут переданы в строку
        // % пишется всегда перед конфигурацией объект, за ним идет флаг, потом ширина(сколько символов),
        // потом идет "," это точность, она для округления дробных чисел
        // затем идет тип данных
        // флаги: "-" это выравнивание по левому краю
        //        "0" это добавление нолей перед числом
        //        "," это разделитель разрядов в числах
        // флагов больше, тут приведены только три
        // типы данных: "d" целое число, "b" boolean, "c" character, "s" string, "f" float
        
        // В нашем примере ниже:
        // %03d - 0 это перед числами буду тзаполнятся нули если они меньше трех знаков,
        // 3 это ширина 3 числа, d это значит будет число
        // \t это табуляция
        // %-12s - "-" это выравнивание по левому краю, 12 ширина строки, s тип данных строка
        // так же добавлена подстрока "Информация 666", для примера того 
        //что можно как в строку добавлять символы куда угодно
        // %,.1f "," это указатель на то ч тобудем округлять число, .1 это сколько символов после точки,
        // f это дробное число
        // далее через запятую передаются объекты которые мы будем отображать указанным выше способом
        System.out.printf("%03d\t%-12s\tИнформация 666   %,.1f\n", employee.id, 
        employee.name, employee.salary*(1 + employee.bonusPct));
    }
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Бойчик", 6000, 0.15);
        Employee emp2 = new Employee(666, "Зайчонок", 3000, 0.16);

        employeeInfo(emp1);
        employeeInfo(emp2);
        System.out.println();

        // метод format() класса String работает так же как printf()
        // и позволяет сохранить формат в строку
        String newString = String.format("%03d\t%-12s\t%,.1f\n",
         1, "Boy Next Door", 6000 * (1 + 0.15));
         System.out.println(newString);
    }
}

class Employee {
    int id;
    String name;
    int salary;
    double bonusPct;

    public Employee(int id, String name, int salary, double bonusPct) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bonusPct = bonusPct;
    }
}