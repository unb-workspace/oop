package controllers;

import models.*;
import java.util.HashMap;

/**
 * Representa o controlador de quem busca um emprego.
 * Contém métodos para atualização, criação e gerenciamentos destes.
 * 
 * @author Ana, Arthur e Caio
 * @version 1.3
 * @since 2023
 */
public class EmployeeController {
    private HashMap<String, Employee> employees = Data.getEmployees();
    
    
    /** 
     * Cria um objeto do tipo <code>Employee</code> com os parâmetros pré-definidos.
     * Ao utilizar este método, ele será automaticamente incluído na memória. Isto é, na classe de dados.
     * @param name
     * @param user
     * @param password
     * @param scholarship_level
     * @return <code>Employee</code>
     */
    public Employee createEmployee(String name, String user, String password, String scholarship_level){
        Employee employee = new Employee(user, password, name, scholarship_level);
        employees.put(user, employee);

        return employee;
    }

    /**
     * Retorna um objeto do tipo <code>Employee</code> de acordo com o parâmetro <code>username</code>.
     * Caso não exista um objeto referenciado com esta chave, o retorno será <code>null</code>.
     * @param username
     * @return <code>Employee</code>
     */
    public Employee getEmployeeByUsername(String username) {
        return employees.get(username);
    }

    /**
     * Retorna <code>true</code> caso não exista um objeto dod tipo <code>Employee</code> com a chave de parâmetro <code>username</code>.
     * Caso contrário, retornará <code>false</code>.
     * @param username
     * @return <code>boolean</code>
     */
    public boolean isUserAvailable(String username) {
        return this.getEmployeeByUsername(username) == null ? true : false;
    }

    /**
     * Retorna um <code>HashMap&lt;String, Employee&gt;</code> com todos os objetos do tipo <code>Employee</code> cadastrados na memória.
     * @return <code>HashMap&lt;String, Employee&gt;</code>
     */
    public HashMap<String, Employee> getEmployees() {
        return employees;
    }
}
