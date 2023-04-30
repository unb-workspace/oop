public class Main {

    public static void main(String[] args) {
        System.out.println("Criando usuário...");

        User usuario = new User("Felipe Kleber", "senha123");
        System.out.println(usuario.toString());

        System.out.println("Criando empresa com o nome do usuário criado acima...");

        Company empresa = new Company(157777, usuario, "Kleber Investimentos", "Finanças", "fefe1213@gmail.com");
        usuario.setCompany(157777);

        System.out.println("Adicionando endereço na empresa acima...");

        Address endereco = new Address("Bahia","Salvador","Bairro São Caetano");
        empresa.setAddress(endereco);

        System.out.println(empresa.getAddress().toString());

        System.out.println("Adicionando um emprego disponível na empresa...");

    }
}
