import java.util.HashMap;

public class EmployeeController {
    private HashMap<String, Employee> employees = Data.getEmployees();
    public void createEmployee(String name, String user,String password,String scholarship_level){
        Employee employee = new Employee(user,password,name,scholarship_level);
        Data.setEmployees(employee);
    }
    public Employee getEmployeeByUsername(String username){
        if(!employees.containsKey(username))
            return null;
        return employees.get(username);
    }

    public boolean availableUser(String username){
        Employee user = getEmployeeByUsername(username);
        if (user == null){
            return true;
        }
        return false;
    }
    public HashMap<String, Employee> getEmployees(){return employees;}
}
