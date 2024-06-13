package Files_IO.User2;

public class Boys {
    // это версия которая меняется при изменении класса
    // это нужно для того что бы классы всегда совпадали и не было ошибок при десериализации
    static final long serialVersionUID = 1;
    String name;
    int age;
    double salary;

    public Boys(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + ". Age: " + age + ". Salary: " + salary + ". ";
    }
}
