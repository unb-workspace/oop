package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import controllers.EmployerController;
import views.components.TextField;
import views.components.Button;
import views.components.TextLabel;

/**
 * Tela designada à criação de um usuário empregador.
 * @see Screen
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.0
 */
public class CreateEmployer extends Screen{
    Dimension textFieldSize = new Dimension(200, 30);
    Color colorField = new Color(199, 194, 194);

    private EmployerController employerController = new EmployerController();
    private final JPanel panel = new JPanel();
    private final TextField nameField = new TextField();
    private final TextField userField = new TextField();
    private final TextField roleField = new TextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final Button createButton = new Button("Criar");

    /**
     * Método construtor responsável pela inicialização da tela de criação de um usuário empregador.
     */
    public CreateEmployer(){
        super("Adicionar Usuário");

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

        JPanel rolePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rolePanel.add(new TextLabel("Cargo:"));
        rolePanel.add(this.roleField);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.add(new TextLabel("Senha:"));
        passwordPanel.add(this.passwordField);

        JPanel buttonPanel = new JPanel();
        this.createButton.addActionListener(this::createEmployer);
        buttonPanel.add(this.createButton);

        this.panel.add(namePanel);
        this.panel.add(userPanel);
        this.panel.add(passwordPanel);
        this.panel.add(rolePanel);
        this.panel.add(buttonPanel);

        this.add(panel);
        this.display();
    }

    /**
     * Método responsável pela criação de um usuário empregador ao clicar no botão "Criar".
     * @param action define a ação de criação de um usuário empregador.
     */
    private void createEmployer(ActionEvent action){
        String name = this.nameField.getText().trim();
        String username = this.userField.getText().trim();
        String password = String.valueOf(this.passwordField.getPassword());
        String role = this.roleField.getText().trim();

        if(name.isEmpty() || username.isEmpty() || password.isEmpty() || role.isEmpty()){
            this.displayWarning("Preencha todos os campos!");
            return;
        }

        if(!employerController.isUserAvailable(username)){
            this.displayWarning("Usuario ja utilizado!");
            return;
        }
        
        employerController.createEmployer(name, username, password, role);
        this.displaySuccess("employer");

    }
}