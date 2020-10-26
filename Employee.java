public class Employee {
    private String name;
    private String gender;
    private String id;
    private double salary;
    private boolean starEmployee;

    public Employee(String name, String gender, String id, double salary) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isStarEmployee() {
        return starEmployee;
    }

    public void setStarEmployee(boolean starEmployee) {
        this.starEmployee = starEmployee;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", Identification number: " + id +
                ", Salary: " + salary + ", Star Employee: " + starEmployee;
    }


}

