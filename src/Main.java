public class Main {
    public static void main(String[] args) {
        CompanyController companyController = new CompanyController();
        JobController jobController = new JobController();
        EmployerController employerController = new EmployerController();
        
        Company company = companyController.createCompany("Apple", "contato@apple.com", "Amapá", "Macapá", "Rua das Araucárias", "Tecnologia", "stevetrabalhos");
        Job job = jobController.createJob("Designer", "Imagem e Vídeo", 17534, "Híbrido", 6);
        Employer employer = employerController.createEmployer("Steve Trabalhos", "stevetrabalhos", "dinheiro123", "Fundador");
        company.addJob(job);
        employer.setCompany(company);

        Company company2 = companyController.createCompany("Google", "contato@google.com", "Minas Gerais", "Belo Horizonte", "Rua das Américas", "Tecnologia", "larrypaginas");
        Job job2 = jobController.createJob("Engenheiro de Software A3", "TI", 18785, "Híbrido", 8);
        Employer employer2 = employerController.createEmployer("Larry Páginas", "larrypaginas","segredo" , "Fundador");
        company2.addJob(job2);
        employer2.setCompany(company2);

        Company company3 = companyController.createCompany("SpaceX", "contato@tesla.com", "São Paulo", "São Paulo", "Avenida Paulista", "Tecnologia", "elonmosquito");
        Job job3 = jobController.createJob("Fogueteiro", "Projetista", 26988, "Presencial", 10);
        Employer employer3 = employerController.createEmployer("Elon Mosquito", "elonmosquito", "marte123", "Fundador");
        company3.addJob(job3);
        employer3.setCompany(company3);

        Company company4 = companyController.createCompany("Magalu", "contato@magalu.com.br", "São Paulo", "Franca", "Rua Francisco Marques", "Lojista", "luizavestino");
        Job job4 = jobController.createJob("Vendedor","Comécio", 2466, "Presencial", 12);
        Employer employer4 = employerController.createEmployer("Luiza Vestino", "luizavestino", "empoderada123", "Fundadora");
        company4.addJob(job4);
        employer4.setCompany(company4);

        new Home();
    }
}