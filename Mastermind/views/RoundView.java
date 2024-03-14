package Mastermind.views;

import Mastermind.controllers.RoundController;
import Mastermind.models.Attempt;
import Mastermind.models.Correction;
import Mastermind.models.IRound;
import Mastermind.models.PlayerPawn;
import Mastermind.observers.IRoundObserver;

import javax.swing.*;
import java.awt.*;

public class RoundView extends JPanel implements IRoundObserver {
    private final CorrectionStrategy hintsFormat;
    private final RoundController controller;
    private int indexButtonClicked = 0;
    private JButton[] guessCircles;

    public RoundView(IRound round, RoundController controller, CorrectionStrategy hintsFormat) {
        this.controller = controller;
        this.hintsFormat = hintsFormat;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initializeGuessCircles(round.getAttempt().size());
        initializeFeedbackCircles(round.getHints().size(), hintsFormat);
        setAllAttemptsColors(round.getAttempt());
        updateHints(round.getHints());
    }

    private void initializeGuessCircles(int numPegs) {
        JPanel guessPanel = new JPanel();
        guessPanel.setLayout(new FlowLayout());
        guessCircles = new BlockButton[numPegs]; // Utilisez BlockButton au lieu de JButton
        for (int i = 0; i < numPegs; i++) {
            guessCircles[i] = createStyledButton();
            guessCircles[i].setActionCommand(String.valueOf(i));
            guessCircles[i].addActionListener(e -> {
                indexButtonClicked = Integer.parseInt(e.getActionCommand());
            });
            guessPanel.add(guessCircles[i]);
        }
        add(guessPanel);
    }

    private BlockButton createStyledButton() {
        BlockButton button = new BlockButton("", e -> {
        }); // Utilisez BlockButton au lieu de JButton
        button.setPreferredSize(new Dimension(50, 50));
        button.setOpaque(true);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        // Ajoutez l'effet de survol de la souris ici si nécessaire
        return button;
    }

    private void initializeFeedbackCircles(int size, CorrectionStrategy strategy) {
        JPanel feedbackPanel = strategy.execute(size);
        feedbackPanel.setVisible(true);
        add(feedbackPanel);
    }

    // Methods to update guess and feedback colors
    public void setGuessColor(int pegIndex, Color color) {
        guessCircles[pegIndex].setBackground(color);
    }

    private void setAllAttemptsColors(Attempt attempt) {
        for (int i = 0; i < attempt.size(); i++) {
            setGuessColor(i, attempt.get(i).getJColor());
        }
    }

    @Override
    public void updateOneAttempt(PlayerPawn attemptPawn) {
        controller.modifyAttemptAt(attemptPawn, indexButtonClicked);
    }

    @Override
    public void updateOneAttempt(Attempt attempt) {
        setAllAttemptsColors(attempt);
    }

    @Override
    public void updateHints(Correction hints) {
        hintsFormat.update(hints);
    }
}


