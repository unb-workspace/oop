import java.util.ArrayList;

public class Company {
    private final int ID;
    private String name;
    private final String occupation_area;
    private String email;
    private final Employer employer;
    private Address address;
    private ArrayList<Job> jobs;


    public Company(int ID, Employer employer, String name, String occupation_area, String email) {
        this.ID = ID;
        this.employer = employer;
        this.name = name;
        this.occupation_area = occupation_area;
        this.email = email;
    }

    public Company(int ID, Employer employer, String name, String occupation_area, String email, Address address) {
        this.jobs = new ArrayList<>();
        this.ID = ID;
        this.employer = employer;
        this.name = name;
        this.occupation_area = occupation_area;
        this.email = email;
        this.address = address;
    }


    public int getId() {
        return ID;
    }

    public User getEmployer() {
        return employer;
    }

    public String getName() {
        return name;
    }

    public String getOccupationArea() {
        return occupation_area;
    }

    public String getEmail() {
        return email;
    }
    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public void removeJob(Job job) {
        jobs.remove(job);
    }

    public String toString() {
        return "{ name: " + getName() + ", email: " + getEmail() + ", occupation_area: " + getOccupationArea() + ", id: " + getId() + ", owner: " + employer.getUsername() + ", address: " + getAddress() + " }";
    }
}