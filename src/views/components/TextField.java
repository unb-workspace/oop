package components;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class TextField extends JTextField {
	
	public TextField() {
		super();
		this.setPreferredSize(new Dimension(200, 30));
		this.setBackground(new Color(199, 194, 194));
		this.setFont(new Font("Arial", Font.BOLD, 15));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	
}
