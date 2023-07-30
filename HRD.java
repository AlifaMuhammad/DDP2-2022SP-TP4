import java.util.List;

public class HRD extends Division {

    public HRD(int baseSalary) {
        super(baseSalary);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    
    @Override
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);
    }

    @Override
    public String toString() {
        int managerCount = 0;
        for (Employee employee : employeeList) {
            if (employee instanceof Manager) {
                managerCount++;
            }
        }
        return "Divisi HRD memiliki " + employeeList.size() + " karyawan dengan " + managerCount + " manager.";
    }
}
