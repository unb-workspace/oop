package views;

import javax.swing.*;
import java.awt.*;

/**
 * Classe responsável pela criação de telas principal.
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.0 
 */
public class Screen extends JFrame {
    protected final JPanel header = new JPanel();
    private boolean buttonEnabled = true;

    ImageIcon logo = new ImageIcon("src/resources/images/linked_out_logo.png");
    ImageIcon success = new ImageIcon(new ImageIcon("src/resources/images/success_icon.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));

    Color headerColor = new Color(75, 44, 44);
    Color backgroundColor = new Color(217, 217, 217);
    Insets insets = new Insets(7, 7, 7, 7);

    /**
     * Método construtor responsável pela inicialização da tela principal.
     * @param title define o título da tela.
     */
    public Screen(String title) {
        super("LinkedOut - " + title);
        this.setDefaultFrame();
        this.setHeaderText(title);
        this.createLogoButton();
    }

    /**
     * Método construtor responsável pela inicialização da tela principal.
     */
    public Screen() {
        super("LinkedOut");
        this.setDefaultFrame();
        this.setHeaderText("");
        this.createLogoButton();
    }

    /**
     * Método responsável por desativar o botão para voltar para a tela "Home".
     */
    protected void disableButton() {
        this.buttonEnabled = false;
    }

    /**
     * Método responsável por criar o estilo da tela.
     */
    private void setDefaultFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(this.backgroundColor);
        this.setLayout(new BorderLayout());

        header.setBackground(this.headerColor);
        header.setPreferredSize(new Dimension(720, 100));
        header.setLayout(new GridBagLayout());

        this.add(header, BorderLayout.PAGE_START);
    }

    /**
     * Método responsável por criar o título da tela.
     * @param title define o título da tela.
     */
    private void setHeaderText(String title) {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.anchor = GridBagConstraints.CENTER;
        constraint.weightx = 1.0;
        constraint.weighty = 1.0;
        constraint.gridx = 5;
        constraint.insets = insets;

        JLabel text = new JLabel(title);
        text.setFont(new Font("Regular", Font.BOLD, 30));
        text.setForeground(Color.WHITE);

        header.add(text, constraint);
    }

    /**
     * Método responsável por criar o botão para voltar para a tela "Home".
     */
    private void createLogoButton() {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.anchor = GridBagConstraints.EAST;
        constraint.insets = insets;

        JButton button = new JButton(logo);
        button.setBackground(this.backgroundColor);
        button.setBorder(BorderFactory.createEmptyBorder());
        
            button.addActionListener(event -> {
                if(this.buttonEnabled) {
                    new Home();
                    this.dispose();
                }
            });

        header.add(button, constraint);
    }

    /**
     * Método responsável por mostrar um aviso na tela do usuário.
     * @param warning define o aviso a ser mostrado.
     */
    protected void displayWarning(String warning) {
        JOptionPane.showMessageDialog(this, warning, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Método responsável por mostrar uma mensagem de sucesso na tela do usuário.
     * <p>Aviso</p>
     * Ao utilizar este método, o usuário voltará para a tela de busca de emprego.
     * @param userType define o tipo de usuário que está usando o sistema.
     */
    protected void displaySuccess(String userType) {        
        JOptionPane.showMessageDialog(this, "Operação feita com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE, success);
        new SearchJobs(userType);
        this.dispose();
    }

    /**
     * Método responsável por mostrar a tela.
     */
    public void display() {
        this.setVisible(true);
    }
}