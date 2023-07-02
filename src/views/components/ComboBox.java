package views.components;

import javax.swing.*;
import java.awt.*;

/**
 * Classe que representa um ComboBox (uma lista estilo drop-down). 
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.0
 */
public class ComboBox extends JComboBox<Object> {
    /**
     * Método construtor responsável pela criação de um ComboBox.
     * @param values define os valores de listagem do ComboBox.
     */
    public ComboBox(Object[] values) {
        super(values);
        this.setBackground(new Color(199, 194, 194));
        this.setBorder(BorderFactory.createEmptyBorder());
    }
}
