package models;

import java.util.Date;

/**
 * Classe User designada para armazenar informações sobre um usuário e é a classe pai.
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.0
 */
public abstract class User {
    protected String username;
    protected String name;
    protected String password;
    protected Date creation_date;

    /**
     *Método construtor utilizado designado para a criação de um objeto do tipo <code>User</code>.
     * @param username define o nome de usuário.
     * @param password define a senha de acesso do usuário.
     * @param name define o nome do criador da conta.
     */
    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.creation_date = new Date();
    }

    public String getPassword() {
        return this.password;
    }

    public Date getCreationDate() {
        return this.creation_date;
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "{ username: " + this.username + ", password: " + this.password + ", creation_date: " + this.creation_date + " }";
    }
}
