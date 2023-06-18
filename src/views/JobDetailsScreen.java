import java.awt.*;

import javax.swing.*;

import components.Button;

public class JobDetailsScreen extends Screen{
	Font fontField = new Font("Arial", Font.BOLD, 15);
	private final JPanel panel = new JPanel();
	Button updateButton = new Button("Editar");
	Button deleteButton = new Button("Excluir");
	
	public JobDetailsScreen(Job job, String type) {
		super();
		
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		
		JPanel name = new JPanel(new FlowLayout(FlowLayout.CENTER));
		name.add(createTextLabel(job.getName()));
		
		JPanel salary = new JPanel(new FlowLayout(FlowLayout.LEFT));
		salary.add(createTextLabel("Salário: R$" + job.getSalary()));
		
		JPanel modality = new JPanel(new FlowLayout(FlowLayout.LEFT));
		modality.add(createTextLabel("Modalidade: " + job.getModality()));
		
		JPanel workload = new JPanel(new FlowLayout(FlowLayout.LEFT));
		workload.add(createTextLabel("Carga Horária: " + job.getWorkload()));
		
		JPanel occupationArea = new JPanel(new FlowLayout(FlowLayout.LEFT));
		occupationArea.add(createTextLabel("Área de Ocupação: " + job.getOccupationArea()));
		
		JPanel requirements = new JPanel(new FlowLayout(FlowLayout.LEFT));
		requirements.add(createTextLabel("Requisitos: " + job.getRequirements()));
		
		JPanel buttons = new JPanel();
        buttons.add(this.updateButton);
        buttons.add(this.deleteButton);

        this.panel.add(name);
		this.panel.add(salary);
		this.panel.add(modality);
		this.panel.add(workload);
		this.panel.add(occupationArea);
		this.panel.add(requirements);
		
		if (type == "employer") {
		this.panel.add(buttons);
		}
		
		this.add(panel);
		this.display();
	}
	
	private JLabel createTextLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(this.fontField);

        return label;
    }

	public static void main(String[] args) {
		Job job = new Job("Desenvolvedor Front-end", 2100, 8, "Remoto", "Tecnologia" );
		job.addRequirement("UML");
        job.addRequirement("OOP");
        job.addRequirement("Java");
        
		new JobDetailsScreen(job, "employee");

	}

}
