package ReflectionPackage;

public class Employee {
    public int id;
    public String name;
    public String departament;
    private double salary;
    @SuppressWarnings("unused")
    private int power = 100;

    public Employee(){}

    public Employee(int id, String name, String departament) {
        this.id = id;
        this.name = name;
        this.departament = departament;
    }

    @SuppressWarnings("unused")
    private Employee(int id, String name, String departament, double salary) {
        this.id = id;
        this.name = name;
        this.departament = departament;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @SuppressWarnings("unused")
    private void changeDepartament(String newDep) {
        departament = newDep;
        System.out.println("Переход в новый департамент: " + departament);
    }

    public void increaseSalary() {
        salary*=2;
    }

    @Override
    public String toString() {
        return "Employee [" + "id: " + id + ", name: " + name + 
        ", department: " + departament + ", salary: " + salary + "$]";
    }
}
 