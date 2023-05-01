import java.util.ArrayList;

public class Employee extends User {
    private String scholarship_level;
    private ArrayList<String> habilities;

    public Employee(String username, String password, String name, String scholarship_level){
        super(username, password, name);

        this.habilities = new ArrayList<>();
        this.scholarship_level = scholarship_level;
    }

    public void addHability(String hability) {
        habilities.add(hability);
    }

    public void removeHability(String hability) {
        if(hasHability(hability)) {
            habilities.remove(hability);
        }
    }

    public boolean hasHability(String hability) {
        return habilities.contains(hability);
    }

    public ArrayList<String> getHabilities() {
        return this.habilities;
    }

    public String getScholarshipLevel() {
        return this.scholarship_level;
    }

    public void setScholarshipLevel(String scholarship_level) {
        this.scholarship_level = scholarship_level;
    }

    public String toString() {
        return "{ scholarship level: " + getScholarshipLevel() + ", habilidades: " + getHabilities() + " }";
    }
}


