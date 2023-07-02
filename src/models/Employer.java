package models;

/**
 * A classe Employer é designada para a criação de um perfil empresarial, que tem parâmetro herdados da classe <code>User</code>.
 * @author Ana Clara, Arthur e Caio.
 * @since 2023
 * @version 1.0
 */
public class Employer extends User {
    private Company company;
    private String role;

    /**
     * Método construtor responsável pela criação de um usuário do tipo <code>Employer</code>. Além dos atributos herdados da classe <code>User</code>.
     * @param username define o nome de usuário do empregador.
     * @param password define a senha de acesso do empregador.
     * @param name define o nome do criador da conta.
     */
    public Employer(String username, String password, String name) {
        super(username, password, name);

        this.role = "No role";
    }

    public Company getCompany() {
        return company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String toString() {
        return "{ username: " + this.username + ", password: " + this.password + ", name: " + this.name + ", role: " + this.role + ", company: " + this.company + " }";
    }

}
