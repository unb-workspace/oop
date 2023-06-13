import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    private final JPanel header = new JPanel();
    Color headerColor = new Color(75, 44, 44);
    Color backgroundColor = new Color(217, 217, 217);
    ImageIcon logo = new ImageIcon("src/resources/images/linked_out_logo.png");

    public Screen(String title) {
           super("LinkedOut - " + title);
           this.setDefaultFrame();
           this.setHeaderText(title);
           this.createLogoButton();
    }

    public Screen() {
        super("LinkedOut");
        this.setDefaultFrame();
        this.createLogoButton();
    }

    private void setDefaultFrame() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setResizable(false);
        this.getContentPane().setBackground(this.backgroundColor);

        header.setBackground(this.headerColor);
        header.setPreferredSize(new Dimension(720, 100));
        header.setLayout(new GridBagLayout());

        this.add(header, BorderLayout.PAGE_START);
    }

    private void setHeaderText(String title) {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.anchor = GridBagConstraints.CENTER;
        constraint.weightx = 1.0;
        constraint.weighty = 1.0;

        JLabel text = new JLabel(title);

        text.setFont(new Font("Regular", Font.BOLD, 30));
        text.setForeground(Color.WHITE);

        header.add(text, constraint);
    }

    public void createLogoButton() {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.anchor = GridBagConstraints.EAST;

        JButton button = new JButton(logo);
        button.setBackground(this.backgroundColor);
        button.setBorder(BorderFactory.createEmptyBorder());

        header.add(button, constraint);
    }

    public void display() {
        this.setVisible(true);
    }
}
