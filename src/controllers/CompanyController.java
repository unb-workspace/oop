package controllers;

import models.*;
import java.util.ArrayList;

public class CompanyController {
    public static String[] availableRegions = {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espirito Santo", "Goiás", "Maranhão", "Mato Grosso do Sul", "Mato Grosso", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
    private final ArrayList<Company> companies = Data.getCompanies();
    
    public Company createCompany(String name, String email, String state, String city, String street, String occupationArea, String owner) {
        Company company = new Company(name, occupationArea, email);
        Address address = new Address(state, city, street);

        company.setAddress(address);
        company.setRepresentant(owner);

        companies.add(company);
        return company;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public ArrayList<String> getCompanyOwners() {
        ArrayList<String> owners = new ArrayList<>();

        for(Company company : companies) {
            owners.add(company.getName() + " (" + company.getRepresentant() + ")");
        }

        return owners;
    }

    public ArrayList<String> getCompanyRegions() {
        ArrayList<String> regions = new ArrayList<>();

        for(Company company : companies) {
            if(!regions.contains(company.getAddress().getState())) {
                regions.add(company.getAddress().getState());
            }
        }

        return regions;
    }

    public ArrayList<Company> filterCompaniesByRegion(String region) {
        ArrayList<Company> filteredCompanies = new ArrayList<>();

        for(Company company : companies) {
            if(company.getAddress().getState().equals(region)) {
                filteredCompanies.add(company);
            }
        }

        return filteredCompanies;
    }

    public ArrayList<Company> filterCompaniesByName(String name, ArrayList<Company> companies) {
        ArrayList<Company> filteredCompanies = new ArrayList<>();

        for(Company company : companies) {
            if(company.getName().toLowerCase().contains(name.toLowerCase())) {
                filteredCompanies.add(company);
            }
        }

        return filteredCompanies;
    }
    
    public void deleteCompany(String companyName, ArrayList<Company> companies) {
    	for (Company company:companies) {
    		if(company.getName() == companyName) {
    			for (Job job:company.getJobs()) {
    				company.removeJob(job);  // não sei se precisa dessa parte mas coloquei por causa da composicao
    			}
    			companies.remove(company);
    		}
    	}
    }
    
    public void updateEmail(Company company, String email) {
    	if (company.getEmail() != email) {
    		company.setEmail(email);
    	}
    }
    
    public void updateState(Company company, String state) {
    	if ((company.getAddress()).getState() != state) {
    		(company.getAddress()).setState(state);
    	}
    }
    
    public void updateCity(Company company, String city) {
    	if ((company.getAddress()).getCity() != city) {
    		(company.getAddress()).setCity(city);
    	}
    }
    
    public void updateStreet(Company company, String street) {
    	if ((company.getAddress()).getStreet() != street) {
    		(company.getAddress()).setStreet(street);
    	}
    }
    
    public void updateOccupationArea(Company company, String occupationArea) {
    	if (company.getOccupationArea() != occupationArea) {
    		company.setOccupationArea(occupationArea);
    	}
    }
    
    
}
