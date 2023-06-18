import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    protected final JPanel header = new JPanel();
    
    ImageIcon logo = new ImageIcon("src/resources/images/linked_out_logo.png");
    Color headerColor = new Color(75, 44, 44);
    Color backgroundColor = new Color(217, 217, 217);

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
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
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

    private void createLogoButton() {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.anchor = GridBagConstraints.EAST;

        JButton button = new JButton(logo);
        button.setBackground(this.backgroundColor);
        button.setBorder(BorderFactory.createEmptyBorder());

        header.add(button, constraint);
    }

    protected void displayWarning(String warning) {
        JOptionPane.showMessageDialog(this, warning, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    public void display() {
        this.setVisible(true);
    }
}
