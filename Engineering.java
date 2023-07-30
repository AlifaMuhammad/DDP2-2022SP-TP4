import java.util.List;

public class Engineering extends Division{

    public Engineering(int baseSalary) {
        super(baseSalary);
    }
    
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);
        // TODO: Lengkapi
        System.out.println(employee.getClass().getSimpleName() + " " + employee.getName() + " berhasil ditambahkan ke divisi Engineering");
    }

    @Override
    public String toString() {
        int managerCount = 0;
        for (Employee employee : employeeList) {
            if (employee instanceof Manager) {
                managerCount++;
            }
        }
        return "Divisi Engineering memiliki " + employeeList.size() + " karyawan dengan " + managerCount + " manager.";
    }
}
