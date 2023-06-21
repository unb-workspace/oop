import java.awt.*;

import javax.swing.*;
import components.TextLabel;

public class ShowCompany extends Screen{
	private final JPanel panel = new JPanel();
	private final JPanel title = new JPanel();
	private final JPanel content = new JPanel();
	
	public ShowCompany(Company company) {
		super();
		
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
		ownerPanel.add(new TextLabel("Dono: "));
		
		JPanel occupationAreaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		occupationAreaPanel.add(new TextLabel("Área de ocupação: " + company.getOccupationArea()));

        this.title.add(name);

		this.content.add(emailPanel);
		this.content.add(statePanel);
		this.content.add(cityPanel);
		this.content.add(streetPanel);
		this.content.add(ownerPanel);
		this.content.add(occupationAreaPanel);
		
		this.panel.add(title);
		this.panel.add(content);
		this.add(panel);
		this.display();
	}

	//public static void main(String[] args) {
	//	Address endereco = new Address("Bahia", "California", "Pertino");
	//	Company empresa = new Company( "EhPow", "Tecnologia", "emprego@ehpow.com", endereco );
        
	//	new CompanyDetailsScreen(empresa);

	//}

}
