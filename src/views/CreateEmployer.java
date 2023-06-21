import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class CreateEmployer extends Screen{
    Font fontField = new Font("Arial", Font.BOLD, 15);
    Dimension textFieldSize = new Dimension(200, 30);
    Color colorField = new Color(199, 194, 194);

    private EmployerController employerController = new EmployerController();
    private final JPanel panel = new JPanel();
    private final JTextField nameField = new JTextField();
    private final JTextField userField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JTextField roleField = new JTextField();
    private final JButton createButton = new JButton("Criar");

    public CreateEmployer(){
        super("Adicionar Usuário");

        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.nameField.setPreferredSize(this.textFieldSize);
        this.userField.setPreferredSize(this.textFieldSize);
        this.passwordField.setPreferredSize(this.textFieldSize);
        this.roleField.setPreferredSize(this.textFieldSize);

        this.nameField.setBackground(colorField);
        this.userField.setBackground(colorField);
        this.passwordField.setBackground(colorField);
        this.roleField.setBackground(colorField);
        this.createButton.setBackground(headerColor);

        this.nameField.setBorder(BorderFactory.createEmptyBorder());
        this.userField.setBorder(BorderFactory.createEmptyBorder());
        this.passwordField.setBorder(BorderFactory.createEmptyBorder());
        this.roleField.setBorder(BorderFactory.createEmptyBorder());
        this.createButton.setBorder(BorderFactory.createEmptyBorder());

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(createTextLabel("Nome:"));
        namePanel.add(this.nameField);

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userPanel.add(createTextLabel("Usuario:"));
        userPanel.add(this.userField);

        JPanel rolePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rolePanel.add(createTextLabel("Cargo:"));
        rolePanel.add(this.roleField);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.add(createTextLabel("Senha:"));
        passwordPanel.add(this.passwordField);

        JPanel buttonPanel = new JPanel();
        this.createButton.setForeground(this.backgroundColor);
        this.createButton.setFont(new Font("Arial",Font.BOLD,17));
        this.createButton.setBorder(BorderFactory.createEmptyBorder());
        this.createButton.setPreferredSize(new Dimension(100,30));
        this.createButton.addActionListener(this::createEmployer);
        buttonPanel.add(this.createButton);

        this.panel.add(namePanel);
        this.panel.add(userPanel);
        this.panel.add(passwordPanel);
        this.panel.add(rolePanel);
        this.panel.add(createButton);

        this.add(panel);
        this.display();
    }
    private JLabel createTextLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(this.fontField);

        return label;
    }

    private void createEmployer(ActionEvent action){
        String name = this.nameField.getText().trim();
        String username = this.userField.getText().trim();
        String password = String.valueOf(this.passwordField.getPassword());
        String role = this.roleField.getText().trim();

        if(name.isEmpty() || username.isEmpty() || password.isEmpty() || role.isEmpty()){
            this.displayWarning("Preencha todos os campos");
            return;
        }
        if(employerController.availableUser(username)){
            employerController.createEmployer(name,username,password,role);
            this.displayWarning("Usuário criado com sucesso!");
            this.clearFields();
        }
        else{
            this.displayWarning("Usuario ja utilizado");
        }
        System.out.println(Data.getEmployers());

    }
    private void clearFields(){
        this.nameField.setText("");
        this.userField.setText("");
        this.passwordField.setText("");
        this.roleField.setText("");
    }

    public static void main(String args[]){
        new CreateEmployer();
    }

}
