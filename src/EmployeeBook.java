public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook() {
        employees = new Employee[10];
    }

    public void getInfo() {
        for (var emp : employees) {
            if (emp != null) {
                System.out.println(emp);
            }
        }
    }

    public double sumSalary() {
        double sum = 0;
        for (var emp : employees) {
            try {
                sum += emp.getSalary();
            } catch (NullPointerException ex) {
                ex.fillInStackTrace();
            }
        }
        return sum;
    }

    public Employee getEmployeeWithMinSalary() {
        Employee min = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null && (employees[i].getSalary() < min.getSalary())) {
                min = employees[i];
            }
        }
        return min;
    }

    public Employee getEmployeeWithMaxSalary() {
        Employee max = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null && (employees[i].getSalary() > max.getSalary())) {
                max = employees[i];
            }
        }
        return max;
    }

    public double averageSalary() {
        int length = 0;
        for (var emp : employees) {
            try {
                length++;
            } catch (NullPointerException ex) {
                ex.fillInStackTrace();
            }
        }
        return sumSalary() / length;
    }

    public void getFIOALLEmployees() {
        for (var emp : employees) {
            if (emp != null) {
                System.out.println(emp.getFIO());
            }
        }
    }

    public void IndexSalary(int percent) {
        for (var emp : employees) {
            if (emp != null) {
                emp.setSalary(emp.getSalary() + emp.getSalary() / 100 * percent);
            }
        }
    }

    public Employee getEmployeeWithMinSalary(int department) {
        try {
            if (department < 1 || department > 5) {
                throw new IllegalArgumentException("Не верный номер отдела");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        Employee min = null;
        for (var emp : employees) {
            if (emp != null && emp.getDepartment() == department && (min == null || min.getSalary() > emp.getSalary())) {
                min = emp;
            }
        }
        return min;
    }

    public Employee getEmployeeWithMaxSalary(int department) {
        try {
            if (department < 1 || department > 5) {
                throw new IllegalArgumentException("Не верный номер отдела");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        Employee max = null;
        for (var emp : employees) {
            if (emp != null && emp.getDepartment() == department && (max == null || max.getSalary() < emp.getSalary())) {
                max = emp;
            }
        }
        return max;
    }

    public double sumSalary(int department) {
        try {
            if (department < 1 || department > 5) {
                throw new IllegalArgumentException("Не верный номер отдела");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        double sum = 0;
        for (var emp : employees) {
            if (emp != null && emp.getDepartment() == department) {
                sum += emp.getSalary();
            }
        }
        return sum;
    }

    public void IndexSalary(int percent, int department) {
        try {
            if (department < 1 || department > 5) {
                throw new IllegalArgumentException("Не верный номер отдела");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        for (var emp : employees) {
            if (emp != null && emp.getDepartment() == department) {
                emp.setSalary(emp.getSalary() + emp.getSalary() / 100 * percent);
            }
        }
    }

    public void getInfo(int department) {
        try {
            if (department < 1 || department > 5) {
                throw new IllegalArgumentException("Не верный номер отдела");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        for (var emp : employees) {
            if (emp != null && emp.getDepartment() == department) {
                System.out.println(emp.getFIO() + ". Зарплата: " + emp.getSalary()
                        + ". Табельный номер: " + emp.getId() + ".");
            }
        }
    }

    public void getEmployeesWithOverSalary(double salary) {
        for (var emp : employees) {
            if (emp != null && emp.getSalary() > salary) {
                System.out.println(emp.getFIO() + ". Зарплата: " + emp.getSalary()
                        + ". Табельный номер: " + emp.getId() + ".");
            }
        }
    }

    public void getEmployeesWithUnderSalary(double salary) {
        for (var emp : employees) {
            if (emp != null && emp.getSalary() < salary) {
                System.out.println(emp.getFIO() + ". Зарплата: " + emp.getSalary()
                        + ". Табельный номер: " + emp.getId() + ".");
            }
        }
    }

    public void add(String fIO, int department, double salary) {
        Employee newEmp = new Employee(fIO, department, salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmp;
                return;
            }
        }
        int oldLength = employees.length;
        Employee[] temp = new Employee[employees.length * 2];
        System.arraycopy(employees, 0, temp, 0, employees.length);
        employees = temp;
        employees[oldLength] = newEmp;
    }

    public void delete(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("Нет работника с таким id.");
    }

    public void delete(String fIO) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFIO().equals(fIO)) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("Нет работника с такими ФИО.");
    }

    public void change(String fIO, int department, double salary) {
        try {
            if (department < 1 || department > 5) {
                throw new IllegalArgumentException("Не верный номер отдела");
            }
            for (var emp : employees) {
                if (emp != null && emp.getFIO().equals(fIO)) {
                    emp.setDepartment(department);
                    emp.setSalary(salary);
                    return;
                }
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void getInfoForDepartments() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Отдел №" + i + ":");
            for (Employee emp : employees) {
                if (emp != null && emp.getDepartment() == i) {
                    System.out.println(emp.getFIO());
                }
            }
        }
    }

}