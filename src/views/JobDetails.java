import java.awt.*;

import javax.swing.*;
import components.TextLabel;

public class JobDetails extends Screen{
	private final JPanel panel = new JPanel();
	private final JPanel title = new JPanel();
	private final JPanel content = new JPanel();
	
	public JobDetails(Job job) {
		super();
		
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.content.setLayout(new BoxLayout(this.content, BoxLayout.Y_AXIS));
		
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
		workload.add(new TextLabel("Carga Horária: " + job.getWorkload()));
		
		JPanel occupationArea = new JPanel(new FlowLayout(FlowLayout.LEFT));
		occupationArea.add(new TextLabel("Área de Ocupação: " + job.getOccupationArea()));
		
		JPanel requirements = new JPanel(new FlowLayout(FlowLayout.LEFT));
		requirements.add(new TextLabel("Requisitos: " + String.join(", ", job.getRequirements())));

        this.title.add(name);

		this.content.add(salary);
		this.content.add(modality);
		this.content.add(workload);
		this.content.add(occupationArea);
		this.content.add(requirements);		
		
		this.panel.add(title);
		this.panel.add(content);
		this.add(panel);
		this.display();
	}

	//public static void main(String[] args) {
	//	Job job = new Job("Desenvolvedor Front-end", 2100, 8, "Remoto", "Tecnologia" );
	//	job.addRequirement("UML");
    //    job.addRequirement("OOP");
    //    job.addRequirement("Java");
        
	//	new JobDetailsScreen(job);

	//}

}
