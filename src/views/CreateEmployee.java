import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import components.TextField;
import components.Button;
import components.TextLabel;

public class CreateEmployee extends Screen{
    Dimension textFieldSize = new Dimension(200, 30);
    Color colorField = new Color(199, 194, 194);

    private EmployeeController employeeController = new EmployeeController();
    private final JPanel panel = new JPanel();
    private final TextField nameField = new TextField();
    private final TextField userField = new TextField();
    private final TextField scholarshipField = new TextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final Button createButton = new Button("Criar");

    public CreateEmployee(){
        super("Adicionar Empregado");

        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
        this.panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        this.passwordField.setPreferredSize(this.textFieldSize);
        this.passwordField.setBackground(colorField);
        this.passwordField.setBorder(BorderFactory.createEmptyBorder());

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new TextLabel("Nome:"));
        namePanel.add(this.nameField);

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userPanel.add(new TextLabel("Usuario:"));
        userPanel.add(this.userField);

        JPanel scholarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        scholarPanel.add(new TextLabel("Escolaridade:"));
        scholarPanel.add(this.scholarshipField);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.add(new TextLabel("Senha:"));
        passwordPanel.add(this.passwordField);

        JPanel buttonPanel = new JPanel();
        this.createButton.addActionListener(this::createEmployee);
        buttonPanel.add(this.createButton);

        this.panel.add(namePanel);
        this.panel.add(userPanel);
        this.panel.add(passwordPanel);
        this.panel.add(scholarPanel);
        this.panel.add(buttonPanel);

        this.add(panel);
        this.display();
    }

    private void createEmployee(ActionEvent action){
        String name = this.nameField.getText().trim();
        String username = this.userField.getText().trim();
        String password = String.valueOf(this.passwordField.getPassword());
        String scholarship = this.scholarshipField.getText().trim();

        if(name.isEmpty() || username.isEmpty() || password.isEmpty() || scholarship.isEmpty()){
            this.displayWarning("Preencha todos os campos!");
            return;
        }

        if(!employeeController.isUserAvailable(username)){
            this.displayWarning("Usuario ja utilizado!");
            return;
        }

        employeeController.createEmployee(name, username, password, scholarship);
        this.displayWarning("Empregado criado com sucesso!");
        this.clearFields();
    }

    public void clearFields(){
        this.nameField.setText("");
        this.userField.setText("");
        this.passwordField.setText("");
        this.scholarshipField.setText("");
    }

    public static void main(String args[]){
        new CreateEmployee();
    }

}