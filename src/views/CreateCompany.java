package views;

import javax.swing.*;
import java.awt.*;
import models.Company;
import controllers.CompanyController;
import controllers.EmployerController;
import views.components.TextField;
import views.components.Button;
import views.components.ComboBox;
import views.components.TextLabel;
import java.awt.event.ActionEvent;

/**
 * Tela encarregada pela criação de uma empresa.
 * @see Screen
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.0
 */
public class CreateCompany extends Screen {
    Dimension textFieldSize = new Dimension(200, 30);
    Color colorField = new Color(199, 194, 194);

    private final CompanyController companyController = new CompanyController();
    private final EmployerController employerController = new EmployerController();
    private final JPanel panel = new JPanel();
    private final TextField nameField = new TextField();
    private final TextField emailField = new TextField();
    private final ComboBox stateField = new ComboBox(CompanyController.availableRegions);
    private final TextField cityField = new TextField();
    private final TextField streetField = new TextField();
    private final TextField occupationAreaField = new TextField();
    private final Button createButton = new Button("Criar");
    private final ComboBox ownerField = new ComboBox(employerController.getEmployers().keySet().toArray());

    /**
     * Método construtor responsável pela inicialização da tela de criação de empresa.
     */
    public CreateCompany() {
        super("Criar Empresa");

        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
        this.panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new TextLabel("Nome:"));
        namePanel.add(this.nameField);

        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPanel.add(new TextLabel("E-mail:"));
        emailPanel.add(this.emailField);

        JPanel statePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statePanel.add(new TextLabel("Estado:"));
        statePanel.add(this.stateField);

        JPanel cityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cityPanel.add(new TextLabel("Cidade:"));
        cityPanel.add(this.cityField);

        JPanel streetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        streetPanel.add(new TextLabel("Rua:"));
        streetPanel.add(this.streetField);

        JPanel occupationAreaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        occupationAreaPanel.add(new TextLabel("Area de Ocupacao:"));
        occupationAreaPanel.add(this.occupationAreaField);

        JPanel ownerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ownerPanel.add(new TextLabel("Representante:"));
        ownerPanel.add(this.ownerField);

        JPanel buttonPanel = new JPanel();
        this.createButton.addActionListener(this::createCompany);
        buttonPanel.add(this.createButton);

        this.panel.add(namePanel);
        this.panel.add(emailPanel);
        this.panel.add(statePanel);
        this.panel.add(cityPanel);
        this.panel.add(streetPanel);
        this.panel.add(occupationAreaPanel);
        this.panel.add(ownerPanel);
        this.panel.add(buttonPanel);

        this.add(panel);
        this.display();
    }

    /**
     * Método responsável pela criação de uma empresa ao clicar no botão "Criar".
     * @param action define a ação que será executada.
     */
    private void createCompany(ActionEvent action) {
        String name = this.nameField.getText().trim();
        String email = this.emailField.getText().trim();
        String state = this.stateField.getSelectedItem().toString();;
        String city = this.cityField.getText().trim();
        String street = this.streetField.getText().trim();
        String occupationArea = this.occupationAreaField.getText().trim();
        String owner = this.ownerField.getSelectedItem().toString().trim();

        if(name.isEmpty() || email.isEmpty() || state.isEmpty() || city.isEmpty() || street.isEmpty() || occupationArea.isEmpty() || owner.isEmpty()) {
            this.displayWarning("Preencha todos os campos!");
            return;
        }

        if(employerController.hasCompany(owner)) {
            this.displayWarning("O usuario selecionado ja possui uma empresa!");
            return;
        }

        Company company = companyController.createCompany(name, email, state, city, street, occupationArea, owner);

        employerController.setCompany(owner, company);
        this.displaySuccess("employer");
    }
}