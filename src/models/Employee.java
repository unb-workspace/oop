package models;

import java.util.ArrayList;

/**
 * A classe Employee é designada para a crianção de um funcionário, que tem parâmetro herdados da classe <code>User</code>.
 * @author Ana Clara, Arthur e Caio.
 * @since 2023
 * @version 1.0
 */
public class Employee extends User {
    private String scholarship_level;
    private ArrayList<String> habilities;

    /**
     *Método construtor responsável pela criação de um usuário do tipo <code>Employee</code>. Além dos atributos herdados da classe
     * <code>User</code>, recebe também o parâmetro nível de escolaridade e adiciona uma ArrayList de habilidades do funcionário.
     * @param username define o nome de usuário do funcionário.
     * @param password define a senha de acesso do funcionário.
     * @param name define o nome do criador da conta.
     * @param scholarship_level define o nível de escolaridade do usuário.
     */
    public Employee(String username, String password, String name, String scholarship_level){
        super(username, password, name);

        this.habilities = new ArrayList<>();
        this.scholarship_level = scholarship_level;
    }

    public void addHability(String hability) {
        habilities.add(hability);
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


