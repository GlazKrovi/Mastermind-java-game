package Mastermind.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BlockButton extends CustomButton {
    public BlockButton(String text, ActionListener actionListener) {
        super(text, actionListener);
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        this.setButtonSize(35, 35);
    }
}
