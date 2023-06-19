import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CreateCompany extends Screen {
    Font fontField = new Font("Arial", Font.BOLD, 15);
    Dimension textFieldSize = new Dimension(200, 30);
    Color colorField = new Color(199, 194, 194);

    private final CompanyController companyController = new CompanyController();
    private final EmployerController employerController = new EmployerController();
    private final JPanel panel = new JPanel();
    private final JTextField nameField = new JTextField();
    private final JTextField emailField = new JTextField();
    private final JTextField stateField = new JTextField();
    private final JTextField cityField = new JTextField();
    private final JTextField streetField = new JTextField();
    private final JTextField occupationAreaField = new JTextField();
    private final JButton createButton = new JButton("Criar");
    private final JComboBox<Object> ownerField = new JComboBox<Object>(employerController.getEmployers().keySet().toArray());

    public CreateCompany() {
        super("Criar Empresa");

        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.nameField.setPreferredSize(this.textFieldSize);
        this.emailField.setPreferredSize(this.textFieldSize);
        this.stateField.setPreferredSize(this.textFieldSize);
        this.cityField.setPreferredSize(this.textFieldSize);
        this.streetField.setPreferredSize(this.textFieldSize);
        this.ownerField.setPreferredSize(this.textFieldSize);
        this.occupationAreaField.setPreferredSize(this.textFieldSize);

        this.nameField.setBackground(colorField);
        this.emailField.setBackground(colorField);
        this.stateField.setBackground(colorField);
        this.cityField.setBackground(colorField);
        this.streetField.setBackground(colorField);
        this.ownerField.setBackground(colorField);
        this.occupationAreaField.setBackground(colorField);
        this.createButton.setBackground(this.headerColor);

        this.nameField.setBorder(BorderFactory.createEmptyBorder());
        this.emailField.setBorder(BorderFactory.createEmptyBorder());
        this.stateField.setBorder(BorderFactory.createEmptyBorder());
        this.cityField.setBorder(BorderFactory.createEmptyBorder());
        this.streetField.setBorder(BorderFactory.createEmptyBorder());
        this.ownerField.setBorder(BorderFactory.createEmptyBorder());
        this.occupationAreaField.setBorder(BorderFactory.createEmptyBorder());
        this.createButton.setBorder(BorderFactory.createEmptyBorder());

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(createTextLabel("Nome:"));
        namePanel.add(this.nameField);

        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPanel.add(createTextLabel("E-mail:"));
        emailPanel.add(this.emailField);

        JPanel statePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statePanel.add(createTextLabel("Estado:"));
        statePanel.add(this.stateField);

        JPanel cityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cityPanel.add(createTextLabel("Cidade:"));
        cityPanel.add(this.cityField);

        JPanel streetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        streetPanel.add(createTextLabel("Rua:"));
        streetPanel.add(this.streetField);

        JPanel occupationAreaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        occupationAreaPanel.add(createTextLabel("Area de Ocupacao:"));
        occupationAreaPanel.add(this.occupationAreaField);

        JPanel ownerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ownerPanel.add(createTextLabel("Representante:"));
        ownerPanel.add(this.ownerField);

        JPanel buttonPanel = new JPanel();
        this.createButton.setForeground(this.backgroundColor);
        this.createButton.setFont(new Font("Arial", Font.BOLD, 17));
        this.createButton.setBorder(BorderFactory.createEmptyBorder());
        this.createButton.setPreferredSize(new Dimension(80, 30));
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

    private JLabel createTextLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(this.fontField);

        return label;
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

//     public static void main(String args[]) {
//         Employer e1 = new Employer("thegm445", "445", "Gabriel Moura");
//         Employer e2 = new Employer("caio-felipee", "12345", "Caio Felipe");
//         Employer e3 = new Employer("thuzin-gameplays", "3243", "Arthur");
//         Employer e4 = new Employer("anacompetidora12", "4jfd", "Ana");
//
//         Company company = new Company("Ifood", "Comida", "fodase@gmail.com");
//         company.setRepresentant(e1.getUsername());
//         e1.setCompany(company);
//
//         Data.getEmployers().put(e1.username, e1);
//         Data.getEmployers().put(e2.username, e2);
//         Data.getEmployers().put(e3.username, e3);
//         Data.getEmployers().put(e4.username, e4);
//
//         new CreateCompanyScreen();
//     }
}