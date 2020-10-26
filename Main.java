import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    static boolean loop = true;

    public static void main(String[] args) {

        showMenu();

        while (loop) {
            menu();
        }
    }

    public static void showMenu() {
        System.out.println("\n");
        System.out.println("=============================================");
        System.out.println(" Welcome to your Employee Management System ");
        System.out.println("=============================================");
        System.out.println("1. Add new employee");
        System.out.println("2. Add new employee by category Shop Assistant");
        System.out.println("3. Add new employee by category Store Manager");
        System.out.println("4. Remove employee");
        System.out.println("5. Update employee's salary");
        System.out.println("6. Upgrade employee's sales level");
        System.out.println("7. Show all employees");
        System.out.println("8. Show all Shop Assistants only");
        System.out.println("9. Show all Store Managers only");
        System.out.println("10. Search for employee by identification number");
        System.out.println("11. Get average statistics among employees");
        System.out.println("12. Set star employee");
        System.out.println("13. Show star employees only");
        System.out.println("14. Remove star employee");
        System.out.println("15. Sort employee by name ascending/stigande A-Z");
        System.out.println("16. Sort employee by name decending/fallande Z-A");
        System.out.println("0. Exit");
    }

    //Metod för att fånga exceptions vid inmatning av siffror!
    public static int readInt(String question) {
    int num = 0;
    boolean loop1=true;

    while (loop1) {
        System.out.println(question);
        try {
            num = scan.nextInt();
            loop1=false;
        } catch (InputMismatchException e) {
            System.out.println("Wrong input, try again");
        }
        scan.nextLine();
    }
    return num;
    }


    public static void menu() {

        int choice = readInt("Enter your choice:");

        switch (choice) {
            case 0:
                loop = false;
                break;
            case 1:
                add();
                break;
            case 2:
                addShopAssistant();
                break;
            case 3:
                addStoreManager();
                break;
            case 4:
                removeEmployee();
                break;
            case 5:
                updateSalary();
                break;
            case 6:
                upgradeSalesLevel();
                break;
            case 7:
                EmployeeManagement.showAllEmployees();
                break;
            case 8:
                EmployeeManagement.showShopAssistants();
                break;
            case 9:
                EmployeeManagement.showStoreManagers();
                break;
            case 10:
                search();
                break;
            case 11:
                EmployeeManagement.averageInfo();
                break;
            case 12:
                addStar();
                break;
            case 13:
               EmployeeManagement.showStarEmployees();
                break;
            case 14:
                removeStar();
                break;
            case 15:
                EmployeeManagement.sortNameAscending();
                break;
            case 16:
                EmployeeManagement.sortNameDecending();
            default:
                System.out.println("Please chose one of the options listed above.");
                break;
        }
    }

    private static void add() {

        System.out.print("Enter identification number of employee: ");
        String id = scan.nextLine();

        if (EmployeeManagement.idNotAlreadyInSystem(id)) {

            System.out.print("Enter name: ");
            String name = scan.nextLine();

            System.out.print("Enter gender (female/male): ");
            String gender = scan.nextLine();

            boolean loop2 = true;

            while (loop2) {

                System.out.print("Enter salary: ");
                double salary = scan.nextDouble();
                scan.nextLine();

                if (salary <= 0) {
                    System.out.println("Unable to give salary a negative value.");
                }
                if (salary > 0) {
                    loop2 = false;

                    Employee employee = new Employee(name, gender, id, salary);

                    EmployeeManagement.addEmployee(employee);
                    System.out.println("The employee is now registered.");
                }
            }

        } else {
            System.out.println("The identification number is already in the system. Unable to register the employee. ");
        }
    }

    private static void addShopAssistant() {

        System.out.print("Enter identification number of Shop Assistant: ");
        String id = scan.nextLine();

        if (EmployeeManagement.idNotAlreadyInSystem(id)) {

            System.out.print("Enter name: ");
            String name = scan.nextLine();

            System.out.print("Enter gender (female/male): ");
            String gender = scan.nextLine();

            System.out.print("Enter sales level of employee (1-5): ");
            int salesLevel = scan.nextInt();
            scan.nextLine();

            boolean loop2 = true;

            while (loop2) {

                System.out.print("Enter salary: ");
                double salary = scan.nextDouble();
                scan.nextLine();

                if (salary <= 0) {
                    System.out.println("Unable to give salary a negative value.");
                }
                if (salary > 0) {
                    loop2 = false;

                    ShopAssistant shopAssistant = new ShopAssistant(name, gender, id, salary, salesLevel);

                    EmployeeManagement.addShopAssistant(shopAssistant);
                    System.out.println("The employee is now registered.");

                }
            }
        } else {
            System.out.println("The identification number is already in the system. Unable to register the employee. ");
        }
    }

    private static void addStoreManager() {

        System.out.print("Enter identification number of Store Manager: ");
        String id = scan.nextLine();

        if (EmployeeManagement.idNotAlreadyInSystem(id)) {

            System.out.print("Enter name: ");
            String name = scan.nextLine();

            System.out.print("Enter gender (female/male): ");
            String gender = scan.nextLine();

            System.out.print("Enter intercom phone number: ");
            String phoneNo = scan.nextLine();

            System.out.print("Enter email address: ");
            String email = scan.nextLine();

            boolean loop2 = true;

            while (loop2) {

                System.out.print("Enter salary: ");
                double salary = scan.nextDouble();
                scan.nextLine();

                if (salary <= 0) {
                    System.out.println("Unable to give salary a negative value.");
                }
                if (salary > 0) {
                    loop2 = false;

                    StoreManager storeManager = new StoreManager(name, gender, id, salary, phoneNo, email);

                    EmployeeManagement.addStoreManager(storeManager);
                    System.out.println("The employee is now registered.");
                }
            }

        } else {
            System.out.println("The identification number is already in the system. Unable to register the employee. ");
        }
    }

    private static void removeEmployee() {

        System.out.print("Enter employee's identification number to remove: ");
        String id = scan.nextLine();

        EmployeeManagement.removeEmployee(id);

    }

    private static void updateSalary() {

        System.out.print("Enter identification number of employee to update salary: ");
        String id = scan.nextLine();
        EmployeeManagement.findEmployee(id);

        boolean loop2 = true;

        while (loop2) {

            System.out.print("Enter new salary: ");
            double newSalary = scan.nextDouble();
            scan.nextLine();

            if (newSalary <= 0) {
                System.out.println("Unable to give salary a negative value.");
            }
            if (newSalary > 0) {
                loop2 = false;

                System.out.print("\nSalary update successfully completed.");

                EmployeeManagement.updateSalaryForEmployee(id, newSalary);

            }
        }
    }

    private static void upgradeSalesLevel() {
        System.out.print("Enter identification number of employee to upgrade sales level: ");
        String id = scan.nextLine();
        EmployeeManagement.findEmployee(id);

        System.out.print("Enter new sales level for employee (1-5):");
        int newSalesLevel = scan.nextInt();
        scan.nextLine();

        System.out.print("\nSales level successfully upgraded.");

        EmployeeManagement.upgradeSalesLevelForEmployee(id, newSalesLevel);

    }

    private static void search() {
        System.out.println("Enter identification number: ");
        String id = scan.nextLine();

        EmployeeManagement.findEmployee(id);
    }

    private static void addStar() {
        System.out.print("Set star employee (Enter id): ");
        String id = scan.nextLine();
        EmployeeManagement.addStarEmployee(id);
    }

    private static void removeStar(){
        System.out.print("Enter id to remove star employee:");
        String id = scan.nextLine();
        EmployeeManagement.removeStarEmployee(id);
    }


}





