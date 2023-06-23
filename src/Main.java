public class Main {
    public static void main(String[] args) {
        CompanyController companyController = new CompanyController();
        JobController jobController = new JobController();
        EmployerController employerController = new EmployerController();
        
        Employer employer = employerController.createEmployer("João", "joao", "123", "Gerente");
        Company company = companyController.createCompany("Empresa 1", "joao@gmail.com", "SP", "São Paulo", "Rua 1", "TI", "joao");
        Job job = jobController.createJob("Vaga 1", "1", 4000, "Presencial", 40);
        company.addJob(job);
        employer.setCompany(company);
        
        new Home();
    }
}
