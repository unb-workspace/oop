package gui;

import main.Main;

import javax.swing.*;

import java.awt.Color;
import java.awt.Container;

public class LoginInterface extends JFrame {
    //private final JTextField userField;
    //private final JPasswordField userPassword;
    private final JFrame frame;

    public LoginInterface() {
        super();

        JFrame frame = createFrame();
        JLabel logo = createLogo();

        frame.add(logo);

        this.frame = frame;
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame();

        frame.setTitle("Login - LinkedOut");
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = frame.getContentPane();
        container.setBackground(Color.DARK_GRAY);

        return frame;
    }

    private JLabel createLogo() {
        ImageIcon linked_out_icon = new ImageIcon(Main.getUserDirectory() + "/src/resources/images/linked_out_logo.png");
        JLabel logo = new JLabel();

        logo.setIcon(linked_out_icon);
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setVerticalAlignment(SwingConstants.TOP);
        logo.setVisible(true);

        return logo;
    }

    public void show() {
        this.frame.setVisible(true);
    }
}
