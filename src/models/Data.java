import java.util.ArrayList;
public class Data {
    private static final ArrayList<Company> companies = new ArrayList<Company>();
    private static final ArrayList<Employee> employees = new ArrayList<Employee>();
    private static final ArrayList<Employer> employers = new ArrayList<Employer>();

    public static ArrayList<Company> getCompanies() {
        return companies;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static ArrayList<Employer> getEmployers() {
        return employers;
    }
}
