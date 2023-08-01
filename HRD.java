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

        return "Divisi HRD";
    }
}
