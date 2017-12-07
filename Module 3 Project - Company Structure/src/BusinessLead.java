import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee implements Manager {
    private int headCount;
    private ArrayList<Accountant> directReports;

    public BusinessLead(String name) {
        super(name, 2*getBusinessSalary());
        this.headCount = 10;
        directReports = new ArrayList<Accountant>(1);
    }

    @Override
    public String getTeamStatus() {
        if (directReports.size() > 0 ) {
            String result = super.employeeStatus() + " and is managing:\n";
            for (Accountant e : directReports) {
                result += e.employeeStatus() + "\n";
            }
            return result;
        } else return super.employeeStatus() + " and no direct reports yet.";
    }

    @Override
    public boolean hasHeadCount() {
        return ((this.directReports == null) || (this.directReports.size() < this.headCount));
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (this.hasHeadCount()) {
            e.setManager(this);
            (this.directReports).add(e);
            this.setBonusBudget(this.getBonusBudget() + (1.1 * e.getBaseSalary()));
            e.supportTeam(supportTeam);
            return true;
        } else return false;
    }
}
