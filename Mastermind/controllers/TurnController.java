package Mastermind.controllers;

import Mastermind.models.*;

public class TurnController {
    private int turnNumber;
    private ITurn model;
    private IRound currentRound;

    public TurnController(ITurn model) {
        this.model = model;
        this.currentRound = this.model.getRounds().get(0);
        this.turnNumber = 0;
    }

    public void nextRound() {
        turnNumber++;
        this.currentRound = this.model.getRounds().get(turnNumber);
        model.setCurrentRound(currentRound);
        modifyScore();
    }

    private void modifyScore() {
        int score = this.model.getScoreTotal();
        for (int i = 0; i < this.model.getRounds().size(); i++) {
            score += this.model.getRounds().get(i).getScore();
        }
        this.model.setScore(score);
    }

    public void setModel(ITurn model) {
        this.turnNumber = 0;
        this.model = model;
    }

    public void resetAttempt() {
        PlayerPawn[] playerPawn = new PlayerPawn[model.getSecretCodeSize()];
        for (int i = 0; i < model.getSecretCodeSize(); i++) {
            playerPawn[i] = new PlayerPawn(PawnColor.WHITE);
        }
        this.currentRound.setAttempt(new Attempt(playerPawn));
    }
}
