package models;

/**
 * A classe <code>Job</code> contém os atributos de uma vaga de emprego.
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.2
 */
public class Job {
	private String name;
    private int salary;
    private int workload;
    private String modality;
    private String occupation_area;
    private String requirements;

    /**
     * Método construtor de uma vaga de emprego.
     * @param name define o nome da vaga de emprego
     * @param salary atribui um salário para o cargo
     * @param workload define a carga horária da vaga
     * @param modality define se o emprego ofertado é remoto, presencial ou híbrido
     * @param occupation_area define o segmento profissinal da vaga oferecida
     * @param requirements lista habilidades necessárias para exercer o cargo
     */
    public Job(String name, int salary, int workload, String modality, String occupation_area, String requirements) {
        this.requirements = requirements;
        this.salary = salary;
        this.workload = workload;
        this.modality = modality;
        this.occupation_area = occupation_area;
        this.name = name;
    }

    /**
     * Método construtor sobrecarregado, removido o parâmetro de requisitos
     * @param name define o nome da vaga de emprego
     * @param salary atribui um salário para o cargo
     * @param workload define a carga horária da vaga
     * @param modality define se o emprego ofertado é remoto, presencial ou híbrido
     * @param occupation_area define o segmento profissinal da vaga oferecida
     */
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
    
    public void setName(String name) {
        this.name = name;
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
