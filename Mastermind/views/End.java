package Mastermind.views;

import Mastermind.models.IPlayer;

import javax.swing.*;
import java.awt.*;

public class End extends JPanel {
    public final CustomButton nextTurnButton;

    public End(boolean win, IPlayer player, int score, boolean lastTurn) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        CustomLabel resultLabel = new CustomLabel(win ? "You win the turn!" : "You lose!");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setBorder(BorderFactory.createEmptyBorder(100, 0, 50, 0));
        add(resultLabel, BorderLayout.NORTH);

        CustomLabel scoreLabel = new CustomLabel(player.getName() + ", your score for this turn is: " + score);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(scoreLabel, BorderLayout.CENTER);

        CustomLabel totalScoreLabel = new CustomLabel("Total Score: " + player.getTotalScore());
        totalScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalScoreLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        add(totalScoreLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        nextTurnButton = new CustomButton("Next Turn", null);
        buttonPanel.add(nextTurnButton);

        CustomButton quitButton = new CustomButton("Quit Game", e -> {
            System.exit(0);
        });
        buttonPanel.add(quitButton);

        add(buttonPanel, BorderLayout.SOUTH);

        if (lastTurn) {
            nextTurnButton.setVisible(false);
        }
    }
}
