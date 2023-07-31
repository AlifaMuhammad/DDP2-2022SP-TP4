import java.util.ArrayList;
import java.util.List;

public class Division {
    // TODO: Tambahkan modifier untuk atribut
    private int baseSalary;
    List<Employee> employeeList;
    private List<Manager> managerList;
    

    // TODO: Lengkapi constructor
    public Division(int baseSalary) {
        this.baseSalary = baseSalary;
        this.employeeList = new ArrayList<>();
        this.managerList = new ArrayList<>();
    }

    /**
     * method untuk menambah employee
     * @param employee
     */
    public void addEmployee(Employee employee) {
        employee.setDivision(this); 
        employee.setDivisionName(this.toString()); 
        employeeList.add(employee);
        if (employee instanceof Manager) {
            managerList.add((Manager) employee);
        }
    }
    // Tambahkan getter & setter lainnya sesuai kebutuhan

    public int getbaseSalary(){
        return baseSalary;
    }

    public void setbaseSalary(int baseSalary){
        this.baseSalary = baseSalary;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Manager> getManagerList() {
        return managerList;
    }

    @Override
public String toString() {
    if (this instanceof HRD) {
        return "HRD";
    } else if (this instanceof Marketing) {
        return "Marketing";
    } else if (this instanceof Design) {
        return "Design";
    } else if (this instanceof Engineering) {
        return "Engineering";
    } else {
        return "Unknown Division";
    }
}
}
