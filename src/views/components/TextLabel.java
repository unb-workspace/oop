package views.components;

import javax.swing.*;
import java.awt.*;

public class TextLabel extends JLabel {    
    public TextLabel(String text) {
        super(text);
        this.setFont(new Font("Arial", Font.BOLD, 15));
    }
}
