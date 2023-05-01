import java.util.ArrayList;

public class Job {
    private int salary;
    private int workload;
    private String modality;
    private String occupation_area;
    private ArrayList<String> requirements;

    public Job(int salary, int workload, String modality, String occupation_area) {
        this.requirements = new ArrayList<>();
        this.salary = salary;
        this.workload = workload;
        this.modality = modality;
        this.occupation_area = occupation_area;
    }

    public int getSalary() {
        return salary;
    }

    public int getWorkload() {
        return workload;
    }

    public String getModality() {
        return modality;
    }

    public String getOccupationArea() {
        return occupation_area;
    }

    public ArrayList<String> getRequirements() {
        return requirements;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setWorkload(int hours) {
        this.workload = hours;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public void addRequirement(String requirement) {
        requirements.add(requirement);
    }

    public boolean userHasAllRequirements(ArrayList<String> habilities) {
        return habilities.containsAll(this.requirements);
    }

    public void removeRequirement(String requirement) {
        requirements.remove(requirement);
    }

    public String toString() {
        return "{ requirements: " + getRequirements() + ", salary: " + getSalary() + ", workload: " + getWorkload() + ", modality: " + getModality() + ", occupation_area: " + getOccupationArea() + " }";
    }
}
