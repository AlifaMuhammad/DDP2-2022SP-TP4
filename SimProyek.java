import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimProyek {
    List<Project> projectList = new ArrayList<>();
    List<Employee> employeeList = new ArrayList<>();
    List<Division> divisionList = new ArrayList<>();

    public static void main(String[] args) {
        SimProyek app = new SimProyek();
        app.mockDivisionData();

        // Gunakan ini jika ingin menggunakan data awalan
        // Tidak wajib digunakan
        app.mockData();

        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Selamat datang di SimProyek. Berikut adalah daftar proyek yang terdaftar dalam sistem.");
        
        // TODO: Tampilkan daftar proyek, lengkapi kode di dalam method printProjectList()
        app.printProjectList();

        do {
            app.printMenu();

            choice = scanner.nextInt();
            scanner.nextLine();

            int nomorPilihan;
            int nomorAnggota;
            String namaKaryawan;
            String jabatan;
            int lamaBekerja;
            double bonusGaji;
            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama proyek: ");
                    String projectName = scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.createProject(projectName);

                    System.out.println();
                    break;
                case 2:
                    System.out.println("Berikut adalah daftar proyek yang dapat Anda pilih: ");
                    app.printProjectListNumberOnly();

                    System.out.print("Pilih nomor proyek: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan nama karyawan yang ingin ditambahkan: ");
                    namaKaryawan = scanner.nextLine();
                    
                    // TODO: Kerjakan di dalam method ini
                    app.addProjectMember(nomorPilihan, namaKaryawan);

                    System.out.println();
                    break;
                case 3:
                    System.out.println("Berikut adalah daftar proyek yang dapat Anda pilih: ");
                    app.printProjectListNumberOnly();

                    System.out.print("Pilih nomor proyek: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    app.printDivisionDetail(nomorPilihan);

                    System.out.print("Masukkan nomor anggota yang ingin dihapus: ");
                    nomorAnggota = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.deleteProjectMember(nomorPilihan, nomorAnggota);

                    System.out.println();
                    break;
                case 4:
                    System.out.println("Berikut adalah daftar proyek yang dapat Anda pilih: ");
                    app.printProjectListNumberOnly();

                    System.out.print("Pilih nomor proyek: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.projectDetail(nomorPilihan);

                    System.out.println();
                    break;
                case 5:
                    System.out.println("Daftar proyek pada sistem SimProyek");
                    app.printProjectList();

                    System.out.println();
                    break;
                case 6:
                    System.out.print("Nama karyawan: ");
                    namaKaryawan = scanner.nextLine();

                    System.out.print("Jabatan: ");
                    jabatan = scanner.nextLine();

                    System.out.print("Lama bekerja (tahun): ");
                    lamaBekerja = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Bonus gaji: ");
                    bonusGaji = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Divisi:");
                    System.out.println("1. HRD");
                    System.out.println("2. Marketing");
                    System.out.println("3. Design");
                    System.out.println("4. Engineer");

                    System.out.print("Pilih divisi: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.addEmployee(namaKaryawan, jabatan, lamaBekerja, bonusGaji, nomorPilihan);

                    System.out.println();
                    break;
                case 7:
                    System.out.println("Daftar karyawan pada sistem SimProyek ");
                    System.out.println("Nama - Divisi - Gaji - Proyek ");
                    for (int i = 0; i < app.employeeList.size(); i++) {
                        System.out.printf("%d. %s - Divisi %s - %d - %s \n", 
                            i+1, 
                            // TODO: lengkapi logika di masing-masing method
                            app.employeeList.get(i).getName(),
                            app.employeeList.get(i).getDivisionName(),
                            app.employeeList.get(i).calculateSalary(),
                            app.employeeList.get(i).getProjectsString()
                        );
                    }

                    System.out.println();
                    break;
                case 8:
                    System.out.println("Berikut adalah daftar divisi pada sistem SimProyek: ");
                    System.out.println("1. HRD");
                    System.out.println("2. Marketing");
                    System.out.println("3. Design");
                    System.out.println("4. Engineer");


                    System.out.print("Pilih nomor divisi: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: tampilkan detail divisi
                    app.printDivisionDetail(nomorPilihan);

                    System.out.println();
                    break;
                case 99:
                    System.out.println("Terima kasih telah menggunakan SimProyek.");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (choice != 99);
        scanner.close();
    }

    // Silahkan tambahkan method lain yang dirasa dapat membantu
    /**
     * method untuk mengeprint projek
     */
    private void printProjectListNumberOnly() {
        int i = 1;
        for (Project project : projectList) {
            System.out.println(i + ". " + project.getName());
            i++;
        }
    }

    /**
     * method untuk menampilkan detail proyek
     * @param nomorPilihan
     */
    private void printDivisionDetail(int nomorPilihan) {
        Division division = divisionList.get(nomorPilihan - 1);
        System.out.println("Divisi " + division + " memiliki " + division.getEmployeeList().size() + " karyawan dengan " + division.getManagerList().size() + " manager.");
        int i = 1;

        for (Employee employee : division.getEmployeeList()) {
            System.out.println(i + ". " + employee.getName() + " - " +  employee.calculateSalary() + " - " + employee.getProjectsString());
            i++;
        }
        }

    
    /**
     * method untuk menentukan employee masuk ke divisi mana
     * @param namaKaryawan
     * @param jabatan
     * @param lamaBekerja
     * @param bonusGaji
     * @param nomorDivisi
     */
    private void addEmployee(String namaKaryawan, String jabatan, int lamaBekerja, double bonusGaji, int nomorDivisi) {
        Division division = divisionList.get(nomorDivisi - 1);
        Employee employee;
        if (jabatan.equalsIgnoreCase("Manager")) {
            employee = new Manager(namaKaryawan, lamaBekerja, bonusGaji);
        } else if (jabatan.equalsIgnoreCase("Intern")) {
            employee = new Intern(namaKaryawan, lamaBekerja, bonusGaji);
        } else {
            employee = new Employee(namaKaryawan, lamaBekerja, bonusGaji);
        }

        employee.setDivision(division);

        employeeList.add(employee);
        division.addEmployee(employee);
    }


    /**
     * method untuk mengeprint divisi dan anggotanya
     */
    private void printProjectList() {
        int i = 1;
        for (Project project : projectList) {
            System.out.println(i + ". " + project.getName());
            if (project.getProjectLeader() != null) {
                System.out.println("   Leader: " + project.getProjectLeader().getName());
            } else {
                System.out.println("   Leader: Tidak memiliki leader");
            }
            System.out.println("   Jumlah anggota: " + project.getMemberList().size());
            i++;
        }
    }


    /**
     * method untuk ngeprint detail divisi
     * @param nomorPilihan
     */
    private void projectDetail(int nomorPilihan) {
        Project project = projectList.get(nomorPilihan - 1);
        System.out.println("Proyek " + project.getName() + " Detail:");

        if (project.getProjectLeader() != null) {
            System.out.println("Leader: " + project.getProjectLeader().getName());
        } else {
            System.out.println("Leader: Tidak memiliki leader");
        }

        System.out.println("Anggota:");
        int i = 1;
        for (Employee member : project.getMemberList()) {
            System.out.println(i + ". " + member.getName() + " - " + member.getDivisionname());
            i++;
        }
    }

    /**
     * method untuk menghapus employee
     * @param nomorPilihan
     * @param nomorAnggota
     */
    private void deleteProjectMember(int nomorPilihan, int nomorAnggota) {
        Project project = projectList.get(nomorPilihan - 1);
        Employee member = project.getMemberList().get(nomorAnggota - 1);
        project.removeMember(member);
    }

    /**
     * method untuk menambah employee
     * @param nomorPilihan
     * @param namaKaryawan
     */
    private void addProjectMember(int nomorPilihan, String namaKaryawan) {
        Project project = projectList.get(nomorPilihan - 1);
        Employee employee = null;
        for (Employee emp : employeeList) {
            if (emp.getName().equalsIgnoreCase(namaKaryawan)) {
                employee = emp;
                break;
            }
        }
        if (employee != null) {
            project.addMember(employee);
            System.out.println("Karyawan " + employee.getName() + " berhasil ditambahkan ke dalam " + project.getName());
        }
        
    }

    /**
     * method untuk menambah proyek
     * @param projectName
     */
    private void createProject(String projectName) {
        Project project = new Project(projectName);
        projectList.add(project);
        System.out.println("Proyek " + projectName + " berhasil ditambahkan ke dalam sistem.");
    }

    private void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah proyek        ");
        System.out.println("2. Tambah anggota proyek");
        System.out.println("3. Hapus anggota proyek ");
        System.out.println("4. Detail proyek        ");
        System.out.println("5. Daftar proyek        ");
        System.out.println("6. Tambah karyawan      ");
        System.out.println("7. Daftar karyawan      ");
        System.out.println("8. Detail divisi        ");
        System.out.println("99. Keluar              ");
        System.out.print("Pilih menu: ");
    }

    private void mockDivisionData() {
        Division hrd = new HRD(5000000);
        Division marketing = new Marketing(7000000);
        Division design = new Design(6000000);
        Division engineering = new Engineering(8000000);

        divisionList.add(hrd);
        divisionList.add(marketing);
        divisionList.add(design);
        divisionList.add(engineering);
    }

    private void mockData() {
        Division hrd = this.divisionList.get(0);
        Division marketing = this.divisionList.get(1);
        Division design = this.divisionList.get(2);

        Manager budi = new Manager("Budi", 3, 0.2);
        Manager ica = new Manager("Ica", 5, 0.3);
        Manager andi = new Manager("Andi", 4, 0.25);

        Employee udin = new Employee("Udin", 2, 0.1);
        Employee fira = new Employee("Fira", 1, 0.05);
        Employee opet = new Employee("Opet", 3, 0.15);
        Employee mirna = new Employee("Mirna", 4, 0.2);
        Employee asep = new Employee("Asep", 2, 0.1);
        Employee yudi = new Employee("Yudi", 1, 0.05);
        Employee deni = new Employee("Deni", 3, 0.15);
        Employee tina = new Employee("Tina", 2, 0.1);

        this.employeeList.add(budi);
        this.employeeList.add(ica);
        this.employeeList.add(andi);
        this.employeeList.add(udin);
        this.employeeList.add(fira);
        this.employeeList.add(opet);
        this.employeeList.add(mirna);
        this.employeeList.add(asep);
        this.employeeList.add(yudi);
        this.employeeList.add(deni);
        this.employeeList.add(tina);
        
        hrd.addEmployee(budi);
        hrd.addEmployee(udin);
        hrd.addEmployee(fira);
        hrd.addEmployee(opet);

        marketing.addEmployee(ica);
        marketing.addEmployee(mirna);
        marketing.addEmployee(asep);
        marketing.addEmployee(yudi);

        design.addEmployee(andi);
        design.addEmployee(deni);
        design.addEmployee(tina);

        Project ufoProject = new Project("Proyek UFO");
        Project saladProject = new Project("Proyek Franchise Salad Buah Tanpa Semangka dan Melon");
        Project compfestProject = new Project("Website COMPFEST");

        ufoProject.setProjectLeader(budi);
        saladProject.setProjectLeader(ica);
        compfestProject.setProjectLeader(andi);

        ufoProject.addMember(budi);
        ufoProject.addMember(udin);
        ufoProject.addMember(fira);
        ufoProject.addMember(opet);

        saladProject.addMember(ica);
        saladProject.addMember(mirna);
        saladProject.addMember(asep);
        saladProject.addMember(yudi);

        compfestProject.addMember(andi);
        compfestProject.addMember(deni);
        compfestProject.addMember(tina);

        this.projectList.add(ufoProject);
        this.projectList.add(saladProject);
        this.projectList.add(compfestProject);
    }
}
