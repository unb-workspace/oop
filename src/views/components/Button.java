package views.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/** 
 * Classe que representa um botão.
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.0
 */
public class Button extends JButton {
	/**
	 * Método construtor responsável pela criação de um botão.
	 * @param text define o texto do botão.
	 */
	public Button(String text) {
		super(text);
		this.setBackground(new Color(75, 44, 44));
		this.setForeground(new Color(217, 217, 217));
        this.setFont(new Font("Arial", Font.BOLD, 17));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setPreferredSize(new Dimension(80, 30));
	}
}
