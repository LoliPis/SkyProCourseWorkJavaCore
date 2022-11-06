public class EmployeeBook {
    private Employee[] employees;
    private static int customerCount = 0;
    private static int  departmentCustomer = 0;

    public EmployeeBook(int size) {
        this.employees = new Employee[size];
    }

    public Employee[] getEmployees() {
        return employees;
    }



    public void addCustomer(Employee employee){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                customerCount++;
                return;
            }

        }
    }

    public void deleteCustomer(String fio, int id){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && (employees[i].getFio() == fio || employees[i].getId() == id)) {
                employees[i] = null;
                customerCount--;
                return;
            }

        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                str += employees[i].toString() + "\n";
            }
        }
        return "Данные по сотрудникам:\n" + str;
    }


    public float calculateSalaryCostsPerMonth(){
        float sumOfSalary = 0f;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sumOfSalary += employees[i].getSalary();
            }
        }
        return sumOfSalary;
    }

    public Employee findMinimalSalary(Employee[] employees) {
        float minSalary = Float.POSITIVE_INFINITY;
        Employee customerWithMinimalSalary = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    customerWithMinimalSalary = employees[i];
                }
            }
        }
        return customerWithMinimalSalary;
    }

    public Employee findMaximumSalary(Employee[] employees)  {
        float maxSalary = Float.NEGATIVE_INFINITY;
        Employee customerWithMaximalSalary = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    customerWithMaximalSalary = employees[i];
                }
            }
        }
        return customerWithMaximalSalary;
    }

    public float calculateAverageSalary() {
        float avverageSalary = calculateSalaryCostsPerMonth()/customerCount;
        return avverageSalary;
    }

    public String getFioCustomer(Employee[] employee)  {
        String str = "";
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                str += employee[i].getFio() + "\n";
            }
        }
        return "Данные по ФИО сотрудников:\n" + str;
    }

    public Employee[] indexSalaryForAllCustomer(float indexationPercent) {
        float indexationShare = indexationPercent/100;
        float indexationSalaryShare = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                indexationSalaryShare = employees[i].getSalary() * indexationShare;
                employees[i].setSalary(employees[i].getSalary() + indexationSalaryShare);
            }
        }
        return employees;
    }


    public Employee[] filterCustomerByDepartment(Employee[] employees, int department) {
        Employee[] customerByDepartment = new Employee[employees.length];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i]  != null) {
                if (employees[i].getDepartment() == department) {
                    customerByDepartment[i] =  employees[i];
                    departmentCustomer++;
                }
            }
        }
        return customerByDepartment;
    }

    public float calculateCostsByDep(Employee[] employees, int department) {
        float sumOfSalary = 0f;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                sumOfSalary += employees[i].getSalary();
            }
        }
        return sumOfSalary;
    }

    public void indexSalaryByDepartment(float indexationPercent, int department) {
        float indexationShare = indexationPercent/100;
        float indexationSalaryShare = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                    indexationSalaryShare = employees[i].getSalary() * indexationShare;
                    employees[i].setSalary(employees[i].getSalary() + indexationSalaryShare);
            }
        }
    }

    public Employee findMinSalaryByDepart(Employee[] customerByDepartment, int department){
        Employee[] minSalByDep = filterCustomerByDepartment(customerByDepartment, department);
        return findMinimalSalary(minSalByDep);
    }

    public Employee findMaxSalaryByDepart(Employee[] customerByDepartment,int department){
        Employee[] maxSalByDep = filterCustomerByDepartment(customerByDepartment, department);
        return findMaximumSalary(maxSalByDep);
    }

    public float calculateAverageByDepartment(Employee[] employees, int department) {
         float avverageSalByDep = 0;
         avverageSalByDep = calculateCostsByDep(employees, department)  / departmentCustomer;
        return avverageSalByDep;
    }

    public String getFioCustomerByDep(Employee[] employee, int department)  {
        String str = "";
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == department) {
                str += "Номер ID: " + employee[i].getId() + ". ФИО: " + employee[i].getFio() + ". Заработная плата: " +
                        employee[i].getSalary() + "\n";
            }
        }
        return "Данные по cотрудникам отдела номер " + department + ":\n" + str;
    }

    public String getFioCustomerLessSal(float salary)  {
        String str = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salary) {
                str += "Номер ID: " + employees[i].getId() + ". ФИО: " + employees[i].getFio() + ". Заработная плата: " +
                        employees[i].getSalary() + "\n";
            }
        }
        return "Данные по cотрудникам с зарплатой ниже " + salary + ": \n" + str;
    }

    public String getFioCustomerMoreSal(float salary)  {
        String str = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= salary) {
                str += "Номер ID: " + employees[i].getId() + ". ФИО: " + employees[i].getFio() + ". Заработная плата: " +
                        employees[i].getSalary() + "\n";
            }
        }
        return "Данные по cотрудникам с зарплатой больше или равно " + salary + ": \n" + str;
    }

    public void setSalaryAndIdByFIO(String fio, float changedSal, int changedId) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFio() ==  fio) {
                employees[i].setSalary(changedSal);
                employees[i].setId(changedId);
            }
        }
    }
    
    public String printCustomerByDepart()  {
        String endStr = "";
        for (int department = 1;  department < 6; department++) {
            Employee[] fewerf = filterCustomerByDepartment(employees, department);
                endStr += "Отдел номер " + department + ": \n" + getFioCustomer(fewerf) ;
            }
        return endStr;
    }
}
