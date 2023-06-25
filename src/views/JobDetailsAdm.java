package views;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import controllers.JobController;
import models.Job;
import models.Company;
import views.components.Button;
import views.components.TextField;
import views.components.TextLabel;
import views.components.ComboBox;

public class JobDetailsAdm extends Screen{
	private final Company company;
	private final Job job;
	private final JobController jobController = new JobController();
	private final JPanel panel = new JPanel();
	private final JPanel title = new JPanel();
	private final JPanel content = new JPanel();
	private final Button updateButton = new Button("Salvar");
	private final Button deleteButton = new Button("Excluir");
	private final Button companyButton = new Button("Ver Empresa");
	private final TextField salaryField = new TextField();
	private final ComboBox modalityField = new ComboBox(JobController.getModalities());
	private final TextField workloadField = new TextField();
	private final TextField occupationAreaField = new TextField();
	private final TextField requirementsField = new TextField();
	
	public JobDetailsAdm(Company company, Job job) {
		super();
		
		this.company = company;
		this.job = job;
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.content.setLayout(new BoxLayout(this.content, BoxLayout.Y_AXIS));
		this.companyButton.setPreferredSize(new Dimension(150, 30));

		JPanel name = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel jobName = new JLabel(job.getName());
		name.setBackground(new Color(75, 44, 44));
		jobName.setFont(new Font("Regular", Font.BOLD, 20));
		jobName.setForeground(Color.WHITE);
		name.add(jobName);
		
		JPanel salary = new JPanel(new FlowLayout(FlowLayout.LEFT));
		salary.add(new TextLabel("*Salário (em reais): "));
		salaryField.setText(Integer.toString(job.getSalary()));
		salary.add(salaryField);
		
		JPanel modality = new JPanel(new FlowLayout(FlowLayout.LEFT));
		modality.add(new TextLabel("*Modalidade: "));
		modalityField.setSelectedItem(job.getModality());
		modality.add(modalityField);
		
		JPanel workload = new JPanel(new FlowLayout(FlowLayout.LEFT));
		workload.add(new TextLabel("*Carga horária semanal (em horas): "));
		workloadField.setText(Integer.toString(job.getWorkload()));
		workload.add(workloadField);
		
		JPanel occupationArea = new JPanel(new FlowLayout(FlowLayout.LEFT));
		occupationArea.add(new TextLabel("*Área de Ocupação: "));
		occupationAreaField.setText(job.getOccupationArea());
		occupationArea.add(occupationAreaField);
		
		JPanel requirements = new JPanel(new FlowLayout(FlowLayout.LEFT));
		requirements.add(new TextLabel("Requerimentos (separe por virgula): "));
		requirementsField.setText(job.getRequirements());
		requirements.add(requirementsField);
		
		JPanel buttons = new JPanel();
		this.updateButton.addActionListener(this::updateJob);
		this.deleteButton.addActionListener(this::deleteJob);
        buttons.add(this.updateButton);
        buttons.add(this.deleteButton);
		buttons.add(this.companyButton);

		this.companyButton.addActionListener(this::displayCompany);

        this.title.add(name);

		this.content.add(salary);
		this.content.add(modality);
		this.content.add(workload);
		this.content.add(occupationArea);
		this.content.add(requirements);		
		this.content.add(buttons);
		
		this.panel.add(title);
		this.panel.add(content);
		this.add(panel);
		this.display();
	}

	private void displayCompany(ActionEvent event) {
		new CompanyAdm(company);
		this.dispose();
	}
	
	private void updateJob(ActionEvent action) {
		String occupationArea = this.occupationAreaField.getText().trim();
		String salaryStr = this.salaryField.getText().trim();
		String workloadStr = this.workloadField.getText().trim();
		String requirements = requirementsField.getText().trim();
		String modality = modalityField.getSelectedItem().toString();
		
		if(occupationArea.isEmpty() || salaryStr.isEmpty() || workloadStr.isEmpty()) {
			this.displayWarning("Preencha todos os campos assinalados com o simbolo (*)!");
		}
		
		int salary = JobController.getValidSalary(salaryStr);
		int workload = JobController.getValidWorkload(workloadStr);
		
		if(salary < 0 || workload < 0) {
            this.displayWarning("Insira um valor inteiro não-negativo válido!");

            if(salary < 0)
                this.salaryField.setText("");

            if(workload < 0)
                this.workloadField.setText("");

            return;
        }
		
		jobController.updateOccupationArea(job, occupationArea);
		jobController.updateRequirements(job, requirements);
		jobController.updateSalary(job, salary);
		jobController.updateWorkload(job, workload);
		jobController.updateModality(job, modality);
		
	}
	
	private void deleteJob(ActionEvent action) {
		jobController.deleteJob(job, company);
	}

	//public static void main(String[] args) {
	//	Job job = new Job("Desenvolvedor Front-end", 2100, 8, "Remoto", "Tecnologia" );
	//	job.addRequirement("UML");
    //    job.addRequirement("OOP");
    //    job.addRequirement("Java");
        
	//	new JobDetailsAdmScreen(job);

	//}

}
