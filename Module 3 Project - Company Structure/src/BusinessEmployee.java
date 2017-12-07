public abstract class BusinessEmployee extends Employee {
    private static double businessSalary = 50000;
    private double bonusBudget;

    public BusinessEmployee(String name, double salary) {
        super(name, salary);
    }

    public BusinessEmployee(String name) {
        this(name, businessSalary);
    }

    public double getBonusBudget(){
        return this.bonusBudget;
    }

    public void setBonusBudget(double bonus) {
        this.bonusBudget = bonus;
    }

    public String employeeStatus() {
        //1 Kasey with a budget of 22500.0
        return super.toString() + " with a budget of " + String.format("%.2f",this.getBonusBudget());
    }

    public static double getBusinessSalary() {
        return businessSalary;
    }
}
