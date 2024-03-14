package Mastermind.views;

import Mastermind.models.Correction;

import javax.swing.*;
import java.awt.*;

public class BlockyCorrectionView extends CorrectionView {
    protected JLabel[] feedbackCircles;

    public BlockyCorrectionView(int size) {
        JPanel hintsPanel = new JPanel();
        hintsPanel.setLayout(new FlowLayout());
        feedbackCircles = new JLabel[size];
        for (int i = 0; i < size; i++) {
            feedbackCircles[i] = new JLabel();
            feedbackCircles[i].setPreferredSize(new Dimension(20, 20));
            feedbackCircles[i].setOpaque(true);
            feedbackCircles[i].setVisible(true);
            feedbackCircles[i].setBackground(Color.WHITE);
            feedbackCircles[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // Ajouter chaque label au panneau
            hintsPanel.add(feedbackCircles[i]);
        }

        // Ajouter le panneau au panel actuel
        add(hintsPanel);
    }

    public int getBlocksNumber() {
        return feedbackCircles.length;
    }

    public void setColors(Correction hint) {
        for (int i = 0; i < hint.size(); i++) {
            setOneColor(i, hint.get(i).getJColor());
        }
    }

    public void setOneColor(int pegIndex, Color color) {
        if (unable) {
            feedbackCircles[pegIndex].setBackground(color);
        }
    }
}
