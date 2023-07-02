package models;

/**
 * A classe User é designada para a criação de um usuário e é a classe pai de <code>Employer</code> e <code>Employee</code>.
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.0
 */
public abstract class User {
    protected String username;
    protected String name;
    protected String password;

    /**
     *Método construtor responsável pela criação de um usuário.
     * @param username define o nome de usuário.
     * @param password define a senha de acesso do usuário.
     * @param name define o nome do criador da conta.
     */
    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "{ username: " + this.username + ", password: " + this.password + " }";
    }
}
