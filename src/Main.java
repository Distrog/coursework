public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.add("Иванов Иван Иванович", 2, 15000);
        employeeBook.add("Сергеев Сергей Сергеевич", 1, 22000);
        employeeBook.add("Петро Петр Петрович", 2, 33000);
        employeeBook.add("Валерьев Валерий Валерьевич", 4, 13000);
        employeeBook.add("Кириллов Кирилл Кириллович", 1, 24000);
        employeeBook.add("Дмитриев Дмитрий Дмитриевич", 3, 45000);
        employeeBook.add("Давидов Давид Давидович", 5, 32000);
        employeeBook.add("Васильев Василий Васильевич", 5, 44000);
        employeeBook.add("Ольгина Ольга Александровна", 4, 38000);
        employeeBook.add("Димитрова Валерия Юрьевна", 3, 27000);
        employeeBook.delete(2);
        employeeBook.getInfo();
        System.out.println(employeeBook.sumSalary());
        System.out.println(employeeBook.getEmployeeWithMinSalary());
        employeeBook.getInfoForDepartments();
    }
}