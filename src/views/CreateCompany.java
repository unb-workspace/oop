import javax.swing.*;

import components.TextField;
import components.Button;
import components.ComboBox;
import components.TextLabel;

import java.awt.*;
import java.awt.event.ActionEvent;

public class CreateCompany extends Screen {
    Dimension textFieldSize = new Dimension(200, 30);
    Color colorField = new Color(199, 194, 194);

    private final CompanyController companyController = new CompanyController();
    private final EmployerController employerController = new EmployerController();
    private final JPanel panel = new JPanel();
    private final TextField nameField = new TextField();
    private final TextField emailField = new TextField();
    private final TextField stateField = new TextField();
    private final TextField cityField = new TextField();
    private final TextField streetField = new TextField();
    private final TextField occupationAreaField = new TextField();
    private final Button createButton = new Button("Criar");
    private final ComboBox ownerField = new ComboBox(employerController.getEmployers().keySet().toArray());

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

    private void createCompany(ActionEvent action) {
        String name = this.nameField.getText().trim();
        String email = this.emailField.getText().trim();
        String state = this.stateField.getText().trim();
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
        this.displayWarning("Empresa criada com sucesso!");
        this.clearFields();
    }

    private void clearFields() {
        this.nameField.setText("");
        this.emailField.setText("");
        this.stateField.setText("");
        this.cityField.setText("");
        this.streetField.setText("");
        this.occupationAreaField.setText("");
    }

    //  public static void main(String args[]) {
    //      Employer e1 = new Employer("thegm445", "445", "Gabriel Moura");
    //      Employer e2 = new Employer("caio-felipee", "12345", "Caio Felipe");
    //      Employer e3 = new Employer("thuzin-gameplays", "3243", "Arthur");
    //      Employer e4 = new Employer("anacompetidora12", "4jfd", "Ana");

    //      Company company = new Company("Ifood", "Comida", "fodase@gmail.com");
    //      company.setRepresentant(e1.getUsername());
    //      e1.setCompany(company);

    //      Data.getEmployers().put(e1.username, e1);
    //      Data.getEmployers().put(e2.username, e2);
    //      Data.getEmployers().put(e3.username, e3);
    //      Data.getEmployers().put(e4.username, e4);

    //      new CreateCompany();
    //  }
}