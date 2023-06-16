import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    private static ArrayList<Company> companies = new ArrayList<>();
    private static HashMap<String, Employer> employers = new HashMap<>();
    private static HashMap<String, Employee> employee = new HashMap<>();

    public static ArrayList<Company> getCompanies() {
        return companies;
    }

    public static HashMap<String, Employer> getEmployers() {
        return employers;
    }

    public static HashMap<String, Employee> getEmployees() {
        return employee;
    }
}
