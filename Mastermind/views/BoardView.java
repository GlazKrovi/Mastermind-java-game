package Mastermind.views;

import Mastermind.controllers.BoardController;
import Mastermind.controllers.TurnController;
import Mastermind.models.IBoard;
import Mastermind.models.IPlayer;
import Mastermind.models.ITurn;
import Mastermind.observers.IBoardObserver;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JPanel implements IBoardObserver {
    private final IBoard board;
    private final JLabel score;
    private final TurnController turnController;
    private final JLabel playerLabel;
    private final BoardController controller;
    private TurnView turnView;
    private int nbTurn;

    public BoardView(IBoard board, BoardController controller, Home home) {
        this.board = board;
        this.controller = controller;

        // init panel
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.X_AXIS));

        // create label for player name
        this.playerLabel = new CustomLabel(board.getPlayer().getName());
        playerPanel.add(playerLabel);
        playerPanel.add(Box.createHorizontalGlue());

        // create label for scoring
        score = new CustomLabel("Score : " + board.getPlayer().getTotalScore());
        playerPanel.add(score);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // create the playable view
        turnController = new TurnController(board.getActualTurn());
        turnView = new TurnView(board.getActualTurn(), turnController, this, controller);
        this.add(turnView);

        // create button to reset the combination
        JButton ResetCombinationButton = new CustomButton("Reset combination", e -> turnController.resetAttempt());
        this.add(ResetCombinationButton);

        // create button for next turn
        JButton NextTurnButton = new CustomButton("Next Turn", e -> controller.nextTurn());
        this.add(NextTurnButton);

        // create button for forfeit the turn
        JButton forfeitButton = new CustomButton("Forfeit", e -> {
            home.setVisible(true);
            this.setVisible(false);
        });
        this.add(forfeitButton);

        // add all in the window
        this.add(playerPanel);
    }

    @Override
    public void updatePlayer(IPlayer player) {
        this.playerLabel.setText(player.getName());
    }

    @Override
    public void updateActualTurn(ITurn turn) {
        turnController.setModel(turn);
        turnView = new TurnView(board.getActualTurn(), turnController, this, controller);
        this.add(turnView, 0);
        this.remove(1);
        revalidate();
        repaint();
        score.setText("Score : " + board.getPlayer().getTotalScore());
        this.nbTurn++;

        // set infos for end screen
        turnView.setInfos(board.getPlayer(),
                nbTurn >= this.board.getConfig().getMaxNbOfTurns());
    }

    public void hideAllExceptEnd() {
        for (Component component : this.getComponents()) {
            component.setVisible(false);
        }

        this.turnView.setVisible(true);
    }

    public void showAllExceptEnd() {
        for (Component component : this.getComponents()) {
            component.setVisible(true);
        }
    }
}
