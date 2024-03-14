package Mastermind.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CustomButton extends JButton {
    public CustomButton(String text, ActionListener actionListener) {
        super(text);
        this.addActionListener(actionListener);
        this.setAlignmentX(CENTER_ALIGNMENT);
        setButtonSize(150, 30);
    }

    public void setButtonSize(int width, int height) {
        Dimension size = new Dimension(width, height);
        this.setPreferredSize(size);
        this.setMaximumSize(size);
    }
}