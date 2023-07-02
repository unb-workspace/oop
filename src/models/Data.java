package models;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que atua como banco de dados, armazena ArrayList e HashMap
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.0
 */
public class Data {
    private static ArrayList<Company> companies = new ArrayList<>();
    private static HashMap<String, Employer> employers = new HashMap<>();
    private static HashMap<String, Employee> employees = new HashMap<>();

    public static ArrayList<Company> getCompanies() {
        return companies;
    }

    public static HashMap<String, Employer> getEmployers() {
        return employers;
    }

    public static HashMap<String, Employee> getEmployees() {
        return employees;
    }
}
