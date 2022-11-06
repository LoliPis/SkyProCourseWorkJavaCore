import java.util.Scanner;

public class Main {

    public static int id = 1;
    public static EmployeeBook employeeBase = new EmployeeBook(10);

    
    public static void main(String[] args) {
        Employee ivanov = new Employee("Ivanov Ivan Ivanovich",1,32000.00f, id);
        id++;
        Employee petrov = new Employee("Petrov Petr Petrovcih",2,64348.00f, id);
        id++;
        Employee sidorov = new Employee("Sidorov Aleksey Aleksandrovich",3,123493.00f, id);
        id++;
        Employee pupkin = new Employee("Pupkin Nikita Nikitich",3,20304.00f, id);
        id++;
        Employee ruabov = new Employee("Ruabov Dmirtiy Petrovcih",4,23495.00f, id);
        id++;
        Employee mironova = new Employee("Mironova Katerina Vaddimovna",5,164039.00f, id);
        id++;
        Employee gribova = new Employee("Gribova Anastasia Mikhailovna",2,32849.00f, id);
        id++;
        employeeBase.addCustomer(ivanov);
        employeeBase.addCustomer(petrov);
        employeeBase.addCustomer(sidorov);
        employeeBase.addCustomer(pupkin);
        employeeBase.addCustomer(ruabov);
        employeeBase.addCustomer(mironova);
        employeeBase.addCustomer(gribova);
        //базовый уровень
        System.out.println(employeeBase.toString());
        float sum = employeeBase.calculateSalaryCostsPerMonth();
        System.out.println("Сумма затрат на зарплаты в месяц: " + sum);
        Employee customerWithMinSalary = employeeBase.findMinimalSalary(employeeBase.getEmployees());
        System.out.println("Информация о сотруднике с минимальной заработной платой: " + customerWithMinSalary.toString());
        Employee customerWithMaxSalary  = employeeBase.findMaximumSalary(employeeBase.getEmployees());
        System.out.println("Информация о сотруднике с максимальной заработной платой: " + customerWithMaxSalary);
        float avverageSalary = employeeBase.calculateAverageSalary();
        System.out.println("Информация о средних затратах на заработную плату: " + avverageSalary);
        System.out.println(employeeBase.getFioCustomer(employeeBase.getEmployees()));
        //сложный уровень
        float indexationPercent = 8;
        int department = 2;
        float lessThatSal = 55000f;
        float moreThatSal = 60000f;
        employeeBase.indexSalaryForAllCustomer(indexationPercent);
        System.out.println("Зарплата проиндесирована: " + employeeBase.toString());
        employeeBase.indexSalaryByDepartment(indexationPercent, department);
        System.out.println("Зарплата проиндексирована по отделу: " + employeeBase.toString());
        System.out.println("Минимальная зарпалата " + employeeBase.findMinSalaryByDepart(employeeBase.getEmployees() ,department));
        System.out.println("Максимальная зарпалата " + employeeBase.findMaxSalaryByDepart(employeeBase.getEmployees(), department));
        System.out.println("Сумма трат по отделу равна: " + employeeBase.calculateCostsByDep(employeeBase.getEmployees(), department));
        System.out.println("Средняя сумма трат по отделу равна: "
                + employeeBase.calculateAverageByDepartment(employeeBase.getEmployees(), department));
        System.out.println(employeeBase.getFioCustomerByDep(employeeBase.getEmployees(), department));
        System.out.println(employeeBase.getFioCustomerLessSal(lessThatSal));
        System.out.println(employeeBase.getFioCustomerMoreSal(moreThatSal));
        //очень сложный уровень
        employeeBase.deleteCustomer("Ivanov Ivan Ivanovich", 1);
        float changedSalary = 67094.0f;
        int changedId = 2;
        employeeBase.setSalaryAndIdByFIO("Ivanov Ivan Ivanovich" ,changedSalary, changedId);
        System.out.println(employeeBase.printCustomerByDepart());
    }
}