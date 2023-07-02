package views.components;

import javax.swing.*;
import java.awt.*;

/**
 * Classe que representa um label de texto.
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.0
 */
public class TextLabel extends JLabel {  
    /**
     * Método construtor responsável pela criação de um label de texto.
     * @param text define o texto do label.
     */  
    public TextLabel(String text) {
        super(text);
        this.setFont(new Font("Arial", Font.BOLD, 15));
    }
}
