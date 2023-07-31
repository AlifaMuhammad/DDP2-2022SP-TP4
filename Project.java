import java.util.ArrayList;
import java.util.List;

public class Project {
    // TODO: Tambahkan modifier untuk atribut
    private String name;
    Manager projectLeader;
    List<Employee> memberList;

    // TODO: Lengkapi constructor
    public Project(String name) {
        this.name = name;
        this.memberList = new ArrayList<>();
    }

    /**
     * method untuk menambah employee
     * @param employee
     */
    public void addMember(Employee employee) {
        memberList.add(employee);
    }


    /**
     * method untuk menghapus employee
     * @param employee
     */
    public void removeMember(Employee employee) {
        memberList.remove(employee);
    }

    public String getName(){
        return name;
    }

    public void setProjectLeader(Manager projectLeader) {
        this.projectLeader = projectLeader;
    }

    public Manager getProjectLeader(){
        return projectLeader;
    }

    public List<Employee> getMemberList() {
        return memberList;
    }
}
