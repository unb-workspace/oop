import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CreateEmployee extends Screen{
    Font fontField = new Font("Arial", Font.BOLD, 15);
    Dimension textFieldSize = new Dimension(200, 30);
    Color colorField = new Color(199, 194, 194);

    private EmployeeController employeeController = new EmployeeController();
    private final JPanel panel = new JPanel();
    private final JTextField nameField = new JTextField();
    private final JTextField userField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JTextField scholarshipField = new JTextField();
    private final JButton createButton = new JButton("Criar");

    public CreateEmployee(){
        super("Adicionar Empregado");

        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.nameField.setPreferredSize(this.textFieldSize);
        this.userField.setPreferredSize(this.textFieldSize);
        this.passwordField.setPreferredSize(this.textFieldSize);
        this.scholarshipField.setPreferredSize(this.textFieldSize);

        this.nameField.setBackground(colorField);
        this.userField.setBackground(colorField);
        this.passwordField.setBackground(colorField);
        this.scholarshipField.setBackground(colorField);
        this.createButton.setBackground(headerColor);

        this.nameField.setBorder(BorderFactory.createEmptyBorder());
        this.userField.setBorder(BorderFactory.createEmptyBorder());
        this.passwordField.setBorder(BorderFactory.createEmptyBorder());
        this.scholarshipField.setBorder(BorderFactory.createEmptyBorder());
        this.createButton.setBorder(BorderFactory.createEmptyBorder());

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(createTextLabel("Nome:"));
        namePanel.add(this.nameField);

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userPanel.add(createTextLabel("Usuario:"));
        userPanel.add(this.userField);

        JPanel scholarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        scholarPanel.add(createTextLabel("Escolaridade:"));
        scholarPanel.add(this.scholarshipField);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.add(createTextLabel("Senha:"));
        passwordPanel.add(this.passwordField);

        JPanel buttonPanel = new JPanel();
        this.createButton.setForeground(this.backgroundColor);
        this.createButton.setFont(new Font("Arial",Font.BOLD,17));
        this.createButton.setBorder(BorderFactory.createEmptyBorder());
        this.createButton.setPreferredSize(new Dimension(100,30));
        this.createButton.addActionListener(this::createEmployee);
        buttonPanel.add(this.createButton);

        this.panel.add(namePanel);
        this.panel.add(userPanel);
        this.panel.add(passwordPanel);
        this.panel.add(scholarPanel);
        this.panel.add(createButton);

        this.add(panel);
        this.display();
    }
    private JLabel createTextLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(this.fontField);

        return label;
    }

    private void createEmployee(ActionEvent action){
        String name = this.nameField.getText().trim();
        String username = this.userField.getText().trim();
        String password = String.valueOf(this.passwordField.getPassword());
        String scholarship = this.scholarshipField.getText().trim();

        if(name.isEmpty() || username.isEmpty() || password.isEmpty() || scholarship.isEmpty()){
            this.displayWarning("Preencha todos os campos");
            return;
        }
        if(employeeController.isUserAvailable(username)){
            employeeController.createEmployee(name,username,password,scholarship);
            this.displayWarning("Empregado criado com sucesso");
            this.clearFields();
        }
        else{
            this.displayWarning("Usuario ja utilizado");
        }
        System.out.println(Data.getEmployees());

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
