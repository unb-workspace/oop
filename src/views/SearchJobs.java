package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;
import java.util.ArrayList;
import views.components.Button;
import views.components.ComboBox;
import views.components.TextField;
import controllers.CompanyController;
import controllers.JobController;
import controllers.EmployerController;
import models.Company;
import models.Employer;
import models.Job;

public class SearchJobs extends Screen {
    private final Object[] displayTypes = { "Vaga", "Empresa"};
    private final String default_option = "Qualquer região";
    private final CompanyController companyController = new CompanyController();
    private final JobController jobController = new JobController();
    private final EmployerController employerController = new EmployerController();
    private final JPanel bodyPanel = new JPanel(new BorderLayout());
    private final JPanel filter = new JPanel();
    private final JPanel jobListPanel = new JPanel();
    private final ComboBox filterRegion = new ComboBox(companyController.getCompanyRegions().toArray());
    private final ComboBox filterBox = new ComboBox(displayTypes);
    private final TextField searchField = new TextField();
    private final Button searchButton = new Button("Buscar");
    private final Font fontText = new Font("Arial", Font.BOLD, 12);
    private final ImageIcon createAccountIcon = new ImageIcon("src/resources/images/create_account_icon.png");
    private final ImageIcon companyIcon = new ImageIcon(new ImageIcon("src/resources/images/company_icon.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private final ImageIcon jobIcon = new ImageIcon(new ImageIcon("src/resources/images/job_icon.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private JList<Object> displayedJobs;
    private final String userType;

    public SearchJobs(String userType) { // employer or employee
        super();
        this.userType = userType;
        this.addCreateAccountButton();
        this.createFilter();
        this.createList();

        if(userType.equals("employer")) {
            this.addCompanyButton();
            this.addJobButton();
        }

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
        button.addActionListener(event -> {
            if(this.userType.equals("employer")) {
                new CreateEmployer();
            }
            else {
                new CreateEmployee();
            }

            this.dispose();
        });

        this.header.add(button, constraint);
    }

    private void addCompanyButton() {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.anchor = GridBagConstraints.WEST;
        constraint.gridx = 1;
        constraint.insets = insets;

        JButton button = new JButton(companyIcon);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(null);
        button.setPreferredSize(new Dimension(50, 50));
        button.addActionListener(event -> {
            new CreateCompany();
            this.dispose();
        });

        this.header.add(button, constraint);
    }

    private void addJobButton() {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.anchor = GridBagConstraints.WEST;
        constraint.gridx = 2;
        constraint.insets = insets;

        JButton button = new JButton(jobIcon);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(null);
        button.setPreferredSize(new Dimension(50, 50));
        button.addActionListener(event -> {
            new AddJob();
            this.dispose();
        });

        this.header.add(button, constraint);
    }

    private void createFilter() {
        this.filter.setLayout(new GridLayout(5, 2, 5, 5));
        
        searchField.setPreferredSize(new Dimension(300, 30));
        filterBox.setPreferredSize(new Dimension(100, 20));
        filterRegion.setPreferredSize(new Dimension(150, 20));

        filterRegion.addItem(this.default_option);
        filterRegion.setSelectedItem(this.default_option);
        
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
        this.searchButton.addActionListener(this::filterAction);
        buttonPanel.add(searchButton);

        this.filter.add(textPanel);
        this.filter.add(searchPanel);
        this.filter.add(filterPanel);
        this.filter.add(buttonPanel);

        this.bodyPanel.add(filter, BorderLayout.NORTH);
    }

    private void createList() {
        ArrayList<String> jobs = jobController.getJobsList(companyController.getCompanies());
        this.setDisplayedJobs(jobs.toArray());
        
        this.bodyPanel.add(jobListPanel, BorderLayout.CENTER);
    }

    private void filterAction(ActionEvent action) {
        String region = (String) filterRegion.getSelectedItem();
        String type = (String) filterBox.getSelectedItem();
        String name = searchField.getText().trim();
        ArrayList<String> jobs;
        ArrayList<Company> companies;
        
        if(!Objects.equals(region, this.default_option)) {
            companies = companyController.filterCompaniesByRegion(region);
        }
        else {
            companies = companyController.getCompanies();
        }

        if(!name.isEmpty() && Objects.equals(type, "Vaga")) {
            jobs = jobController.filterJobsByName(name, companies);
        }
        else if(!name.isEmpty() && Objects.equals(type, "Empresa")) {
            jobs = jobController.listCompaniesJob(companyController.filterCompaniesByName(name, companies));
        }
        else {
            jobs = jobController.getJobsList(companies);
        }

        this.setDisplayedJobs(jobs.toArray());
    }

    public void setDisplayedJobs(Object[] jobs) {
        displayedJobs = new JList<>(jobs);
        JScrollPane listScroller = new JScrollPane(displayedJobs);

        listScroller.setPreferredSize(new Dimension(360, 300));
        listScroller.setBorder(BorderFactory.createEmptyBorder());
        listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        displayedJobs.setBackground(this.backgroundColor);
        displayedJobs.setBorder(new EmptyBorder(15, 15, 0, 15));
        displayedJobs.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        displayedJobs.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        displayedJobs.setVisibleRowCount(-1);
        displayedJobs.addListSelectionListener(this::getSelectedItem);
        
        this.jobListPanel.removeAll();
        this.jobListPanel.add(listScroller);
        this.jobListPanel.revalidate();
        this.jobListPanel.repaint();
    }

    private void getSelectedItem(ListSelectionEvent event) {
        if(!displayedJobs.getValueIsAdjusting())
            return;

        String selected = displayedJobs.getSelectedValue().toString();
        String jobName = selected.split("Nome da vaga: ")[1].split("<br>")[0];

        Employer employer = employerController.getEmployerByUsername(selected.split("Representante: ")[1].split("<br>")[0]);
        Company company = employer.getCompany();

        Job job = jobController.getJobByName(company, jobName);

        if(userType.equals("employer")) {
            new JobDetailsAdm(job);
        }
        else {
            new JobDetails(job);
        }

        this.dispose();
    }
}