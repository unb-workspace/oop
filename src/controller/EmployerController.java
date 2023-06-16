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
        if(!employers.containsKey(username))
            return null;

        return employers.get(username);
    }

}
