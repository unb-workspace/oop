package views.components;

import javax.swing.*;
import java.awt.*;

public class ComboBox extends JComboBox<Object> {
    public ComboBox(Object[] values) {
        super(values);
        this.setBackground(new Color(199, 194, 194));
        this.setBorder(BorderFactory.createEmptyBorder());
    }
}
