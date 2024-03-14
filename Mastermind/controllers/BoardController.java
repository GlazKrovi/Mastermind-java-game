package Mastermind.controllers;

import Mastermind.models.*;

import javax.swing.*;

public class BoardController {
    private IBoard model;

    public BoardController(IBoard model) {
        setModel(model);
    }

    public void setModel(IBoard model) {
        this.model = model;
    }

    public void nextTurn() {
        // already played the max of turns?
        if (this.model.getPlayer().getPlayedTurnsNumber() + 1 > this.model.getConfig().getMaxNbOfTurns()) {
            JOptionPane.showMessageDialog(null, "You already played all of your turns!");
        } else {
            // save infos
            this.model.getPlayer().setPlayedTurnsNumber(this.model.getPlayer().getPlayedTurnsNumber() + 1);
            this.model.getPlayer().setTotalScore(this.model.getPlayer().getTotalScore()
                    + this.model.getActualTurn().getScoreTotal()
                    + this.model.getConfig().getStrategyDraft().getScoreBonus());
            // create a new turn and pass to it
            createNewTurn();
        }
    }

    public void modifyBoardConfig(Player player, Difficulty difficulty, int secretCodeSize, int nbOfRounds, int nbOfColors, int maxNbOfTurn) {
        GameConfig newConfig = new GameConfig(player, difficulty, secretCodeSize, nbOfRounds, nbOfColors, maxNbOfTurn);
        this.model.setConfig(newConfig);
        this.model.setActualTurn(TurnBuilder.createTurn(newConfig));
    }

    private void createNewTurn() {
        this.model.setActualTurn(TurnBuilder.createTurn(this.model.getConfig()));

    }
}
