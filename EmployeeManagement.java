import java.util.ArrayList;

public class EmployeeManagement {

    static int female = 0;
    static int shopAssistants = 0;
    static int storeManagers = 0;
    private static ArrayList<Employee> employees = new ArrayList<>();


    public static int totalEmployees() {
        return employees.size();
    }

    public static boolean idNotAlreadyInSystem(String id) {
        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    public static void addEmployee(Employee employee) {

        employees.add(employee);

        if (employee.getGender().equalsIgnoreCase("female")) {
            female++;
        }
    }

    public static void addShopAssistant(Employee shopAssistant) {

        employees.add(shopAssistant);
        shopAssistants++;

        if (shopAssistant.getGender().equalsIgnoreCase("female")) {
            female++;
        }
    }

    public static void addStoreManager(Employee storeManager) {

        employees.add(storeManager);
        storeManagers++;

        if (storeManager.getGender().equalsIgnoreCase("female")) {
            female++;
        }
    }

    public static void addStarEmployee(String id) {
        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(id)) {
                e.setStarEmployee(true);
            }
        }
    }

    public static void removeStarEmployee(String id) {
        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(id)) {
                e.setStarEmployee(false);
            }
        }
    }

    public static void removeEmployee(String id) {

        for (int i = employees.size() - 1; i >= 0; i--) {
            if (employees.get(i).getId().equalsIgnoreCase(id)) {

                if (employees.get(i).getGender().equalsIgnoreCase("female")) {
                    female--;

                    if (employees.get(i) instanceof ShopAssistant) {
                        shopAssistants--;
                    }
                    if (employees.get(i) instanceof StoreManager) {
                        storeManagers--;
                    }
                }
                employees.remove(i);
            }
        }
    }

    public static void sortNameAscending(){
        System.out.println("Employees A-Z:");
        SortByNameAscending sortByNameAscending = new SortByNameAscending();
        employees.sort(sortByNameAscending);
        for (Employee e: employees) {
            System.out.println(e);
        }
    }
    public static void sortNameDecending(){
        System.out.println("Employees Z-A:");
        SortByNameDecending sortByNameDecending = new SortByNameDecending();
        employees.sort(sortByNameDecending);
        for (Employee e: employees){
            System.out.println(e);
        }
    }


    public static void findEmployee(String id) {
        for (int i = employees.size() - 1; i >= 0; i--) {
            if (employees.get(i).getId().equalsIgnoreCase(id)) {
                System.out.println("Employee: " + employees.get(i).getName() + " Gender: " + employees.get(i).getGender() + " Id: " + employees.get(i).getId() + " Salary: " + employees.get(i).getSalary());
            }
        }
    }

    public static void showAllEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public static void showShopAssistants() {
        for (Employee e : employees) {
            if (e instanceof ShopAssistant) {
                System.out.println(e);
            }
        }
    }

    public static void showStoreManagers() {
        for (Employee e : employees) {
            if (e instanceof StoreManager) {
                System.out.println(e);
            }
        }
    }

    public static void showStarEmployees() {
        System.out.println("This is your star employees: ");
        for (Employee e : employees) {
            if (e.isStarEmployee()) {
                System.out.println(e);
            }
        }
    }

    public static void updateSalaryForEmployee(String id, double newSalary) {

        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(id)) {
                if (e instanceof Employee) {
                    (e).setSalary(newSalary);
                }
            }
        }
    }

    public static void upgradeSalesLevelForEmployee(String id, int newSalesLevel) {
        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(id)) {
                if (e instanceof ShopAssistant) {
                    ((ShopAssistant) e).setSalesLevel(newSalesLevel);
                }
            }
        }
    }

    public static void averageSalaryWomen() {
        double sum = 0;

        for (Employee e : employees) {
            if (e.getGender().equalsIgnoreCase("female")) {
                sum = sum + e.getSalary();
            }
        }
        if (female != 0) {
            System.out.println("Average salary for women is: " + (sum / female));
        }
    }

    public static void averageSalaryMen() {
        double sum = 0;

        for (Employee e : employees) {
            if (e.getGender().equalsIgnoreCase("male")) {
                sum = sum + e.getSalary();
            }
        }
        if ((totalEmployees() - female) != 0) {
            System.out.println("Average salary for men is: " + (sum / (totalEmployees() - female)));
        }
    }

    public static void averageSalaryShopAssistants() {
        double sum = 0;
        for (Employee e : employees) {
            if (e instanceof ShopAssistant) {
                sum = sum + e.getSalary();
            }
        }
        if (shopAssistants != 0) {
            System.out.println("Average salary for Shop Assistants is: " + (sum / shopAssistants));
        }
    }

    public static void averageSalaryStoreManagers() {
        double sum = 0;
        for (Employee e : employees) {
            if (e instanceof StoreManager) {
                sum = sum + e.getSalary();
            }
        }
        if (storeManagers != 0) {
            System.out.println("Average salary for Store Managers is: " + (sum / storeManagers));
        }
    }

    public static void averageInfo() {

        System.out.println("The number of women in this company is: " + female);
        System.out.println("The number of men in this company is: " + (totalEmployees() - female));

        averageSalaryWomen();
        averageSalaryMen();
        averageSalaryShopAssistants();
        averageSalaryStoreManagers();

    }

}




