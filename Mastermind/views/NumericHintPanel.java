package Mastermind.views;

import javax.swing.*;
import java.awt.*;

public class NumericHintPanel extends CorrectionView {
    private final JLabel rightsLabel;
    private final JLabel wrongsLabel;

    public NumericHintPanel() {
        this.setLayout(new FlowLayout());

        // create labels
        rightsLabel = new JLabel("Rights: 0");
        wrongsLabel = new JLabel("Wrongs: 0");

        // add them
        this.add(rightsLabel);
        this.add(wrongsLabel);

        // block modifications
        unable = false;
    }

    public void setRightsNumber(int number) {
        if (unable) {
            rightsLabel.setText("Rights: " + number);
        }
    }

    public void setWrongsNumber(int number) {
        if (unable) {
            wrongsLabel.setText("Wrongs: " + number);
        }
    }
}
