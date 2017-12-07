public abstract class Employee {
    private static int employeeCount;
    private int employeeID;
    private String name;
    private double baseSalary;
    private Employee manager;

    public Employee(String name, double salary) {
        this.name = name;
        this.baseSalary = salary;
        employeeCount++;
        this.employeeID = employeeCount;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public String getName() {
        return this.name;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public Employee getManager() {
        return manager;
    }

    public boolean equals(Employee other) {
        return (this.getEmployeeID() == other.getEmployeeID());
    }

    public String toString() {
        return this.getEmployeeID() + " " + this.getName();
    }

   public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
   }

    public void setName(String name) {
        this.name = name;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    abstract String employeeStatus();
}
