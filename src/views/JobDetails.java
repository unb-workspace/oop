package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import models.Job;
import models.Company;
import views.components.TextLabel;
import views.components.Button;

/**
 * Tela de visualização de detalhes de uma vaga de emprego.
 * @see Screen
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.0 
 */
public class JobDetails extends Screen {
	private final Company company;
	private final Job job;
	private final JPanel panel = new JPanel();
	private final JPanel title = new JPanel();
	private final JPanel content = new JPanel();
	private final Button showCompanyButton = new Button("Ver Empresa");
	private final Button backButton = new Button("Voltar");
	
	/**
	 * Método construtor responsável pela criação da tela de visualização de detalhes de uma vaga de emprego.
	 * @param company define a empresa da vaga de emprego.
	 * @param job define a vaga de emprego.
	 */
	public JobDetails(Company company, Job job) {
		super();
		this.company = company;
		this.job = job;

		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.content.setLayout(new BoxLayout(this.content, BoxLayout.Y_AXIS));
		this.content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.showCompanyButton.setPreferredSize(new Dimension(150, 30));
		
		JPanel name = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel jobName = new JLabel(job.getName());

		jobName.setFont(new Font("Regular", Font.BOLD, 20));
		jobName.setForeground(Color.WHITE);
		name.setBackground(new Color(75, 44, 44));
		name.add(jobName);
		
		JPanel salary = new JPanel(new FlowLayout(FlowLayout.LEFT));
		salary.add(new TextLabel("Salário (em reais): " + job.getSalary()));
		
		JPanel modality = new JPanel(new FlowLayout(FlowLayout.LEFT));
		modality.add(new TextLabel("Modalidade: " + job.getModality()));
		
		JPanel workload = new JPanel(new FlowLayout(FlowLayout.LEFT));
		workload.add(new TextLabel("Carga horária semanal (em horas): " + job.getWorkload()));
		
		JPanel occupationArea = new JPanel(new FlowLayout(FlowLayout.LEFT));
		occupationArea.add(new TextLabel("Área de Ocupação: " + job.getOccupationArea()));
		
		JPanel requirements = new JPanel(new FlowLayout(FlowLayout.LEFT));
		requirements.add(new TextLabel("Requisitos: " + job.getRequirements()));

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.showCompanyButton.addActionListener(this::showCompany);
		this.backButton.addActionListener(this::back);
		buttonPanel.add(this.showCompanyButton);
		buttonPanel.add(this.backButton);

        this.title.add(name);

		this.content.add(salary);
		this.content.add(modality);
		this.content.add(workload);
		this.content.add(occupationArea);
		this.content.add(requirements);		
		this.content.add(buttonPanel);

		this.panel.add(title);
		this.panel.add(content);
		this.add(panel);
		this.display();
	}

	/**
	 * Método responsável por mostrar a empresa da vaga de emprego ao clicar no botão "Ver Empresa".
	 * @param event define o evento de clique no botão.
	 */
	private void showCompany(ActionEvent event) {
		new ShowCompany(this.company, this.job);
		this.dispose();
	}

	/**
	 * Método responsável por voltar à tela de busca de vagas de emprego ao clicar no botão "Voltar".
	 * @param event define o evento de clique no botão.
	 */
	private void back(ActionEvent event) {
		new SearchJobs("employee");
		this.dispose();
	}
}
