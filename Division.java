import java.util.ArrayList;
import java.util.List;

public class Division {
    // TODO: Tambahkan modifier untuk atribut
    private int baseSalary;
    List<Employee> employeeList;
    

    // TODO: Lengkapi constructor
    public Division(int baseSalary) {
        this.baseSalary = baseSalary;
        this.employeeList = new ArrayList<>();
    }

    /**
     * method untuk menambah employee
     * @param employee
     */
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
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
}
