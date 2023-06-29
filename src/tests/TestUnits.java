package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import controllers.*;
import models.*;

public class TestUnits {
    @Test
    public void testEmployeeUsername() {
        EmployeeController employeeController = new EmployeeController();
        Employee employee = employeeController.createEmployee("João do Pé de Feijão", "joaopedefeijao", "teste", "Ensino Superior Completo");
        
        assertEquals(employeeController.getEmployeeByUsername("joaopedefeijao"), employee);
    }

    public void testEmployerUsername() {
        EmployerController employerController = new EmployerController();
        Employer employer = employerController.createEmployer("Pinóquio", "pinoquio", "teste", "Dono");
        
        assertEquals(employerController.getEmployerByUsername("pinoquio"), employer);
    }

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
