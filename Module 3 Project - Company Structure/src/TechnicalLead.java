import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee implements Manager {
    private int headCount;
    private ArrayList<SoftwareEngineer> directReports;

    public TechnicalLead(String name){
        super(name, 1.3*getTechnicalSalary());
        this.headCount = 4;
        directReports = new ArrayList<SoftwareEngineer>(1);
    }

    public boolean hasHeadCount() {
        return ((this.directReports == null) || (this.directReports.size() < this.headCount));
    }

    public boolean addReport(SoftwareEngineer e) {
        if (this.hasHeadCount()) {
                e.setManager(this);
                (this.directReports).add(e);
                return true;
        } else return false;
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        return false; //prueba
    }

    public boolean requestBonus(Employee e, double bonus) {
        return false; //prueba
    }

    public String getTeamStatus() {
        if (directReports.size() > 0 ) {
            String result = super.employeeStatus() + " and is managing:\n";
            for (SoftwareEngineer e : directReports) {
                result += e.employeeStatus() + "\n";
            }
            return result;
        } else return super.employeeStatus() + " and no direct reports yet.";
    }

    public ArrayList<SoftwareEngineer> getDirectReports() {
        return directReports;
    }

 /*   @Override
    public String employeeStatus() {
        if (directReports.size() > 0 ) {
            String result = super.employeeStatus() + " and is managing:\\n";
            for (SoftwareEngineer e : directReports) {
                result += e.employeeStatus() + "\\n";
            }
            return result;
        } else return super.employeeStatus() + " and no direct reports yet.";
    }*/
}
