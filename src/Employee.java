public class Employee {
    final private String fIO;
    private int department;
    private double salary;
    final private int id;
    private static int count = 0;

    public Employee(String fIO, int department, double salary) {
        this.fIO = fIO;
        this.department = department;
        this.salary = salary;
        count++;
        id = count;
    }

    public String getFIO() {
        return fIO;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return fIO + ". Отдел: " + department + ". Зарплата: " + salary + ". Табельный номер: "
                + id + ".";
    }
}
