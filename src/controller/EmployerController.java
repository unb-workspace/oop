import java.util.HashMap;

public class EmployerController {
    private HashMap<String, Employer> employers = Data.getEmployers();

    public void setCompany(String username, Company company) {
        Employer employer = getEmployerByUsername(username);
        employer.setCompany(company);
    }

    public boolean hasCompany(String username) {
        Employer employer = getEmployerByUsername(username);

        if(employer == null)
            return false;

        return employer.getCompany() == null ? false : true;
    }

    public Employer getEmployerByUsername(String username) {
        return employers.get(username);
    }
    public boolean isUserAvailable(String username) {
        return this.getEmployerByUsername(username) != null ? true : false;
    }

    public void createEmployer(String name,String user,String password,String role) {
        Employer employer = new Employer(user,password,name);
        employer.setRole(role);

        employers.put(user, employer);
    }

    public HashMap<String, Employer> getEmployers() {
        return employers;
    }
}
