import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import components.Button;
import components.TextField;
import components.TextLabel;
import components.ComboBox;

public class CompanyAdm extends Screen {
	
	private final CompanyController companyController = new CompanyController();
	private final JPanel panel = new JPanel();
	private final JPanel title = new JPanel();
	private final JPanel content = new JPanel();
	private final Button updateButton = new Button("Salvar");
	private final Button deleteButton = new Button("Excluir");
	private final JTextField emailField = new TextField();
    private final JTextField stateField = new TextField();
    private final JTextField cityField = new TextField();
    private final JTextField streetField = new TextField();
    private final JTextField occupationAreaField = new TextField();
	
	public CompanyAdm(Company company) {
		super();
		
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.content.setLayout(new BoxLayout(this.content, BoxLayout.Y_AXIS));
		
		JPanel name = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel companyName = new JLabel(company.getName());
		name.setBackground(new Color(75, 44, 44));
		name.add(companyName);
		companyName.setFont(new Font("Regular", Font.BOLD, 20));
		companyName.setForeground(Color.WHITE);
		
		JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		emailPanel.add(new TextLabel("Email: "));
		emailField.setText(company.getEmail());
		emailPanel.add(emailField);
		
		JPanel statePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statePanel.add(new TextLabel("Estado: "));
		stateField.setText((company.getAddress()).getState());
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
		ownerPanel.add(new TextLabel("Representante: " + company.getRepresentant())); // adicionar o owner aq
		
		JPanel occupationAreaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		occupationAreaPanel.add(new TextLabel("Área de ocupação: "));
		occupationAreaField.setText(company.getOccupationArea());
		occupationAreaPanel.add(occupationAreaField);
		
		JPanel buttons = new JPanel();
		this.updateButton.addActionListener(this::updateCompany);
		this.deleteButton.addActionListener(this::deleteCompany);
        buttons.add(this.updateButton);
        buttons.add(this.deleteButton);

        this.title.add(name);

		this.content.add(emailPanel);
		this.content.add(statePanel);
		this.content.add(cityPanel);
		this.content.add(streetPanel);
		this.content.add(occupationAreaPanel);
		this.content.add(ownerPanel);
		this.content.add(buttons);
		
		this.panel.add(title);
		this.panel.add(content);
		this.add(panel);
		this.display();
	}
	
	private void updateCompany(ActionEvent action) {
		String email = this.emailField.getText().trim();
		String state = this.stateField.getText().trim();
		String city = this.cityField.getText().trim();
		String street = this.streetField.getText().trim();
		String occupationArea = this.occupationAreaField.getText().trim();
		
		if(email.isEmpty() || state.isEmpty() || city.isEmpty() || street.isEmpty() || occupationArea.isEmpty()) {
			this.displayWarning("Preencha todos os campos!");
			return;
		}
	}
	
	private void deleteCompany(ActionEvent event) {
		
	}

	public static void main(String[] args) {
		Employer e1 = new Employer("thegm445", "445", "Gabriel Moura");
		Address endereco = new Address("Bahia", "California", "Pertino");
		Company empresa = new Company( "EhPow", "Tecnologia", "emprego@ehpow.com", endereco );
		empresa.setRepresentant("thegm445");
        
		new CompanyAdm(empresa);

	}

}
