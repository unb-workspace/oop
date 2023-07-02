package views.components;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 * Classe que representa um campo de texto.
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.0
 */
public class TextField extends JTextField {
	/**
	 * Método construtor responsável pela criação de um campo de texto.
	 */
	public TextField() {
		super();
		this.setPreferredSize(new Dimension(200, 30));
		this.setBackground(new Color(199, 194, 194));
		this.setFont(new Font("Arial", Font.BOLD, 15));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
}
