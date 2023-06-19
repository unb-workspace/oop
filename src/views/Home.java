import javax.swing.*;
import java.awt.*;

public class Home extends Screen {
    Font fontField = new Font("Arial",Font.BOLD,15 );
    Color colorField = new Color(199, 194, 194);
    Dimension textFieldSize = new Dimension(200, 30);
    private final JButton employerButton = new JButton("Empregador");
    private final JButton employeeButton = new JButton("Empregado");
    private final JPanel panel = new JPanel();
    private final JLabel pageText = new JLabel();

    public Home() {
        super("LINKEDOUT");
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.pageText.setPreferredSize(this.textFieldSize);

        this.pageText.setBackground(this.colorField);
        this.employeeButton.setBackground(this.headerColor);
        this.employerButton.setBackground(this.headerColor);

        this.pageText.setBorder(BorderFactory.createEmptyBorder());
        this.employeeButton.setBorder(BorderFactory.createEmptyBorder());
        this.employerButton.setBorder(BorderFactory.createEmptyBorder());

        JPanel mainTextPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainTextPanel.add(createTextLabel("Deseja um emprego ou contratar novos colaboradores? Comece já!"));
        mainTextPanel.add(this.pageText);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.employeeButton.setForeground(this.backgroundColor);
        this.employeeButton.setFont(new Font("Arial", Font.BOLD, 17));
        this.employeeButton.setBorder(BorderFactory.createEmptyBorder());
        this.employeeButton.setPreferredSize(new Dimension(100, 30));
        this.employerButton.setForeground(this.backgroundColor);
        this.employerButton.setFont(new Font("Arial", Font.BOLD, 17));
        this.employerButton.setBorder(BorderFactory.createEmptyBorder());
        this.employerButton.setPreferredSize(new Dimension(100, 30));
//        this.employeeButton.addActionListener(this::);
//        this.employerButton.addActionListener(this::);
        buttonsPanel.add(this.employeeButton);
        buttonsPanel.add(this.employerButton);

        this.panel.add(mainTextPanel);
        this.panel.add(buttonsPanel);

        this.add(panel);
        this.display();
    }

    private JLabel createTextLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(this.fontField);

        return label;
    }
//    public static void main(String args[]){
//        new HomeScreen();
//    }


}
