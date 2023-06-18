import java.awt.*;

import javax.swing.*;

import components.Button;
import components.TextField;

public class JobDetailsAdmScreen extends Screen{
	Font fontField = new Font("Arial", Font.BOLD, 15);
	private final JPanel panel = new JPanel();
	private final JPanel title = new JPanel();
	private final JPanel content = new JPanel();
	private final Button updateButton = new Button("Salvar");
	private final Button deleteButton = new Button("Excluir");
	private final TextField salaryField = new TextField();
	private final TextField modalityField = new TextField();
	private final TextField workloadField = new TextField();
	private final TextField occupationAreaField = new TextField();
	private final TextField requirementsField = new TextField();
	
	public JobDetailsAdmScreen(Job job) {
		super();
		
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.content.setLayout(new BoxLayout(this.content, BoxLayout.Y_AXIS));
		
		JPanel name = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel jobName = new JLabel(job.getName());
		name.setBackground(new Color(75, 44, 44));
		jobName.setFont(new Font("Regular", Font.BOLD, 20));
		jobName.setForeground(Color.WHITE);
		name.add(jobName);
		
		JPanel salary = new JPanel(new FlowLayout(FlowLayout.LEFT));
		salary.add(createTextLabel("Salário (em reais): "));
		salaryField.setText(Integer.toString(job.getSalary()));
		salary.add(salaryField);
		
		JPanel modality = new JPanel(new FlowLayout(FlowLayout.LEFT));
		modality.add(createTextLabel("Modalidade: "));
		modalityField.setText(job.getModality());
		modality.add(modalityField);
		
		JPanel workload = new JPanel(new FlowLayout(FlowLayout.LEFT));
		workload.add(createTextLabel("Carga Horária: "));
		workloadField.setText(Integer.toString(job.getWorkload()));
		workload.add(workloadField);
		
		JPanel occupationArea = new JPanel(new FlowLayout(FlowLayout.LEFT));
		occupationArea.add(createTextLabel("Área de Ocupação: "));
		occupationAreaField.setText(job.getOccupationArea());
		occupationArea.add(occupationAreaField);
		
		JPanel requirements = new JPanel(new FlowLayout(FlowLayout.LEFT));
		requirements.add(createTextLabel("Requisitos: "));
		requirementsField.setText(String.join(", ", job.getRequirements()));
		requirements.add(requirementsField);
		
		JPanel buttons = new JPanel();
        buttons.add(this.updateButton);
        buttons.add(this.deleteButton);

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
	
	private JLabel createTextLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(this.fontField);

        return label;
    }

	//public static void main(String[] args) {
	//	Job job = new Job("Desenvolvedor Front-end", 2100, 8, "Remoto", "Tecnologia" );
	//	job.addRequirement("UML");
    //    job.addRequirement("OOP");
    //    job.addRequirement("Java");
        
	//	new JobDetailsAdmScreen(job);

	//}

}