import components.Button;
import components.ComboBox;
import components.TextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class Main extends Screen {
    private final Object[] displayTypes = { "Vaga", "Empresa"};
    private final String userType;
    
    CompanyController companyController = new CompanyController();
    JobController jobController = new JobController();

    JPanel bodyPanel = new JPanel(new BorderLayout());
    JPanel filter = new JPanel();
    JPanel jobListPanel = new JPanel();

    Font fontText = new Font("Arial", Font.BOLD, 12);
    ImageIcon createAccountIcon = new ImageIcon("src/resources/images/create_account_icon.png");
    JButton searchButton = new Button("Buscar");

    public Main(String userType) { // employer or employee
        super();
        this.userType = userType;
        this.addCreateAccountButton();
        this.createFilter();
        this.createList();

        this.add(bodyPanel, BorderLayout.CENTER);

        this.display();
    }

    private void addCreateAccountButton() {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.anchor = GridBagConstraints.WEST;
        constraint.gridx = 0;
        constraint.insets = insets;

        JButton button = new JButton(createAccountIcon);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(null);
        button.setPreferredSize(new Dimension(50, 50));

        this.header.add(button, constraint);
    }

    private void createFilter() {
        ComboBox filterRegion = new ComboBox(companyController.getCompanyRegions().toArray());
        ComboBox filterBox = new ComboBox(displayTypes);

        TextField searchField = new TextField();

        this.filter.setLayout(new GridLayout(5, 2, 5, 5));
        
        searchField.setPreferredSize(new Dimension(300, 30));
        filterBox.setPreferredSize(new Dimension(100, 20));
        filterRegion.setPreferredSize(new Dimension(150, 20));

        filterRegion.addItem("Qualquer região");
        filterRegion.setSelectedItem("Qualquer região");
        
        JLabel filterText = new JLabel("Digite o nome da empresa ou vaga desejada");
        filterText.setFont(fontText);

        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        textPanel.add(filterText);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchPanel.add(searchField);

        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        filterPanel.add(filterRegion);
        filterPanel.add(filterBox);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(searchButton);

        this.filter.add(textPanel);
        this.filter.add(searchPanel);
        this.filter.add(filterPanel);
        this.filter.add(buttonPanel);

        this.bodyPanel.add(filter, BorderLayout.NORTH);
    }

    private void createList() {
        ArrayList<String> jobs = jobController.getJobsList(companyController.getCompanies());
        JList<Object> displayedJobs = new JList<>(jobs.toArray());
        JScrollPane listScroller = new JScrollPane(displayedJobs);

        listScroller.setPreferredSize(new Dimension(300, 300));
        listScroller.setBorder(BorderFactory.createEmptyBorder());
        listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        displayedJobs.setBackground(this.backgroundColor);
        displayedJobs.setBorder(new EmptyBorder(15, 15, 0, 15));
        displayedJobs.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        displayedJobs.setVisibleRowCount(-1);

        this.jobListPanel.add(listScroller);
        this.bodyPanel.add(jobListPanel, BorderLayout.CENTER);
    }

    public static void main(String args[]) {
        CompanyController companyController = new CompanyController();

        Company company = companyController.createCompany("Empresa", "emp@gmail.com", "Brasilia", "Taguatinga", "101", "Tecnologia", "caio-felipee");
        companyController.createCompany("Empresa", "emp@gmail.com", "Sao Paulo", "Taguatinga", "101", "Tecnologia", "caio-felipee");
        companyController.createCompany("Empresa", "emp@gmail.com", "Rio de Janeiro", "Taguatinga", "101", "Tecnologia", "caio-felipee");
        companyController.createCompany("Empresa", "emp@gmail.com", "Belo Horizonte", "Taguatinga", "101", "Tecnologia", "caio-felipee");

        Job job = new Job("Job", 3000, 8, "Presencial", "Tecnologia");
        Job job2 = new Job("Job2", 5000,    3, "Presencial", "Boate");
        Job job3 = new Job("Job3", 3000, 8, "Presencial", "Tecnologia");
        Job job4 = new Job("Job4", 5000, 3, "Presencial", "Boate");
        company.addJob(job);
        company.addJob(job2);
        company.addJob(job4);
        // company.addJob(job3);
        // company.addJob(job);
        // company.addJob(job2);
        // company.addJob(job4);
        // company.addJob(job3);

        new Main("employer");
     }
}
