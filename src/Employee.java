public class Employee {
    private String fio;
    private int department;
    private float salary;
    private int id;
    private static int counter = 1;

    public Employee(String fio, int department, float salary) {
        this.fio = fio;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    public String getFio() {
        return fio;
    }

    public int getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Номер ID: " + id + ". ФИО сотрудника: " + fio + ". Отдел: " + department + ". Заработная плата: " + salary;
    }

}
