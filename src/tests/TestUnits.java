package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import controllers.*;
import models.*;

/**
 * Classe responsável por testar as unidades do sistema.
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.2
 */
public class TestUnits {
    /**
     * Testa se o método de criação e busca da classe <code>Employee> está funcionando corretamente.
     */
   @Test
   public void testEmployeeUsername() {
       EmployeeController employeeController = new EmployeeController();
       Employee employee = employeeController.createEmployee("João do Pé de Feijão", "joaopedefeijao", "teste", "Ensino Superior Completo");

       assertEquals(employeeController.getEmployeeByUsername("joaopedefeijao"), employee);
   }

    /**
     * Testa se o método de criação e busca da classe <code>Employer> está funcionando corretamente.
     */
   @Test
   public void testEmployerUsername() {
       EmployerController employerController = new EmployerController();
       Employer employer = employerController.createEmployer("Pinóquio", "pinoquio", "teste", "Dono");

       assertEquals(employerController.getEmployerByUsername("pinoquio"), employer);
   }

    /**
     * Testa se o método de receber valores de salário válidos está funcionando corretamente.
     */
   @Test
   public void testValidSalary() {
       String salary = "0";
       String salary2 = "500";
       String salary3 = "-500";
       String salary4 = "Nada";

       assertEquals(JobController.getValidSalary(salary), 0);
       assertEquals(JobController.getValidSalary(salary2), 500);
       assertEquals(JobController.getValidSalary(salary3), -1);
       assertEquals(JobController.getValidSalary(salary4), -1);
   }
}
