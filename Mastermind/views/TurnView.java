package Mastermind.views;

import Mastermind.controllers.BoardController;
import Mastermind.controllers.RoundController;
import Mastermind.controllers.TurnController;
import Mastermind.models.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TurnView extends JPanel {
    private final List<RoundView> roundViews;
    private final BoardView boardView;
    private final BoardController boardController;
    private RoundView actualRoundView;
    private IPlayer player;
    private boolean isLastTurn;

    public TurnView(ITurn turn, TurnController turnController, BoardView boardView, BoardController boardController) {
        player = new Player();
        isLastTurn = false;
        this.boardView = boardView;
        this.boardController = boardController;

        this.roundViews = new ArrayList<>();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Deduce the strategy to adopt
        CorrectionStrategy strategy;
        Difficulty difficulty = turn.getDifficulty();
        if (difficulty == Difficulty.Classic) strategy = new ClassicStrategy();
        else if (difficulty == Difficulty.Numeric) strategy = new NumericStrategy();
        else strategy = new EasyStrategy();

        // Add RoundViews first
        RoundController roundController = new RoundController(turn.getCurrentRound());
        for (int i = 0; i < turn.getRounds().size(); i++) {
            RoundView roundView = new RoundView(turn.getRounds().get(i), roundController, strategy);
            turn.getRounds().get(i).addObserver(roundView);
            roundViews.add(roundView);
            this.add(roundViews.get(i));
        }
        actualRoundView = roundViews.getFirst();

        // create palette
        Color[] colors = new Color[turn.getNbOfColors()];
        for (int i = 0; i < turn.getNbOfColors(); i++) {
            colors[i] = Pawn.getEnumJColor(i);
        }
        ColorChooser colorChooser = new ColorChooser(colors);
        colorChooser.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button
        colorChooser.setMaximumSize(colorChooser.getPreferredSize()); // Limit the button size
        this.add(colorChooser);

        // create mediator
        IColorMediator mediator = new ColorMediator();
        mediator.setRoundView(actualRoundView);
        colorChooser.setMediator(mediator);

        // create a button for check user's answer
        CustomButton revealButton = new CustomButton("Reveal", e -> {
            for (int i = 0; i < turn.getCurrentRound().getAttempt().size(); i++) {
                if (turn.getCurrentRound().getAttempt().get(i).getPColor() == PawnColor.WHITE) {
                    JOptionPane.showMessageDialog(null, "You have to fill all the circles");
                    return;
                }
            }
            if (turn.getRounds().indexOf(turn.getCurrentRound()) == turn.getRounds().size() - 1) {
                roundController.check(turn.getSecretCode());
                passToEnd(false, player, turn.getCurrentRound().getScore(), isLastTurn);
                return;
            }
            roundController.check(turn.getSecretCode());
            if (turn.getCurrentRound().getScore() == 12) {
                passToEnd(true, player, turn.getCurrentRound().getScore(), isLastTurn);
            } else {
                turnController.nextRound();
                roundController.setModel(turn.getCurrentRound());
                nextRound();
                mediator.setRoundView(actualRoundView);
            }
        });
        this.add(revealButton);
    }

    public void hideAll() {
        for (Component component : this.getComponents()) {
            component.setVisible(false);
        }
    }

    public void showAll() {
        for (Component component : this.getComponents()) {
            component.setVisible(true);
        }
    }

    public void setInfos(IPlayer player, boolean isLastTurn) {
        this.player = player;
        this.isLastTurn = isLastTurn;
    }

    private void passToEnd(boolean win, IPlayer player, int score, boolean lastTurn) {
        // init end screen
        End end = new End(win, player, score, lastTurn);
        end.nextTurnButton.addActionListener(e -> {
            showAll();
            boardView.showAllExceptEnd();
            this.remove(end);
            boardController.nextTurn();
        });
        this.add(end);

        // hide all others
        hideAll();
        boardView.hideAllExceptEnd();
        end.setVisible(true);
    }


    private void nextRound() {
        actualRoundView = roundViews.get(roundViews.indexOf(actualRoundView) + 1);
    }
}
