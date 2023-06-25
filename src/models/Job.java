package models;

public class Job {
	private String name;
    private int salary;
    private int workload;
    private String modality;
    private String occupation_area;
    private String requirements;

    public Job(String name, int salary, int workload, String modality, String occupation_area, String requirements) {
        this.requirements = requirements;
        this.salary = salary;
        this.workload = workload;
        this.modality = modality;
        this.occupation_area = occupation_area;
        this.name = name;
    }
    
    public Job(String name, int salary, int workload, String modality, String occupation_area) {
    	this.salary = salary;
        this.workload = workload;
        this.modality = modality;
        this.occupation_area = occupation_area;
        this.name = name;
    }
    
    public String getName() {
    	return name;
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

    public String getRequirements() {
        return requirements;
    }
    
    public void setOccupationArea(String occupationArea) {
    	this.occupation_area = occupationArea;
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

    public void setRequirements(String requirements) {
    	this.requirements = requirements;
    }

    public String toString() {
        return "{ name: " + getName() + ", requirements: " + getRequirements() + ", salary: " + getSalary() + ", workload: " + getWorkload() + ", modality: " + getModality() + ", occupation_area: " + getOccupationArea() + " }";
    }
}
