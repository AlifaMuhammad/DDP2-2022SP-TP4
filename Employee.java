import java.util.ArrayList;
import java.util.List;

public class Employee {
    // TODO: Tambahkan modifier untuk atribut
    private String divisionname;
    protected String name;
    protected int yearsOfExperience;
    protected double salaryMultiplier;
    public Division division;
    List<Project> projects;

    // TODO: Lengkapi constructor
    public Employee(String name, int yearsOfExperience, double salaryMultiplier) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.salaryMultiplier = salaryMultiplier;
        this.projects = new ArrayList<>();
    }

    /**
     * method untuk menghitung gaji
     * @return
     */
    public int calculateSalary() {
        if (this.division != null) {
            double hasil = division.getbaseSalary() * (1 + salaryMultiplier + yearsOfExperience/10);
            int value = (int)hasil;
            return value; 
        }
        else {
            return division.getbaseSalary();
        }    
            
    }
    /**
     * method untuk menambah proyek
     * @param project
     */
    public void addProject(Project project){
        if (projects.size() >= 2) {
            System.out.println("Karyawan " + name + " hanya dapat mengikuti dua proyek.");
        }
        projects.add(project);
    }


    public int getSalary() {
        if (division != null) {
            return division.getbaseSalary();
        } else {
            return 0;
        }
    }


    /**
     * method untuk mendapatkan string daftar proyek dan me-return string 
     * @return
     */
    public StringBuilder getProjectsString() {
        StringBuilder projectsStr = new StringBuilder();
            for (Project project : projects) {
                projectsStr.append(project.getName()).append(", ");
            }
            if (projectsStr.length() > 2) {
                projectsStr.setLength(projectsStr.length() - 2);
            }
        return projectsStr;

    }

    public String getName() {
        return name;
    }

    public void setDivision(Division division){
        this.division = division;
    }

    public Division getDivisionname(){
        return division;
    }

    public String getDivisionName() {
        return divisionname;
    }

    public void setDivisionName(String divisionName) {
        this.divisionname = divisionName;
    }


    // Tambahkan getter & setter lainnya sesuai kebutuhan
}
