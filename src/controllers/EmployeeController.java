package controllers;

import models.*;
import java.util.HashMap;

/**
 * Representa o controlador de quem busca um emprego.
 * <p>
 * Contém métodos para atualização, criação e gerenciamentos destes.
 * @author Ana, Arthur e Caio
 * @version 1.3
 * @since 2023
 */
public class EmployeeController {
    private HashMap<String, Employee> employees = Data.getEmployees();
    
    /** 
     * Cria um objeto do tipo <code>Employee</code> com os parâmetros pré-definidos.
     * Ao utilizar este método, ele será automaticamente incluído na memória. Isto é, na classe de dados.
     * @param name o nome do usuário a ser criado
     * @param user o nome de usuário do usuário a ser criado
     * @param password a senha do usuário a ser criado
     * @param scholarship_level o nível de escolaridade do usuário a ser criado
     * @return o usuário criado, <code>Employee</code>
     */
    public Employee createEmployee(String name, String user, String password, String scholarship_level){
        Employee employee = new Employee(user, password, name, scholarship_level);
        employees.put(user, employee);

        return employee;
    }

    /**
     * Retorna um objeto do tipo <code>Employee</code> de acordo com o parâmetro <code>username</code>.
     * <p>
     * Caso não exista um objeto referenciado com esta chave, o retorno será <code>null</code>.
     * @param username o nome de usuário do usuário a ser retornado
     * @return o usuário caso ele exista, <code>Employee</code>
     */
    public Employee getEmployeeByUsername(String username) {
        return employees.get(username);
    }

    /**
     * Retorna <code>true</code> caso não exista um objeto dod tipo <code>Employee</code> com a chave de parâmetro <code>username</code>.
     * Caso contrário, retornará <code>false</code>.
     * @param username o nome de usuário do usuário a ser verificado
     * @return <code>boolean</code>
     */
    public boolean isUserAvailable(String username) {
        return this.getEmployeeByUsername(username) == null ? true : false;
    }

    /**
     * Retorna um <code>HashMap&lt;String, Employee&gt;</code> com todos os objetos do tipo <code>Employee</code> cadastrados na memória.
     * @return uma lista de usuários empregados, <code>HashMap&lt;String, Employee&gt;</code>
     */
    public HashMap<String, Employee> getEmployees() {
        return employees;
    }
}
