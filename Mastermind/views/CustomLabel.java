package Mastermind.views;

import javax.swing.*;
import java.awt.*;

public class CustomLabel extends JLabel {
    public CustomLabel(String text) {
        super(text);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }
}
