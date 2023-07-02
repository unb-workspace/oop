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

/**
 * Tela de visualização e edição de vaga de emprego.
 * @see Screen
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.0 
 */
public class JobDetailsAdm extends Screen{
	private final Company company;
	private final Job job;
	private final JobController jobController = new JobController();
	private final JPanel panel = new JPanel();
	private final JPanel content = new JPanel();
	private final Button updateButton = new Button("Salvar");
	private final Button deleteButton = new Button("Excluir");
	private final Button companyButton = new Button("Ver Empresa");
	private final TextField nameField = new TextField();
	private final TextField salaryField = new TextField();
	private final ComboBox modalityField = new ComboBox(JobController.getModalities());
	private final TextField workloadField = new TextField();
	private final TextField occupationAreaField = new TextField();
	private final TextField requirementsField = new TextField();
	
	/**
	 * Método construtor responsável pela criação da tela de visualização e edição de vaga de emprego.
	 * @param company define a empresa da vaga de emprego.
	 * @param job define a vaga de emprego.
	 */
	public JobDetailsAdm(Company company, Job job) {
		super();
		
		this.company = company;
		this.job = job;
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.content.setLayout(new BoxLayout(this.content, BoxLayout.Y_AXIS));
		this.content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.companyButton.setPreferredSize(new Dimension(150, 30));

		JPanel name = new JPanel(new FlowLayout(FlowLayout.LEFT));
		name.add(new TextLabel("*Nome da vaga: "));
		nameField.setText(job.getName());
		name.add(nameField);

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

        this.content.add(name);
		this.content.add(salary);
		this.content.add(modality);
		this.content.add(workload);
		this.content.add(occupationArea);
		this.content.add(requirements);		
		this.content.add(buttons);
		
		this.panel.add(content);
		this.add(panel);
		this.display();
	}

	/**
	 * Método responsável por exibir a tela de visualização de empresa.
	 * @param event define o evento de clique no botão.
	 */
	private void displayCompany(ActionEvent event) {
		new CompanyAdm(company);
		this.dispose();
	}
	
	/**
	 * Método responsável por atualizar os dados da vaga de emprego.
	 * @param action define o evento de clique no botão.
	 */
	private void updateJob(ActionEvent action) {
		String name = this.nameField.getText().trim();
		String occupationArea = this.occupationAreaField.getText().trim();
		String salaryStr = this.salaryField.getText().trim();
		String workloadStr = this.workloadField.getText().trim();
		String requirements = requirementsField.getText().trim();
		String modality = modalityField.getSelectedItem().toString();
		
		if(name.isEmpty() || occupationArea.isEmpty() || salaryStr.isEmpty() || workloadStr.isEmpty()) {
			this.displayWarning("Preencha todos os campos assinalados com o simbolo (*)!");
			return;
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
		
		jobController.updateName(job, name);
		jobController.updateOccupationArea(job, occupationArea);
		jobController.updateRequirements(job, requirements);
		jobController.updateSalary(job, salary);
		jobController.updateWorkload(job, workload);
		jobController.updateModality(job, modality);
		this.displaySuccess("employer");
	}
	
	/**
	 * Método responsável por excluir uma vaga de emprego.
	 * @param action define o evento de clique no botão.
	 */
	private void deleteJob(ActionEvent action) {
		jobController.deleteJob(job, company);
		this.displaySuccess("employer");
	}
}
