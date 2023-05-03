public class Main {
    public static void main(String[] args) {
        System.out.println("[TESTE] Criando usuário \"Empregador\"");

        Employer empregador = new Employer("istive", "senha15", "Istive Empregos");
        Employer empregador2 = new Employer("cleito_musk", "senha20", "Cleito Musk");
        Employer empregador3 = new Employer("bill_portoes", "senha25", "Bill Portoes");

        System.out.println(empregador);
        System.out.println(empregador2);
        System.out.println(empregador3);

        System.out.println("\n" + "[TESTE] Criando empresa e assinalando ao empregador, junto com os endereços e empregos disponíveis");

        Address endereco = new Address("Bahia", "California", "Pertino");
        Address endereco2 = new Address("Espirito Santo", "São Francisco", "Caldeirão Furado");
        Address endereco3 = new Address("Minas Gerais", "Montes Claros", "20");

        Company empresa = new Company(15, empregador, "EhPow", "Tecnologia", "emprego@ehpow.com", endereco );
        Company empresa2 = new Company(21, empregador2, "Tuite", "Tecnologia", "emprego@tuite.com", endereco2);
        Company empresa3 = new Company(12, empregador3, "Janelas", "Vidraçaria", "contato@janelas.com", endereco3);

        empregador.setCompany(empresa);
        empregador2.setCompany(empresa2);
        empregador3.setCompany(empresa3);

        empregador.setRole("CEO");
        empregador2.setRole("Manager");
        empregador3.setRole("Founder");

        Job job = new Job(2100, 8, "Remoto", "Tecnologia" );
        Job job2 = new Job(300, 10, "Híbrido", "Tecnologia");
        Job job3 = new Job(1460, 6, "Presencial", "Marketing");
        Job job4 = new Job(2500, 8, "Remoto", "Administração");
        Job job5 = new Job(800,4,"Presencial", "Financeiro");

        job.addRequirement("UML");
        job.addRequirement("OOP");
        job.addRequirement("Java");

        job2.addRequirement("Python");
        job2.addRequirement("C++");
        job2.addRequirement("UI/UX");

        job3.addRequirement("Canva");
        job3.addRequirement("Figma");

        job4.addRequirement("Excel");
        job4.addRequirement("Matemática Básica");

        empresa.addJob(job);
        empresa2.addJob(job2);
        empresa2.addJob(job3);
        empresa3.addJob(job4);
        empresa3.addJob(job5);

        System.out.println("\n" + "[DEMO] Demonstrando que as empresas foram criadas e assinaladas ao seus representantes");

        System.out.println(empregador);
        System.out.println(empregador2);
        System.out.println(empregador3);

        System.out.println("\n" + "[DEMO] Mostrando os empregos disponíveis");

        for(Object j : empresa.getJobs().toArray()) {
            System.out.println(j);
        }

        for(Object j : empresa2.getJobs().toArray()) {
            System.out.println(j);
        }

        for(Object j : empresa3.getJobs().toArray()) {
            System.out.println(j);
        }

        System.out.println("\n" + "[TESTE] Criando usuário \"Empregado\"");

        Employee empregado = new Employee("neima","brunamarquezine","Neima Junio", "Ensino Médio Completo");
        Employee empregado2 = new Employee("bluepen", "setunaomeamas", "Blue Pen", "Ensino Médio Completo");
        Employee empregado3 = new Employee("naldo", "maiordomundo", "Naldo Benny", "Ensino Superior Incompleto");

        empregado.addHability("Velocidade");
        empregado.addHability("Paternidade");
        empregado2.addHability("Cantoria");
        empregado3.addHability("Dança");
        empregado3.addHability("Cantoria");

        System.out.println(empregado);
        System.out.println(empregado2);
        System.out.println(empregado3);

        System.out.println("\n" + "[DEMO] Demonstrando se algum dos empregados possui a habilidade \"Cantoria\"");

        System.out.println(empregado.getName() + ": " + empregado.hasHability("Cantoria"));
        System.out.println(empregado2.getName() + ": " + empregado2.hasHability("Cantoria"));
        System.out.println(empregado3.getName() + ": " + empregado3.hasHability("Cantoria"));

    }
}
