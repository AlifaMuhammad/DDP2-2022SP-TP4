public class Manager extends Employee {

    private Project project;

    public Manager(String name, int yearsOfExperience, double salaryMultiplier) {
        super(name, yearsOfExperience, salaryMultiplier);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public int getSalary() {
        if (division != null) {
            double baseSalary = division.getbaseSalary();
            double totalSalary = baseSalary * (1 + salaryMultiplier + yearsOfExperience / 10);
            return (int) totalSalary;
        } else {
            return 0;
        }
        }

    @Override
    public String toString() {
        return super.toString();
    }
}