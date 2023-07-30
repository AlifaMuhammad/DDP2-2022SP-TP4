import java.util.List;

public class Design extends Division {

    public Design(int baseSalary) {
        super(baseSalary);
    }
    
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);
        // TODO: Lengkapi
    }

    @Override
    public String toString() {
        int managerCount = 0;
        for (Employee employee : employeeList) {
            if (employee instanceof Manager) {
                managerCount++;
            }
        }
        return "Divisi Design memiliki " + employeeList.size() + " karyawan dengan " + managerCount + " manager.";
    }
}
