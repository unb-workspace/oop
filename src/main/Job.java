public class Job {
    private int salary;
    private int workload;
    private String modality;
    private String occupation_area;
    private String[] requirements;

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

    public String[] getRequirements() {
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

    public void setRequirements(String[] requirements) {
        this.requirements = requirements;
    }

}
