package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import views.components.TextLabel;
import views.components.Button;
import models.Company;
import models.Job;

public class ShowCompany extends Screen {
	private final Company company;
	private final Job job;
	private final JPanel panel = new JPanel();
	private final JPanel title = new JPanel();
	private final JPanel content = new JPanel();
	private final Button backButton = new Button("Voltar");
	
	public ShowCompany(Company company, Job job) {
		super();
		this.company = company;
		this.job = job;

		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.content.setLayout(new BoxLayout(this.content, BoxLayout.Y_AXIS));
		
		JPanel name = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel companyName = new JLabel(company.getName());
		name.setBackground(new Color(75, 44, 44));
		companyName.setFont(new Font("Regular", Font.BOLD, 20));
		companyName.setForeground(Color.WHITE);
		name.add(companyName);
		
		JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		emailPanel.add(new TextLabel("Email: " + company.getEmail()));
		
		JPanel statePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statePanel.add(new TextLabel("Estado: " + (company.getAddress()).getState()));
		
		JPanel cityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cityPanel.add(new TextLabel("Cidade: " + (company.getAddress()).getCity()));
		
		JPanel streetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		streetPanel.add(new TextLabel("Rua: " + (company.getAddress()).getStreet()));
		
		JPanel ownerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ownerPanel.add(new TextLabel("Dono: " + company.getRepresentant()));
		
		JPanel occupationAreaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		occupationAreaPanel.add(new TextLabel("Área de ocupação: " + company.getOccupationArea()));

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.backButton.addActionListener(this::back);
		buttonPanel.add(this.backButton);

        this.title.add(name);

		this.content.add(emailPanel);
		this.content.add(statePanel);
		this.content.add(cityPanel);
		this.content.add(streetPanel);
		this.content.add(ownerPanel);
		this.content.add(occupationAreaPanel);
		this.content.add(buttonPanel);
		
		this.panel.add(title);
		this.panel.add(content);
		this.add(panel);
		this.display();
	}

	private void back(ActionEvent event) {
		new JobDetails(this.company, this.job);
		this.dispose();
	}
}
