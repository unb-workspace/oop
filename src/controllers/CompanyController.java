package controllers;

import models.*;
import java.util.ArrayList;

/**
 * Representa o controlador das empresas.
 * <p>
 * Contém métodos para atualização, criação e gerenciamento destes.
 * @author Ana Clara, Arthur e Caio
 * @version 1.2
 * @since 2023
 */
public class CompanyController {
    public static String[] availableRegions = {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espirito Santo", "Goiás", "Maranhão", "Mato Grosso do Sul", "Mato Grosso", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
    private final ArrayList<Company> companies = Data.getCompanies();
    
    /**
     * Cria um objeto do tipo <code>Company</code> com os parâmetros pré-definidos. Neste caso, também é necessário incluir o <code>endereço</code> da empresa.
     * <p>
     * Ao utilizar este método, ele será automaticamente incluído na memória. Isto é, na classe de dados.
     * @param name o nome da empresa
     * @param email o e-mail da empresa
     * @param state o estado da empresa (endereço) 
     * @param city a cidade da empresa (endereço)
     * @param street a rua da empresa (endereço)
     * @param occupationArea a área de ocupação da empresa
     * @param owner o representante da empresa (username)
     * @return a classe da empresa, <code>Company</code>
     */
    public Company createCompany(String name, String email, String state, String city, String street, String occupationArea, String owner) {
        Company company = new Company(name, occupationArea, email);
        Address address = new Address(state, city, street);

        company.setAddress(address);
        company.setRepresentative(owner);

        companies.add(company);
        return company;
    }

    /**
     * Retorna uma lista do tipo <code>Company</code> cadastradas e salvas na memória.
     * @return uma lista do tipo <code>ArrayList&lt;Company&gt;</code>, as empresas cadastradas e salvas na memória.
     */
    public ArrayList<Company> getCompanies() {
        return companies;
    }

    /**
     * Retorna uma lista com todos os nomes das empresas cadastradas na memória e seus respectivos representantes.
     * @return uma lista com todos os nomes das empresas e seus representantes, <code>ArrayList&lt;String&gt;</code>
     */
    public ArrayList<String> getCompanyOwners() {
        ArrayList<String> owners = new ArrayList<>();

        for(Company company : companies) {
            owners.add(company.getName() + " (" + company.getRepresentative() + ")");
        }

        return owners;
    }

    /**
     * Retorna as regiões (por estado) das empresas cadastradas na memória.
     * @return uma lista do tipo <code>ArrayList&lt;String&gt;</code>, as regiões cadastradas nas empresas
     */
    public ArrayList<String> getCompanyRegions() {
        ArrayList<String> regions = new ArrayList<>();

        for(Company company : companies) {
            if(!regions.contains(company.getAddress().getState())) {
                regions.add(company.getAddress().getState());
            }
        }

        return regions;
    }

    /**
     * Filtra e retorna uma lista do tipo <code>Company</code> de acordo com a região escolhida.
     * @param region o estado desejado para filtragem (endereço)
     * @return uma lista das empresas filtradas, <code>ArrayList&lt;Company&gt;</code>
     */
    public ArrayList<Company> filterCompaniesByRegion(String region) {
        ArrayList<Company> filteredCompanies = new ArrayList<>();

        for(Company company : companies) {
            if(company.getAddress().getState().equals(region)) {
                filteredCompanies.add(company);
            }
        }

        return filteredCompanies;
    }

    /**
     * Filtra os objetos do tipo <code>Company</code> de uma lista pré-definida através do parâmetro <code>nome</code>.
     * Caso o nome da empresa contenha uma parte (ou seja, é substring), será retornada.
     * @param name o nome desejado para filtrar
     * @param companies a lista de empresas a ser filtrada, <code>ArrayList&lt;Company&gt;</code>;
     * @return uma lista das empresas filtradas, <code>ArrayList&lt;Company&gt;</code>
     */
    public ArrayList<Company> filterCompaniesByName(String name, ArrayList<Company> companies) {
        ArrayList<Company> filteredCompanies = new ArrayList<>();

        for(Company company : companies) {
            if(company.getName().toLowerCase().contains(name.toLowerCase())) {
                filteredCompanies.add(company);
            }
        }

        return filteredCompanies;
    }
    
    /**
     * Deleta o objeto do tipo <code>Company</code> da memória (classe de dados).
     * @param company o objeto do tipo <code>Company</code> a ser deletado
     */
    public void deleteCompany(Company company) {
        this.companies.remove(company);
    }

    /**
     * Atualiza o nome da empresa, caso haja alteração no nome.
     * @param company o objeto do tipo <code>Company</code> a ser deletado
     * @param name o novo nome da empresa
     */
    public void updateName(Company company, String name) {
        if(!company.getName().equals(name)) {
            company.setName(name);
        }
    }
    
    /**
     * Atualiza o e-mail da empresa, caso haja alteração no e-mail.
     * @param company o objeto do tipo <code>Company</code> a ser atualizado
     * @param email o novo e-mail da empresa
     */
    public void updateEmail(Company company, String email) {
        if(!company.getEmail().equals(email)) {
            company.setEmail(email);
        }
    }
    
    /**
     * Atualiza o endereço da empresa por estado, caso haja alteração no estado.
     * @param company o objeto do tipo <code>Company</code> a ser atualizado
     * @param state o novo estado (endereço) da empresa
     */
    public void updateState(Company company, String state) {
        if(!company.getAddress().getState().equals(state)) {
            company.getAddress().setState(state);
        }
    }
    
    /**
     * Atualiza o endereço da empresa por cidade, caso haja alteração na cidade.
     * @param company o objeto do tipo <code>Company</code> a ser atualizado
     * @param city a nova cidade (endereço) da empresa
     */
    public void updateCity(Company company, String city) {
        if(!company.getAddress().getCity().equals(city)) {
            company.getAddress().setCity(city);
        }
    }
    
    /**
     * Atualiza o endereço da empresa por rua, caso haja alteração na rua.
     * @param company o objeto do tipo <code>Company</code> a ser atualizado
     * @param street a nova rua (endereço) da empresa
     */
    public void updateStreet(Company company, String street) {
        if(!company.getAddress().getStreet().equals(street)) {
            company.getAddress().setStreet(street);
        }
    }
    
    /**
     * Atualiza a área de ocupação da empresa, caso haja alteração na área de ocupação.
     * @param company o objeto do tipo <code>Company</code> a ser atualizado
     * @param occupationArea a nova área de ocupação da empresa
     */
    public void updateOccupationArea(Company company, String occupationArea) {
        if(!company.getOccupationArea().equals(occupationArea)) {
            company.setOccupationArea(occupationArea);
        }
    }
}
