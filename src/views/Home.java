import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import components.Button;
import components.TextLabel;

public class Home extends Screen {
    Color colorField = new Color(199, 194, 194);
    Dimension textFieldSize = new Dimension(200, 30);

    private final Button employerButton = new Button("Empregador");
    private final Button employeeButton = new Button("Empregado");
    private final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JLabel pageText = new JLabel();

    public Home() {
        super();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.pageText.setPreferredSize(this.textFieldSize);
        this.pageText.setBackground(this.colorField);
        this.pageText.setBorder(BorderFactory.createEmptyBorder());

        this.employeeButton.setPreferredSize(this.textFieldSize);
        this.employerButton.setPreferredSize(this.textFieldSize);

        JPanel mainTextPanel = new JPanel();
        mainTextPanel.add(new TextLabel("Deseja um emprego ou contratar novos colaboradores? Comece já!"));
        mainTextPanel.add(this.pageText, BorderLayout.PAGE_START);

        JPanel buttonsPanel = new JPanel();
        this.employeeButton.addActionListener(this::chooseUserType);
        this.employerButton.addActionListener(this::chooseUserType);
        buttonsPanel.add(this.employeeButton, BorderLayout.PAGE_START);
        buttonsPanel.add(this.employerButton);

        this.panel.add(mainTextPanel);
        this.panel.add(buttonsPanel);

        this.add(panel);
        this.disableButton();
        this.display();
    }

    private void chooseUserType(ActionEvent event) {
        if(event.getSource() == this.employeeButton) {
            new SearchJobs("employee");
        } else if(event.getSource() == this.employerButton) {
            new SearchJobs("employer");
        }

        this.dispose();
    }
}
