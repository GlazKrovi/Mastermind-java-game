package Mastermind.views;

import javax.swing.*;

public abstract class RawPanel extends JPanel {
    protected RawPanel(String title) {
        this.setVisible(true);
        this.setSize(500, 500);
    }
}
