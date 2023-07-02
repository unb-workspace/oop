package models;

import java.util.ArrayList;

/**
 * A classe Company contém as informações de uma determinada empresa.
 * <p>
 * Contém métodos responsáveis por adicionar ou remover uma vaga de emprego.
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.2.
 */
public class Company {
    private String name;
    private String occupation_area;
    private String email;
    private Address address;
    private String representant;
    private final ArrayList<Job> jobs = new ArrayList<>();

    /**
     * Método construtor responsável por criar uma empresa.
     * @param name define o nome da empresa.
     * @param occupation_area define a área de ocupação dessa empresa.
     * @param email define o email da empresa.
     */
    public Company(String name, String occupation_area, String email) {
        this.name = name;
        this.occupation_area = occupation_area;
        this.email = email;
    }

    /**
     * Sobrecarga do método construtor, o qual recebe também o parâmetro <code>address</code>.
     * @param name define o nome da empresa.
     * @param occupation_area define a área de ocupação dessa empresa.
     * @param email define o email da empresa.
     * @param address define o endereço da empresa.
     */
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
        this.representant = username;
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

    /**
     * Adiciona um novo emprego na ArrayList de empregos
     * @param job vaga de emprego de uma empresa
     */
    public void addJob(Job job) {
        jobs.add(job);
    }

    /**
     * Remove um emprego da ArrayList de empregos
     * @param job vaga de emprego de uma empresa
     */
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