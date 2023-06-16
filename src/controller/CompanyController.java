import java.util.ArrayList;

public class CompanyController {
    private ArrayList<Company> companies = Data.getCompanies();

    public Company createCompany(String name, String email, String state, String city, String street, String occupationArea, String owner) {
        Company company = new Company(name, occupationArea, email);
        Address address = new Address(state, city, street);

        company.setAddress(address);
        company.setRepresentant(owner);

        companies.add(company);
        return company;
    }

//    public static boolean isNameAccepted(String name) {
//
//    }
}
