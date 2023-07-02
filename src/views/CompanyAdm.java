package views;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import models.Company;
import views.components.TextField;
import views.components.Button;
import views.components.TextLabel;
import views.components.ComboBox;
import controllers.CompanyController;

/**
 * Tela de visualização e edição de empresa.
 * @see Screen
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.0
 */
public class CompanyAdm extends Screen {	
	private final CompanyController companyController = new CompanyController();
	private final JPanel panel = new JPanel();
	private final JPanel content = new JPanel();
	private final Button updateButton = new Button("Salvar");
	private final Button deleteButton = new Button("Excluir");
	private final TextField nameField = new TextField();
	private final TextField emailField = new TextField();
    private final ComboBox stateField = new ComboBox(CompanyController.availableRegions);
    private final TextField cityField = new TextField();
    private final TextField streetField = new TextField();
    private final TextField occupationAreaField = new TextField();
    private final Company company;
	
	/**
	 * Método construtor responsável pela criação da tela de visualizaçãoe  edição de empresa.
	 * @param company define a empresa a ser visualizada e/ou editada.
	 */
	public CompanyAdm(Company company) {
		super();
		
		this.company = company;
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.content.setLayout(new BoxLayout(this.content, BoxLayout.Y_AXIS));
		this.content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		namePanel.add(new TextLabel("Nome da empresa: "));
		nameField.setText(company.getName());
		namePanel.add(nameField);

		JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		emailPanel.add(new TextLabel("Email: "));
		emailField.setText(company.getEmail());
		emailPanel.add(emailField);
		
		JPanel statePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statePanel.add(new TextLabel("Estado: "));
		stateField.setSelectedItem((company.getAddress()).getState());
		statePanel.add(stateField);
		
		JPanel cityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cityPanel.add(new TextLabel("Cidade: "));
		cityField.setText((company.getAddress()).getCity());
		cityPanel.add(cityField);
		
		JPanel streetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		streetPanel.add(new TextLabel("Rua: "));
		streetField.setText((company.getAddress()).getStreet());
		streetPanel.add(streetField);
		
		JPanel ownerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ownerPanel.add(new TextLabel("Representante: " + company.getRepresentant()));
		
		JPanel occupationAreaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		occupationAreaPanel.add(new TextLabel("Área de ocupação: "));
		occupationAreaField.setText(company.getOccupationArea());
		occupationAreaPanel.add(occupationAreaField);
		
		JPanel buttons = new JPanel();
		this.updateButton.addActionListener(this::updateCompany);
		this.deleteButton.addActionListener(this::deleteCompany);
        buttons.add(this.updateButton);
        buttons.add(this.deleteButton);

		this.content.add(namePanel);
		this.content.add(emailPanel);
		this.content.add(statePanel);
		this.content.add(cityPanel);
		this.content.add(streetPanel);
		this.content.add(occupationAreaPanel);
		this.content.add(ownerPanel);
		this.content.add(buttons);
		
		this.panel.add(content);
		this.add(panel);
		this.display();
	}
	
	/**
	 * Método responsável por atualizar os dados da empresa ao clicar no botão "Salvar".
	 * @param action define o evento de clique no botão.	
	 */
	private void updateCompany(ActionEvent action) {
		String name = this.nameField.getText().trim();
		String email = this.emailField.getText().trim();
		String state = this.stateField.getSelectedItem().toString();
		String city = this.cityField.getText().trim();
		String street = this.streetField.getText().trim();
		String occupationArea = this.occupationAreaField.getText().trim();
		
		if(name.isEmpty() || email.isEmpty() || city.isEmpty() || street.isEmpty() || occupationArea.isEmpty()) {
			this.displayWarning("Preencha todos os campos!");
			return;
		}

		companyController.updateName(company, name);
		companyController.updateEmail(company, email); 
		companyController.updateState(company, state);
		companyController.updateCity(company, city);
		companyController.updateStreet(company, street);
		companyController.updateOccupationArea(company, occupationArea);
		this.displaySuccess("employer");
	}
	
	/**
	 * Método responsável por excluir a empresa ao clicar no botão "Excluir".
	 * @param event define o evento de clique no botão.
	 */
	private void deleteCompany(ActionEvent event) {
		companyController.deleteCompany(company);
		this.displaySuccess("employer");
	}
}
