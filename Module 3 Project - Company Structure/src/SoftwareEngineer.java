public class SoftwareEngineer extends TechnicalEmployee {
    private boolean codeAccess;

    public SoftwareEngineer(String name) {
        super(name);
        this.codeAccess = false;
        this.setSuccessfulCheckIns(0);
    }

    public boolean getCodeAccess() {
        return this.codeAccess;
    }

    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    /*public boolean checkInCode() {
        if (this.getManager() instanceof TechnicalLead) {
            return  ((TechnicalLead) this.getManager()).approveCheckIn(this);
        } else return false;
    }*/
}
