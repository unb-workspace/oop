import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    private static ArrayList<Company> companies = new ArrayList<>();
    private static HashMap<String, Employer> employers = new HashMap<>();
    private static HashMap<String, Employee> employees = new HashMap<>();

    public static ArrayList<Company> getCompanies() {
        return companies;
    }

    public static HashMap<String, Employer> getEmployers() {
        return employers;
    }

    public static HashMap<String, Employee> getEmployees() {
        return employees;
    }

    public static boolean setEmployers(Employer employer){
        String username = employer.getUsername();

        if(employers.containsKey(username)){
            return false;
        }
        else{
            employers.put(username,employer);
            return true;
        }
    }

    public static boolean setEmployees(Employee employee){
        String username = employee.getUsername();

        if(employees.containsKey(username)){
            return false;
        }
        else{
            employees.put(username,employee);
            return true;
        }
    }
}
