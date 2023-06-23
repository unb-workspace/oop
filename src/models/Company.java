package models;

import java.util.ArrayList;

public class Company {
    private String name;
    private String occupation_area;
    private String email;
    private Address address;
    private String representant;
    private final ArrayList<Job> jobs = new ArrayList<>();

    public Company(String name, String occupation_area, String email) {
        this.name = name;
        this.occupation_area = occupation_area;
        this.email = email;
    }

    public Company(String name, String occupation_area, String email, Address address) {
        this.name = name;
        this.occupation_area = occupation_area;
        this.email = email;
        this.address = address;
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
    public String getRepresentant() {
        return representant;
    }

    public void setRepresentant(String username) {
        representant = username;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
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

    public void addJob(Job job) {
        jobs.add(job);
    }

    public void removeJob(Job job) {
        jobs.remove(job);
    }

    public void setOccupationArea(String occupation_area) {
        this.occupation_area = occupation_area;
    }

    public String toString() {
        return "{ name: " + getName() + ", email: " + getEmail() + ", occupation_area: " + getOccupationArea() + ", address: " + getAddress() + " }";
    }
}