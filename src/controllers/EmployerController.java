package controllers;

import models.*;
import java.util.HashMap;

/**
 * Representa o controlador dos empregadores.
 * <p>
 * Contém métodos para atualização, criação e gerenciamentos destes.
 * @author Ana, Arthur e Caio
 * @version 1.3
 * @since 2023
 */
public class EmployerController {
    private HashMap<String, Employer> employers = Data.getEmployers();

    /**
     * Cria um objeto do tipo <code>Employer</code> com os parâmetros pré-definidos.
     * Ao utilizar este método, ele será automaticamente incluído na memória. Isto é, na classe de dados.
     * @param name o nome do usuário a ser criado
     * @param user o nome de usuário do usuário a ser criado
     * @param password a senha do usuário a ser criado
     * @param role o cargo do usuário a ser criado
     * @return o usuário criado, <code>Employer</code>
     */
    public Employer createEmployer(String name,String user,String password,String role) {
        Employer employer = new Employer(user,password,name);
        employer.setRole(role);

        employers.put(user, employer);

        return employer;
    }

    /**
     * Referencia o objeto do tipo <code>Company</code> para o objeto do tipo <code>Employer</code>.
     * Isto é, assinala o usuário como representante da empresa.
     * @param username o nome de usuário do usuário a ser referenciado
     * @param company a empresa a ser referenciada
     */
    public void setCompany(String username, Company company) {
        Employer employer = getEmployerByUsername(username);
        employer.setCompany(company);
    }

    /**
     * Retorna <code>true</code> caso o usuário tenha alguma empresa assinalada.
     * Caso contrário, retornará <code>false</code>.
     * @param username o nome de usuário do usuário a ser verificado
     * @return <code>boolean</code>
     */
    public boolean hasCompany(String username) {
        Employer employer = getEmployerByUsername(username);

        if(employer == null)
            return false;

        return employer.getCompany() == null ? false : true;
    }

    /**
     * Retorna um objeto do tipo <code>Employer</code> de acordo com o parâmetro <code>username</code>.
     * Caso não exista um objeto referenciado com esta chave, o retorno será <code>null</code>.
     * @param username o nome de usuário do usuário a ser retornado
     * @return o usuário caso ele exista, <code>Employer</code>
     */
    public Employer getEmployerByUsername(String username) {
        return employers.get(username);
    }
    
    /**
     * Retorna <code>true</code> caso não exista um objeto do tipo <code>Employer</code> com a chave de parâmetro <code>username</code>.
     * Caso contrário, retornará <code>false</code>.
     * @param username o nome de usuário do usuário a ser verificado
     * @return <code>boolean</code>
     */
    public boolean isUserAvailable(String username) {
        return this.getEmployerByUsername(username) == null ? true : false;
    }

    /**
     * Retorna um <code>HashMap&lt;String, Employer&gt;</code> com todos os objetos do tipo <code>Employer</code> cadastrados na memória.
     * @return uma lista de usuários empregadores, <code>HashMap&lt;String, Employer&gt;</code>
     */
    public HashMap<String, Employer> getEmployers() {
        return employers;
    }
}
