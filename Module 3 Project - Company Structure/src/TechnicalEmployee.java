public abstract class TechnicalEmployee extends Employee {
    private static final double TECHNICALSALARY = 75000;
    private int successfulCheckIns;


    public TechnicalEmployee(String name, double salary) {
        super(name, salary);
    }

    public TechnicalEmployee(String name) {
        this(name, TECHNICALSALARY);
    }

    public int getSuccessfulCheckIns() {
        return this.successfulCheckIns;
    }

    public void setSuccessfulCheckIns(int checkIns) {
        this.successfulCheckIns = checkIns;
    }

    public String employeeStatus() {
        //1 Kasey has 10 successful check ins
        return super.toString() + " has " + this.getSuccessfulCheckIns() + " check ins";
    }

    public static double getTechnicalSalary() {
        return TECHNICALSALARY;
    }
}
