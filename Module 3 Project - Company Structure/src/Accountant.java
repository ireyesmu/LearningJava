public class Accountant extends BusinessEmployee {
    private TechnicalLead teamSupported;

    public Accountant(String name) {
        super(name);
        this.setBonusBudget(0);
        this.teamSupported = null;
    }

    public TechnicalLead getTeamSupported(){
        return teamSupported;
    }

    public void supportTeam(TechnicalLead lead) {
        this.teamSupported = lead;
        double bonusBudget = 0;
        for (Employee e : lead.getDirectReports()) {
            bonusBudget += e.getBaseSalary();
        }
        bonusBudget *= 1.1;
        this.setBonusBudget(bonusBudget);
    }

    public boolean approveBonus(double bonus) {
        if (bonus <  this.getBonusBudget()) {
            this.setBonusBudget(this.getBonusBudget() - bonus);
            return true;
        } else return false;
    }

    @Override
    public String employeeStatus() {
        return super.employeeStatus() + " is supporting " + teamSupported.getName();
    }
}
